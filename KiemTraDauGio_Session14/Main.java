package KiemTraDauGio_Session14;

public class Main {
    public static void main(String[] args) {

        TransferService service = new TransferService();

        service.transfer("ACC01", "ACC02", 1500.00);

        service.printAccounts();
    }
}
