package homework_5.exp_w_rec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpWRecTest {

    @Test
    void given5and5_whenExponentiation_then3125() {
        double expected = 3125;
        assertEquals(expected, ExpWRec.run(5, 5));
    }

    @Test
    void given0and5_whenExponentiation_then0() {
        double expected = 0;
        assertEquals(expected, ExpWRec.run(0, 5));
    }

    @Test
    void given5and0_whenExponentiation_then3125() {
        double expected = 1;
        assertEquals(expected, ExpWRec.run(5, 0));
    }

    @Test
    void given0and0_whenExponentiation_then1() {
        double expected = 1;
        assertEquals(expected, ExpWRec.run(0, 0));
    }

    @Test
    void given5divide4and4_whenExponentiation_then1() {
        double expected = Math.pow(5.4, 4);
        assertEquals(expected, ExpWRec.run(5.4, 4));
    }
}