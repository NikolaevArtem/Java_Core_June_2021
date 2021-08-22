package homework_5.digit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitTest {
    @Test
    void positiveNumberTest() {
        final long num1 = 15_005_532L;
        final long num2 = 12L;

        assertEquals(8, Digit.calculate(num1));
        assertEquals(2, Digit.calculate(num2));
    }

    @Test
    void negativeNumberTest() {
        final long num1 = -15_005_532L;
        final long num2 = -12L;

        assertEquals(8, Digit.calculate(num1));
        assertEquals(2, Digit.calculate(num2));
    }
}