package homework_5;

import base.UnitBase;
import homework_5.power_of_number.PowerOfNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerOfNumberTest extends UnitBase {

    @Test
    void given2inPower5_whenRun_thenReturn32() {
        setInput("2 5");

        new PowerOfNumber().run();

        assertEquals("32", getOutputLines()[0]);
    }

    @Test
    void given8inPower0_whenRun_thenReturn1() {
        setInput("8 0");

        new PowerOfNumber().run();

        assertEquals("1", getOutputLines()[0]);
    }

    @Test
    void given9inPower1_whenRun_thenReturn9() {
        setInput("9 1");

        new PowerOfNumber().run();

        assertEquals("9", getOutputLines()[0]);
    }

    @Test()
    void givenNegativePower_whenRun_thenPrintErrorMsg() {
        setInput("9 -1");

        new PowerOfNumber().run();

        assertEquals("Only 2 non-negative integers are allowed", getOutputLines()[0]);
    }

    @Test()
    void givenNegativeNumber_whenRun_thenPrintErrorMsg() {
        setInput("-9 1");

        new PowerOfNumber().run();

        assertEquals("Only 2 non-negative integers are allowed", getOutputLines()[0]);
    }

    @Test()
    void givenNotInteger_whenRun_thenPrintErrorMsg() {
        setInput("Hello hi");

        new PowerOfNumber().run();

        assertEquals("Only 2 non-negative integers are allowed", getOutputLines()[0]);
    }
}
