package ra.entity;

import java.util.Scanner;

public class User {
    private String userId;
    private String userName;
    private int age;
    private String role;      // "USER" hoặc "ADMIN"
    private double score;     // 0.0 -> 10.0

    public User() {
    }

    public User(String userId, String userName, int age, String role, double score) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.role = role;
        this.score = score;
    }

    // Getters & Setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }

    public void inputData(Scanner sc) {
        System.out.print("Nhập mã người dùng (Uxxx): ");
        while (true) {
            String id = sc.nextLine().trim().toUpperCase();
            if (id.matches("U\\d{3}")) {
                this.userId = id;
                break;
            }
            System.out.print("Mã không hợp lệ (U001, U002,...). Nhập lại: ");
        }

        System.out.print("Nhập tên người dùng: ");
        this.userName = sc.nextLine().trim();

        System.out.print("Nhập tuổi: ");
        while (true) {
            try {
                int a = Integer.parseInt(sc.nextLine().trim());
                if (a >= 18) {
                    this.age = a;
                    break;
                }
                System.out.print("Tuổi phải >= 18. Nhập lại: ");
            } catch (NumberFormatException e) {
                System.out.print("Vui lòng nhập số nguyên. Nhập lại: ");
            }
        }

        System.out.print("Nhập vai trò (USER/ADMIN): ");
        while (true) {
            String r = sc.nextLine().trim().toUpperCase();
            if (r.equals("USER") || r.equals("ADMIN")) {
                this.role = r;
                break;
            }
            System.out.print("Chỉ nhận USER hoặc ADMIN. Nhập lại: ");
        }

        System.out.print("Nhập điểm đánh giá (0.0 - 10.0): ");
        while (true) {
            try {
                double s = Double.parseDouble(sc.nextLine().trim());
                if (s >= 0 && s <= 10) {
                    this.score = s;
                    break;
                }
                System.out.print("Điểm phải từ 0.0 đến 10.0. Nhập lại: ");
            } catch (NumberFormatException e) {
                System.out.print("Vui lòng nhập số thực. Nhập lại: ");
            }
        }
    }

    public void displayData() {
        System.out.printf("| %-6s | %-20s | %4d | %-6s | %5.2f |\n",
                userId, userName, age, role, score);
    }
}