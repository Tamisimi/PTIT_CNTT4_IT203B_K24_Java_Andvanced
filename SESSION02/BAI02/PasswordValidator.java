package SESSION02.BAI02;

@FunctionalInterface
public interface PasswordValidator {
    boolean isValid(String password);
}
