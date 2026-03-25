package KiemTraDauGio_Session14;

import java.sql.*;

public class TransferService {

    public void transfer(String fromAccountId, String toAccountId, double amount) {
        if (amount <= 0) {
            System.out.println("Số tiền chuyển phải lớn hơn 0.");
            return;
        }

        try (Connection conn = DatabaseUtil.getConnection()) {

            conn.setAutoCommit(false);  

            try {
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

                try (CallableStatement csDebit = conn.prepareCall("{call sp_UpdateBalance(?, ?)}")) {
                    csDebit.setString(1, fromAccountId);
                    csDebit.setDouble(2, -amount);
                    csDebit.executeUpdate();
                }

                try (CallableStatement csCredit = conn.prepareCall("{call sp_UpdateBalance(?, ?)}")) {
                    csCredit.setString(1, toAccountId);
                    csCredit.setDouble(2, amount);
                    csCredit.executeUpdate();
                }

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

    public void printAccounts() {
        String sql = "SELECT AccountId, FullName, Balance FROM Accounts ORDER BY AccountId";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\DANH SÁCH TÀI KHOẢN SAU CHUYỂN KHOẢN");
            System.out.printf("%-10s %-20s %15s%n", "AccountId", "FullName", "Balance");

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
