package homework_5.power_of_number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

public class PowerOfNumberTest {

    @Test
    void testRightCasePowerOfNumber() {
        PowerOfNumber pon = new PowerOfNumber();

        assertEquals(pon.calculateNumberInPower(3, 3), 27);
        assertEquals(pon.calculateNumberInPower(0, 3), 0);
        assertEquals(pon.calculateNumberInPower(2, 0), 1);
    }

    @Test
    void testNotANumberCasePowerOfNumber() {
        PowerOfNumber pon = new PowerOfNumber();

        Assertions.assertThrows(NumberFormatException.class, () -> pon.validateNumbers(new String[]{"j", "2"}));
        Assertions.assertThrows(NumberFormatException.class, () -> pon.validateNumbers(new String[]{"2", "k"}));
        Assertions.assertThrows(NumberFormatException.class, () -> pon.validateNumbers(new String[]{"j", "k"}));
    }

    @Test
    void testWrongAmountOfNumbersCasePowerOfNumber() {
        PowerOfNumber pon = new PowerOfNumber();

        Assertions.assertThrows(InputMismatchException.class, () -> pon.validateNumbers(new String[]{"2", "3", "3"}));
        Assertions.assertThrows(InputMismatchException.class, () -> pon.validateNumbers(new String[]{"3"}));
    }
    @Test
    void testNegativeNumberCasePowerOfNumber() {
        PowerOfNumber pon = new PowerOfNumber();

        Assertions.assertThrows(InputMismatchException.class, () -> pon.validateNumbers(new String[]{"-3", "3"}));
        Assertions.assertThrows(InputMismatchException.class, () -> pon.validateNumbers(new String[]{"3", "-3"}));
    }
}