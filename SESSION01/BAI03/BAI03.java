package SESSION01.BAI03;

public class BAI03 {
    public static void main(String[] args) {

        User u = new User();

        try {
            u.setAge(-5);
            System.out.println("Tuổi: " + u.getAge());
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Chương trình vẫn tiếp tục chạy...");
    }
}
