package SESSION07.BAI03;

public class Main {
    public static void main(String[] args) {

        PaymentProcessor codProcessor =
                new PaymentProcessor(new CODPayment());
        codProcessor.process(500000);

        PaymentProcessor cardProcessor =
                new PaymentProcessor(new CreditCardPayment());
        cardProcessor.process(1000000);

        PaymentProcessor momoProcessor =
                new PaymentProcessor(new MomoPayment());
        momoProcessor.process(750000);

        PaymentMethod payment = new CreditCardPayment();
        payment = new MomoPayment();

        PaymentProcessor processor = new PaymentProcessor(payment);
        processor.process(300000);
    }
}
