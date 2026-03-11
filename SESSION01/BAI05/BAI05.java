package SESSION01.BAI05;

public class BAI05 {
    public static void main(String[] args) {

        User user = new User();

        try {
            user.setAge(-3); 
            System.out.println("Tuổi: " + user.getAge());
        }
        catch (InvalidAgeException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        System.out.println("Chương trình vẫn tiếp tục chạy...");
    }
}
