package homework_5.math_power;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathPowerTest {

    @Test
    void test_value2_toPowOf_5() {
        assertEquals(Math.pow(2, 5), MathPower.pow(2, 5));
    }

    @Test
    void test_value18_toPowOf_7() {
        assertEquals(Math.pow(18, 7), MathPower.pow(18, 7));
    }

    @Test
    void test_value21_toPowOf_10() {
        assertEquals(Math.pow(21, 10), MathPower.pow(21, 10));
    }

    @Test
    void test_valueNegative4_toPowOf_5() {
        assertEquals(Math.pow(-4, 5), MathPower.pow(-4, 5));
    }

    @Test
    void test_value1d3_toPowOf_8() {
        assertEquals(Math.pow(2.3, 8), MathPower.pow(2.3, 8));
    }

    @Test
    void test_value2d3_toPowOf_negative7() {
        assertEquals(Math.pow(2.3, -7), MathPower.pow(2.3, -7));
    }

    @Test
    void test_value5_toPowOf_0() {
        assertEquals(Math.pow(5, 0), MathPower.pow(5, 0));
    }

}
