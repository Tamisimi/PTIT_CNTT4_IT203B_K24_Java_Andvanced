package SESSION02.BAI06;

public class Main {

    public static void main(String[] args) {

        UserProcessor processor = UserUtils::convertToUpperCase;
        User user = new User("linhngoc");

        String result = processor.process(user);
        System.out.println(result);

    }

}
