package homework_5.power_of_number;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerOfNumberTest extends UnitBase {

    @Test
    void given2_2_whenRun_then_print2ToThePowerOf2() {
        setInput("2 2");
        new PowerOfNumber().run();
        assertTrue(getOutput().contains("4"));
    }


    @Test
    void given2_1_whenRun_then_print2ToThePowerOf1() {
        setInput("2 1");
        new PowerOfNumber().run();
        assertTrue(getOutput().contains("2"));
    }

    @Test
    void given2_0_whenRun_then_print2ToThePowerOf0() {
        setInput("2 0");
        new PowerOfNumber().run();
        assertTrue(getOutput().contains("1"));
    }

    @Test
    void given0_2_whenRun_then_print0ToThePowerOf2() {
        setInput("0 2");
        new PowerOfNumber().run();
        assertTrue(getOutput().contains("0"));
    }

    @Test
    void givenNegativeNumber_whenRun_then_printError() {
        setInput("-2 2");
        new PowerOfNumber().run();
        assertTrue(getOutput().contains("Only 2 non-negative integers are allowed"));
    }

    @Test
    void givenNegativePow_whenRun_then_printError() {
        setInput("2 -2");
        new PowerOfNumber().run();
        assertTrue(getOutput().contains("Only 2 non-negative integers are allowed"));
    }

    @Test
    void givenString_whenRun_then_printError() {
        setInput("abc def");
        new PowerOfNumber().run();
        assertTrue(getOutput().contains("Only 2 non-negative integers are allowed"));
    }
}
