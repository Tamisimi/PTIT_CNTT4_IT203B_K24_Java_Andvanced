package SESSION04.BAI02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

<<<<<<< HEAD
    private final SESSION04.BAI02.UserService service = new SESSION04.BAI02.UserService();
=======
    private final UserService service = new UserService();
>>>>>>> 18f89c6adf82826124be9ab10499bfde3e6e91e4

    @Test
    void shouldAllowRegistrationAtAge18() {
        boolean result = service.checkRegistrationAge(18);
        assertEquals(true, result);
    }

    @Test
    void shouldDenyRegistrationAtAge17() {
        boolean result = service.checkRegistrationAge(17);
        assertEquals(false, result);
    }

    @Test
    void shouldThrowExceptionForNegativeAge() {
        assertThrows(IllegalArgumentException.class,
            () -> service.checkRegistrationAge(-1));
    }
}
