package SESSION07.BAI03;

public interface EWalletPayable extends PaymentMethod {
    void processEWallet(double amount);
}
