package SESSION07.BAI05;

public class EmailNotification implements NotificationService {

    public void send(String message, String recipient){
        System.out.println("Đã gửi email xác nhận");
    }
}
