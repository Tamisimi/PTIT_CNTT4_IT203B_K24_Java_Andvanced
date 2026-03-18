package SESSION07.BAI06;

public class WebsiteFactory implements SalesChannelFactory {

    @Override
    public DiscountStrategy createDiscount() {
        return new WebsiteDiscount();
    }

    @Override
    public PaymentMethod createPayment() {
        return new CreditCardPayment();
    }

    @Override
    public NotificationService createNotification() {
        return new EmailNotification();
    }
}
