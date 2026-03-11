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
    void validEmailWithDomain_shouldReturnLowercase() {
        String result = processor.processEmail("user@gmail.com");
        assertEquals("user@gmail.com", result);
    }

    @Test
    void missingAtSymbol_shouldThrowException() {
        assertThrows(IllegalArgumentException.class,
            () -> processor.processEmail("usergmail.com"));
    }

    @Test
    void atSymbolWithoutDomain_shouldThrowException() {
        assertThrows(IllegalArgumentException.class,
            () -> processor.processEmail("user@"));
    }

    @Test
    void mixedCaseEmail_shouldBeNormalizedToLowercase() {
        String result = processor.processEmail("Example@Gmail.com");
        assertEquals("example@gmail.com", result);
    }
}
