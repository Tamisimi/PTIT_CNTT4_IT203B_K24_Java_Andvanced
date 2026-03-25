package KiemTraDauGio_Session14;

import java.sql.*;

public class TransferService {

    public void transfer(String fromAccountId, String toAccountId, double amount) {
        if (amount <= 0) {
            System.out.println("Số tiền chuyển phải lớn hơn 0.");
            return;
        }

        try (Connection conn = DatabaseUtil.getConnection()) {

            conn.setAutoCommit(false);   // Bắt đầu transaction

            try {
                // 1. Kiểm tra tài khoản gửi tồn tại và đủ tiền (PreparedStatement)
                String checkSql = "SELECT Balance FROM Accounts WHERE AccountId = ?";
                try (PreparedStatement psCheck = conn.prepareStatement(checkSql)) {
                    psCheck.setString(1, fromAccountId);
                    try (ResultSet rs = psCheck.executeQuery()) {
                        if (!rs.next()) {
                            throw new SQLException("Tài khoản gửi không tồn tại: " + fromAccountId);
                        }
                        double currentBalance = rs.getDouble("Balance");
                        if (currentBalance < amount) {
                            throw new SQLException("Số dư không đủ. Hiện có: " + currentBalance);
                        }
                    }
                }

                // 2. Gọi Stored Procedure trừ tiền người gửi (amount âm)
                try (CallableStatement csDebit = conn.prepareCall("{call sp_UpdateBalance(?, ?)}")) {
                    csDebit.setString(1, fromAccountId);
                    csDebit.setDouble(2, -amount);
                    csDebit.executeUpdate();
                }

                // 3. Gọi Stored Procedure cộng tiền người nhận (amount dương)
                try (CallableStatement csCredit = conn.prepareCall("{call sp_UpdateBalance(?, ?)}")) {
                    csCredit.setString(1, toAccountId);
                    csCredit.setDouble(2, amount);
                    csCredit.executeUpdate();
                }

                // 4. Commit nếu thành công
                conn.commit();
                System.out.println("Chuyển khoản thành công: " + amount + " từ " + fromAccountId + " sang " + toAccountId);

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Chuyển khoản thất bại - Đã rollback: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Lỗi kết nối database: " + e.getMessage());
        }
    }

    // Hiển thị kết quả cuối cùng (yêu cầu dùng PreparedStatement)
    public void printAccounts() {
        String sql = "SELECT AccountId, FullName, Balance FROM Accounts ORDER BY AccountId";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n=== DANH SÁCH TÀI KHOẢN SAU CHUYỂN KHOẢN ===");
            System.out.printf("%-10s %-20s %15s%n", "AccountId", "FullName", "Balance");
            System.out.println("-----------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-10s %-20s %15.2f%n",
                        rs.getString("AccountId"),
                        rs.getString("FullName"),
                        rs.getDouble("Balance"));
            }

        } catch (SQLException e) {
            System.out.println("Lỗi hiển thị danh sách: " + e.getMessage());
        }
    }
}