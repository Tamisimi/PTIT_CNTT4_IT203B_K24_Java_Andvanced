package SESSION04.BAI01;

public class UserValidator {
    public boolean isValidUsername(String username) {
        if (username == null) return false;
        int len = username.length();
        return len >= 6 && len <= 20 && !username.contains(" ");
    }
}
