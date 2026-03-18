package SESSION04.BAI01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    private final UserValidator validator = new UserValidator();

    @Test
    void TC01_valid() {
        assertTrue(validator.isValidUsername("user123"));
    }

    @Test
    void TC02_too_short() {
        assertFalse(validator.isValidUsername("abc"));
    }

    @Test
    void TC03_has_space() {
        assertFalse(validator.isValidUsername("user name"));
    }
}
