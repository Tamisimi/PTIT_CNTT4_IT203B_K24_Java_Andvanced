package ra.business;

import ra.entity.User;

import java.util.*;
import java.util.stream.Collectors;

public class UserBusiness {
    private static UserBusiness instance;
    private final List<User> users = new ArrayList<>();

    private UserBusiness() {
    }

    public static UserBusiness getInstance() {
        if (instance == null) {
            instance = new UserBusiness();
        }
        return instance;
    }

    public List<User> getUsers() {
        return users;
    }

    // 1. Hiển thị danh sách
    public void displayAll() {
        if (users.isEmpty()) {
            System.out.println("Danh sách người dùng hiện đang rỗng!");
            return;
        }

        printHeader();
        users.forEach(User::displayData);
        System.out.println("=".repeat(60));
    }

    private void printHeader() {
        System.out.println("=".repeat(60));
        System.out.printf("| %-6s | %-20s | %4s | %-6s | %5s |\n",
                "ID", "Tên", "Tuổi", "Vai trò", "Điểm");
        System.out.println("-".repeat(60));
    }

    // 2. Thêm người dùng
    public void addUser(User user) {
        boolean exists = users.stream()
                .anyMatch(u -> u.getUserId().equalsIgnoreCase(user.getUserId()));

        if (exists) {
            System.out.println("Mã người dùng đã tồn tại: " + user.getUserId());
            return;
        }
        users.add(user);
        System.out.println("Thêm người dùng thành công: " + user.getUserId());
    }

    // 3. Cập nhật (trả về Optional để kiểm tra tồn tại)
    public Optional<User> findById(String userId) {
        return users.stream()
                .filter(u -> u.getUserId().equalsIgnoreCase(userId))
                .findFirst();
    }

    public void updateUser(String userId, Scanner sc) {
        Optional<User> opt = findById(userId);
        if (opt.isEmpty()) {
            System.out.println("Mã người dùng không tồn tại trong hệ thống");
            return;
        }

        User u = opt.get();
        System.out.println("Thông tin hiện tại:");
        printHeader();
        u.displayData();

        System.out.println("\nChọn thông tin muốn cập nhật:");
        System.out.println("1. Tên");
        System.out.println("2. Tuổi");
        System.out.println("3. Vai trò");
        System.out.println("4. Điểm đánh giá");
        System.out.print("Lựa chọn: ");

        String choice = sc.nextLine().trim();

        switch (choice) {
            case "1" -> {
                System.out.print("Tên mới: ");
                u.setUserName(sc.nextLine().trim());
            }
            case "2" -> {
                System.out.print("Tuổi mới (>=18): ");
                while (true) {
                    try {
                        int age = Integer.parseInt(sc.nextLine().trim());
                        if (age >= 18) {
                            u.setAge(age);
                            break;
                        }
                        System.out.print("Tuổi phải >=18. Nhập lại: ");
                    } catch (Exception e) {
                        System.out.print("Nhập số nguyên. Nhập lại: ");
                    }
                }
            }
            case "3" -> {
                System.out.print("Vai trò mới (USER/ADMIN): ");
                while (true) {
                    String r = sc.nextLine().trim().toUpperCase();
                    if (r.equals("USER") || r.equals("ADMIN")) {
                        u.setRole(r);
                        break;
                    }
                    System.out.print("Chỉ nhận USER/ADMIN. Nhập lại: ");
                }
            }
            case "4" -> {
                System.out.print("Điểm mới (0.0-10.0): ");
                while (true) {
                    try {
                        double s = Double.parseDouble(sc.nextLine().trim());
                        if (s >= 0 && s <= 10) {
                            u.setScore(s);
                            break;
                        }
                        System.out.print("Từ 0.0 đến 10.0. Nhập lại: ");
                    } catch (Exception e) {
                        System.out.print("Nhập số thực. Nhập lại: ");
                    }
                }
            }
            default -> System.out.println("Lựa chọn không hợp lệ.");
        }

        System.out.println("Cập nhật thành công!");
    }

    // 4. Xóa
    public void deleteUser(String userId) {
        int oldSize = users.size();
        users.removeIf(u -> u.getUserId().equalsIgnoreCase(userId));

        if (users.size() == oldSize) {
            System.out.println("Mã người dùng không tồn tại trong hệ thống");
        } else {
            System.out.println("Xóa thành công: " + userId);
        }
    }

    // 5. Tìm kiếm theo tên (không phân biệt hoa thường)
    public void searchByName(String keyword) {
        String key = keyword.toLowerCase().trim();

        List<User> result = users.stream()
                .filter(u -> u.getUserName().toLowerCase().contains(key))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy người dùng nào!");
            return;
        }

        printHeader();
        result.forEach(User::displayData);
        System.out.println("Tổng số kết quả: " + result.size());
    }

    // 6. Lọc ADMIN
    public void filterAdmin() {
        List<User> admins = users.stream()
                .filter(u -> "ADMIN".equalsIgnoreCase(u.getRole()))
                .collect(Collectors.toList());

        if (admins.isEmpty()) {
            System.out.println("Không có người dùng nào có vai trò ADMIN!");
            return;
        }

        printHeader();
        admins.forEach(User::displayData);
        System.out.println("Tổng số ADMIN: " + admins.size());
    }

    // 7. Sắp xếp theo score giảm dần
    public void sortByScoreDesc() {
        List<User> sorted = users.stream()
                .sorted(Comparator.comparingDouble(User::getScore).reversed())
                .collect(Collectors.toList());

        if (sorted.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        }

        printHeader();
        sorted.forEach(User::displayData);
        System.out.println("Danh sách đã sắp xếp theo điểm giảm dần.");
    }
}