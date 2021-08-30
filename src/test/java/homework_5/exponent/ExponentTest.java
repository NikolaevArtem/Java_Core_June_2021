package homework_5.exponent;

import homework_5.power_of_number.Exponent;
import homework_5.power_of_number.InputNegativeBaseArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void negativeBaseTest() {
        final int base1 = -2;
        final int base2 = -9;

        final int num1 = -10_000;
        final int num2 = -2;

        assertThrows(InputNegativeBaseArgumentException.class, () -> Exponent.calculate(num1,base1));
        assertThrows(InputNegativeBaseArgumentException.class, () -> Exponent.calculate(num2, base2));

    }

}