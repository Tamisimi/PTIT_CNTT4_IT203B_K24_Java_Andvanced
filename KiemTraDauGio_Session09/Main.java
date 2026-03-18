package KiemTraDauGio_Session09;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductDatabase db = ProductDatabase.getInstance();

        while (true) {
            System.out.println("\n📝 ---------------------- QUẢN LÝ SẢN PHẨM ----------------------");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Xem danh sách sản phẩm");
            System.out.println("3. Cập nhật thông tin sản phẩm");
            System.out.println("4. Xoá sản phẩm");
            System.out.println("5. Thoát");
            System.out.println("-----------------------------------------------------------------------");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
                continue;
            }

            switch (choice) {
                case 1:
                    Product newProduct = ProductFactory.createProduct(scanner);
                    db.addProduct(newProduct);
                    break;

                case 2:
                    System.out.println("\nDanh sách sản phẩm:");
                    System.out.println("---------------------------------------------------------------");
                    for (Product p : db.getAllProducts()) {
                        p.displayInfo();
                    }
                    if (db.getAllProducts().isEmpty()) {
                        System.out.println("Kho hiện đang trống.");
                    }
                    break;

                case 3:
                    System.out.print("Nhập ID sản phẩm cần cập nhật: ");
                    String updateId = scanner.nextLine().trim();
                    System.out.print("Tên mới: ");
                    String newName = scanner.nextLine().trim();
                    System.out.print("Giá mới: ");
                    double newPrice;
                    try {
                        newPrice = Double.parseDouble(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Giá không hợp lệ!");
                        break;
                    }
                    db.updateProduct(updateId, newName, newPrice);
                    break;

                case 4:
                    System.out.print("Nhập ID sản phẩm cần xóa: ");
                    String deleteId = scanner.nextLine().trim();
                    db.deleteProduct(deleteId);
                    break;

                case 5:
                    System.out.println("Tạm biệt!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}