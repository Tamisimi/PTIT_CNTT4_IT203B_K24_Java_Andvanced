package SESSION07.BAI06;
public class FirstTimeDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double amount) {
        System.out.println("Áp dụng giảm giá 15% cho lần đầu");
        return amount * 0.85;
    }
}
