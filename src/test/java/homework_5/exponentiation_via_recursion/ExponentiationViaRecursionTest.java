package homework_5.exponentiation_via_recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExponentiationViaRecursionTest {

    @Test
    void given5and5_whenExponentiation_then3125() {
        double expected = 3125;
        assertEquals(expected, ExponentiationViaRecursion.run(5, 5));
    }

    @Test
    void given0and5_whenExponentiation_then0() {
        double expected = 0;
        assertEquals(expected, ExponentiationViaRecursion.run(0, 5));
    }

    @Test
    void given5and0_whenExponentiation_then3125() {
        double expected = 1;
        assertEquals(expected, ExponentiationViaRecursion.run(5, 0));
    }

    @Test
    void given0and0_whenExponentiation_then1() {
        double expected = 1;
        assertEquals(expected, ExponentiationViaRecursion.run(0, 0));
    }


}