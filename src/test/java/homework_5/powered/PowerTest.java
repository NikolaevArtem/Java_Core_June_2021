package homework_5.powered;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerTest {

    @Test
    void test3_inPow_5() {
        double expected = Math.pow(3, 5);
        assertEquals(expected, Power.power(3, 5));
    }

    @Test
    void test5_PoweredBy_10() {
        double expected = Math.pow(5, 10);
        assertEquals(expected, Power.power(5, 10));
    }

    @Test
    void test9_PoweredBy_21() {
        double expected = Math.pow(9, 12);
        assertEquals(expected, Power.power(9, 12));
    }

}