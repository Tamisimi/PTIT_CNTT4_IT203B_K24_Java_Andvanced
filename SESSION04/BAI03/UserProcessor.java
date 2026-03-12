package SESSION04.BAI03;

public class UserProcessor {

    public String processEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }

        String trimmed = email.trim();

        if (!trimmed.contains("@")) {
            throw new IllegalArgumentException("Email must contain '@'");
        }

        String[] parts = trimmed.split("@", 2);
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty() || !parts[1].contains(".")) {
            throw new IllegalArgumentException("Invalid email format");
        }

        return trimmed.toLowerCase();
    }
}
