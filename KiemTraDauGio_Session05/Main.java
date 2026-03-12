package KiemTraDauGio_Session05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidProductException {
        Scanner sc = new Scanner(System.in);
        ProductManager manager = new ProductManager();
        int choice;

        do{
            System.out.println("========= PRODUCT MANAGEMENT SYSTEM =========");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Cập nhật số lượng theo ID");
            System.out.println("4. Xóa sản phẩm đã hết hàng");
            System.out.println("5. Thoát chương trình");
            System.out.println("=============================================");
            System.out.println("Lựa chọn của bạn: ");
            choice = sc.nextInt();


                switch (choice) {
                    case 1:
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Price: ");
                        double price = sc.nextDouble();

                        System.out.print("Quantity: ");
                        int quantity = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Category");
                        String category = sc.nextLine();

                        Product p = new Product(id, name, price, quantity, category);
                        manager.addProduct(p);
                        System.out.println("Thêm thành công");
                        break;
                    case 2:
                        manager.displayProduct();
                        break;
                    case 3:
                        System.out.print("Nhập Id ");
                        int updateId = sc.nextInt();

                        System.out.print("Nhập số lượng mới");
                        int newQuantity = sc.nextInt();

                        manager.updateQuantity(updateId, newQuantity);

                        System.out.println("Cập nhật thành công");
                        break;
                    case 4:
                        manager.deleteOutOfStock();
                        System.out.println("Đã xóa sản phẩm");
                        break;
                    case 5:
                        System.out.println("Thoát chương trình");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ");
                        break;
                }
        }while(choice != 5);
    }
}
