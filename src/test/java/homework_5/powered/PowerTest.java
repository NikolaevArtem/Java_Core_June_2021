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

    @Test
    void test0_PoweredBy_1() {
        double expected = Math.pow(0, 1);
        assertEquals(expected, Power.power(0, 1));
    }

    @Test
    void test0_PoweredBy_0() {
        double expected = Math.pow(0, 0);
        assertEquals(expected, Power.power(0, 0));
    }

    @Test
    void test3_PoweredBy_Negative3() {
        double expected = Math.pow(3, -3);
        assertEquals(expected, Power.power(3, -3));
    }

}