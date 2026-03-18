package SESSION07.BAI06;

public class WebsiteDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double amount) {
        System.out.println("Áp dụng giảm giá 10% cho đơn hàng website");
        return amount * 0.9;
    }
}
