package SESSION04.BAI04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordStrengthEvaluatorTest {

    private PasswordStrengthEvaluator evaluator;

    @BeforeEach
    void setUp() {
        evaluator = new PasswordStrengthEvaluator();
    }

    @Test void strong(){
      assertEquals("Mạnh", evaluator.evaluatePasswordStrength("Abc123!@"));
    }
    @Test void noUpper(){
      assertEquals("Trung bình", evaluator.evaluatePasswordStrength("abc123!@"));
    }
    @Test void noLower(){
      assertEquals("Trung bình", evaluator.evaluatePasswordStrength("ABC123!@"));
    }
    @Test void noDigit(){
      assertEquals("Trung bình", evaluator.evaluatePasswordStrength("Abcdef!@"));
    }
    @Test void noSpecial(){
      assertEquals("Trung bình", evaluator.evaluatePasswordStrength("Abc12345"));
    }
    @Test void tooShort(){
      assertEquals("Yếu", evaluator.evaluatePasswordStrength("Ab1!"));
    }
    @Test void onlyLower(){
      assertEquals("Yếu", evaluator.evaluatePasswordStrength("password"));
    }
    @Test void upperDigit(){
      assertEquals("Yếu", evaluator.evaluatePasswordStrength("ABC12345"));
    }
}
