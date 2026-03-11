package SESSION04.BAI02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private final UserService service = new UserService();

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
