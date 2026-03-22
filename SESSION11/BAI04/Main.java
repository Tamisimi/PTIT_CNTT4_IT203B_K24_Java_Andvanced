package SESSION11.BAI04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên bệnh nhân cần tìm: ");
        String patientName = sc.nextLine();

        String safeName = sanitizeInput(patientName);

        String sql = "SELECT * FROM Patients WHERE full_name = '" + safeName + "'";
        System.out.println("Câu lệnh SQL an toàn sẽ chạy: " + sql);

    }

    private static String sanitizeInput(String input) {
        if (input == null) return "";
        return input.replace("'", "")
                .replace(";", "")
                .replace("--", "");
    }
}
