package SESSION04.BAI03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserProcessorTest {

    private UserProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new UserProcessor();
    }

    @Test
    void validEmail() {
        String result = processor.processEmail("user@gmail.com");
        assertEquals("user@gmail.com", result);
    }

    @Test
    void missingAt() {
        assertThrows(IllegalArgumentException.class,
            () -> processor.processEmail("usergmail.com"));
    }

    @Test
    void noDomain() {
        assertThrows(IllegalArgumentException.class,
            () -> processor.processEmail("user@"));
    }

    @Test
    void normalizeCase() {
        String result = processor.processEmail("Example@Gmail.com");
        assertEquals("example@gmail.com", result);
    }
}
