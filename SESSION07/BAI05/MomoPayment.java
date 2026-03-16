package SESSION07.BAI05;

public class MomoPayment implements PaymentMethod {

    public void pay(double amount){
        System.out.println("Thanh toán MoMo: " + amount);
    }
}
