package homework_5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PowerRecursionTest {

    @Test
    void given2inPower5_whenRun_thenReturn32() {
        final int num = 2;
        final int power = 5;

        final int expected = 32;
        final long actual = new PowerRecursion(num, power).run();

        assertEquals(expected, actual);
    }

    @Test
    void given8inPower0_whenRun_thenReturn1() {
        final int num = 8;
        final int power = 0;

        final int expected = 1;
        final long actual = new PowerRecursion(num, power).run();

        assertEquals(expected, actual);
    }

    @Test
    void given9inPower1_whenRun_thenReturn9() {
        final int num = 9;
        final int power = 1;

        final int expected = 9;
        final long actual = new PowerRecursion(num, power).run();

        assertEquals(expected, actual);
    }

    @Test
    void givenNegative3inPower4AndPositive3InPower4_whenRunAndCompare_thenEqual() {
        final int num1 = -3;
        final int num2 = 3;
        final int power = 4;

        assertEquals(new PowerRecursion(num1, power).run(), new PowerRecursion(num2, power).run());
    }

    @Test()
    void givenNegativePower_whenRun_thenThrowException() {
        final int num = 7;
        final int power = -8;

        assertThrows(IllegalArgumentException.class, () -> new PowerRecursion(num, power).run());

    }
}
