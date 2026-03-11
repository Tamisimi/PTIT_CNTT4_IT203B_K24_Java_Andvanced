package SESSION02.BAI02;

public class BAI02 {

    public static void main(String[] args) {

        PasswordValidator validator = password -> password.length() >= 8;

        System.out.println(validator.isValid("12345678"));
        System.out.println(validator.isValid("1234"));

    }
}
