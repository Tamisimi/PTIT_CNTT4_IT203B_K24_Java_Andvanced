package SESSION07.BAI06;

public class ReceiptPrinter implements NotificationService {

    @Override
    public void notifyUser(String message) {
        System.out.println("In hóa đơn giấy: " + message);
    }
}
