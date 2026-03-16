package SESSION07.BAI01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Product p1 = new Product("SP01", "Laptop", 15000000);
        Product p2 = new Product("SP02", "Chuột", 300000);

        System.out.println("Đã thêm sản phẩm SP01, SP02");

        Customer customer = new Customer(
                "Pham Quoc Loc",
                "lqp@gmail.com",
                "Hà Nội"
        );

        System.out.println("Đã thêm khách hàng");

        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem(p1, 1));
        items.add(new OrderItem(p2, 2));

        Order order = new Order("ORD001", customer, items);
        System.out.println("Đơn hàng ORD001 được tạo");

        OrderCalculator calculator = new OrderCalculator();
        double total = calculator.calculateTotal(order);
        order.setTotal(total);

        System.out.println("Tổng tiền: " + total);

        OrderRepository repository = new OrderRepository();
        repository.save(order);

        EmailService emailService = new EmailService();
        emailService.sendOrderConfirmation(order);
    }
}
