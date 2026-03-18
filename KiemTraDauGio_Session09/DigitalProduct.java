package KiemTraDauGio_Session09;

public class DigitalProduct extends Product {
    private int sizeMB;
    public DigitalProduct(String id, String name, double price, int sizeMB){
        super(id, name, price);
        this.sizeMB = sizeMB;
    }

    public int getSizeMB() {
        return sizeMB;
    }

    public void setSizeMB(int sizeMB) {
        this.sizeMB = sizeMB;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Digital | ID: %s | Name: %s | Price: %.0f | Size: %d MB",getId(),getName(),getPrice(),sizeMB);
    }
}
