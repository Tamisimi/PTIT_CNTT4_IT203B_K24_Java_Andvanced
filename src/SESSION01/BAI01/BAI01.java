package SESSION01.BAI01;

import java.util.Scanner;

public class BAI01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nhập năm sinh của bạn: ");
            String input = sc.nextLine();

            int namSinh = Integer.parseInt(input); 
            int tuoi = 2026 - namSinh;

            System.out.println("Tuổi của bạn là: " + tuoi);
        }
        catch (NumberFormatException e) {
            System.out.println("Lỗi bạn phải nhập số cho năm sinh");
        }
        finally {
            sc.close(); 
            System.out.println("Đang dọn dẹp tài nguyên trong finally...");
        }
    }
}
