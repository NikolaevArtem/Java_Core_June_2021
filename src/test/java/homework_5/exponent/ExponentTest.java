package homework_5.exponent;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExponentTest {

    @Test
    void positiveNumberTest() {
        final int base1 = 2;
        final int base2 = 9;

        final int num1 = 10_000;
        final int num2 = 2;

        assertEquals(100_000_000, Exponent.calculate(num1,base1));
        assertEquals(512, Exponent.calculate(num2, base2));
    }

    @Test
    void negativeNumberTest() {
        final int base1 = 2;
        final int base2 = 9;

        final int num1 = -10_000;
        final int num2 = -2;

        assertEquals(100_000_000, Exponent.calculate(num1,base1));
        assertEquals(-512, Exponent.calculate(num2, base2));
    }
}