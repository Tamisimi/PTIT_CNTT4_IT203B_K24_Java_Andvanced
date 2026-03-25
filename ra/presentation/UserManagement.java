package ra.presentation;

import ra.business.UserBusiness;
import ra.entity.User;

import java.util.Scanner;

public class UserManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserBusiness business = UserBusiness.getInstance();

        while (true) {
            System.out.println("\n********************* QUẢN LÝ NGƯỜI DÙNG *******************");
            System.out.println("1. Hiển thị danh sách toàn bộ người dùng");
            System.out.println("2. Thêm mới người dùng");
            System.out.println("3. Cập nhật thông tin người dùng theo mã");
            System.out.println("4. Xóa người dùng theo mã");
            System.out.println("5. Tìm kiếm người dùng theo tên");
            System.out.println("6. Lọc danh sách người dùng ADMIN");
            System.out.println("7. Sắp xếp danh sách theo điểm đánh giá giảm dần");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1" -> business.displayAll();

                case "2" -> {
                    while (true) {
                        User u = new User();
                        u.inputData(sc);
                        business.addUser(u);

                        System.out.print("Tiếp tục thêm người dùng? (y/n): ");
                        if (!sc.nextLine().trim().equalsIgnoreCase("y")) {
                            break;
                        }
                    }
                }

                case "3" -> {
                    System.out.print("Nhập mã người dùng cần cập nhật: ");
                    String id = sc.nextLine().trim();
                    business.updateUser(id, sc);
                }

                case "4" -> {
                    System.out.print("Nhập mã người dùng cần xóa: ");
                    String id = sc.nextLine().trim();
                    business.deleteUser(id);
                }

                case "5" -> {
                    System.out.print("Nhập tên cần tìm: ");
                    String name = sc.nextLine().trim();
                    business.searchByName(name);
                }

                case "6" -> business.filterAdmin();

                case "7" -> business.sortByScoreDesc();

                case "8" -> {
                    System.out.println("Tạm biệt!");
                    sc.close();
                    return;
                }

                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}