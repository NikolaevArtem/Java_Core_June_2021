package homework_5.math_power;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static homework_5.math_power.utils.Constants.ERROR_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerOfNumberTest extends UnitBase {
    private final PowerOfNumber powerOfNumber = new PowerOfNumber();

    @Test
    void test_valuesInvalidAmount_thenGetErrorMessage() {
        String[] args = {"2", "1", "4"};
        powerOfNumber.run(args);
        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void test_valuesNotNumber_thenGetErrorMessage() {
        String[] args = {"2", "s"};
        powerOfNumber.run(args);
        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void test_valuesNegativeNumber_thenGetErrorMessage() {
        String[] args = {"-2", "5"};
        powerOfNumber.run(args);
        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void test_valuesDoubleNumber_thenGetErrorMessage() {
        String[] args = {"2.5", "5"};
        powerOfNumber.run(args);
        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void test_values2_2_thenGet4() {
        String[] args = {"2", "2"};
        powerOfNumber.run(args);
        assertEquals("4", getOutput());
    }

    @Test
    void test_values2_1_thenGet2() {
        String[] args = {"2", "1"};
        powerOfNumber.run(args);
        assertEquals("2", getOutput());
    }

    @Test
    void test_values2_0_thenGet1() {
        String[] args = {"2", "0"};
        powerOfNumber.run(args);
        assertEquals("1", getOutput());
    }

    @Test
    void test_values0_2_thenGet0() {
        String[] args = {"0", "2"};
        powerOfNumber.run(args);
        assertEquals("0", getOutput());
    }

    @Test
    void test_values13_18_thenEqualsMathPow13_18() {
        String[] args = {"10", "18"};
        powerOfNumber.run(args);
        assertEquals(String.valueOf((long) Math.pow(10, 18)), getOutput());
    }

    @Test
    void test_values5_0_thenEqualsMathPow5_0() {
        String[] args = {"5", "0"};
        powerOfNumber.run(args);
        assertEquals(String.valueOf((int) Math.pow(5, 0)), getOutput());
    }

}
