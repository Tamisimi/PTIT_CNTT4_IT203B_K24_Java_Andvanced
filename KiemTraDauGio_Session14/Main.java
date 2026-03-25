package KiemTraDauGio_Session14;

public class Main {
    public static void main(String[] args) {

        TransferService service = new TransferService();

        // Thực hiện chuyển khoản (ví dụ: ACC01 chuyển 1500 cho ACC02)
        service.transfer("ACC01", "ACC02", 1500.00);

        // Hiển thị kết quả cuối cùng để đối soát
        service.printAccounts();
    }
}