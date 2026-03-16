package SESSION07.BAI03;

public interface CardPayable extends PaymentMethod {
    void processCard(double amount);
}
