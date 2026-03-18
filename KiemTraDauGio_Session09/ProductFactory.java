package KiemTraDauGio_Session09;

import java.util.Scanner;

public class ProductFactory {

    public static Product createProduct(Scanner scanner) {
        System.out.print("Chọn: 1 Physical | 2 Digital: ");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập ID: ");
        String id = scanner.nextLine().trim();

        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine().trim();

        System.out.print("Nhập giá: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        if (type == 1) {
            System.out.print("Nhập trọng lượng kg: ");
            double weight = scanner.nextDouble();
            scanner.nextLine();
            return new PhysicalProduct(id, name, price, weight);
        } else if (type == 2) {
            System.out.print("Nhập dung lượng MB: ");
            int sizeMB = scanner.nextInt();
            scanner.nextLine();
            return new DigitalProduct(id, name, price, sizeMB);
        } else {
            System.out.println("Loại không hợp lệ → tạo Physical mặc định");
            System.out.print("Nhập trọng lượng (kg): ");
            double weight = scanner.nextDouble();
            scanner.nextLine();
            return new PhysicalProduct(id, name, price, weight);
        }
    }
}


