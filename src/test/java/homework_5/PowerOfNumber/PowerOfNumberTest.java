package homework_5.PowerOfNumber;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerOfNumberTest extends UnitBase {

    PowerOfNumber powerOfNumber = new PowerOfNumber();


    @Test
    void give34_whenRun_thenReturn() {
        setInput("3 4");
        powerOfNumber.run();
        assertEquals("81", getOutputLines()[1]);
    }

    @Test
    void give2and31_whenRun_thenReturn() {
        setInput("2 31");
        powerOfNumber.run();
        assertEquals("2147483648", getOutputLines()[1]);
    }

    @Test
    void give2and40_whenRun_thenReturn() {
        setInput("2 40");
        powerOfNumber.run();
        assertEquals((new Double(Math.pow(2, 40))).longValue(), Long.valueOf(getOutputLines()[1]));
    }

    @Test
    void giveZero_whenRun_thenReturn() {
        setInput("0 0");
        powerOfNumber.run();
        assertEquals("1", getOutputLines()[1]);
    }

    @Test
    void give0and2_whenRun_thenReturn() {
        setInput("0 2");
        powerOfNumber.run();
        assertEquals("0", getOutputLines()[1]);
    }

    @Test
    void give2and0_whenRun_thenReturn() {
        setInput("2 0");
        powerOfNumber.run();
        assertEquals("1", getOutputLines()[1]);
    }

    @Test
    void giveString_whenRun_thenError() {
        setInput("five 2");
        powerOfNumber.run();
        assertEquals("Only 2 non-negative integers are allowed.", getOutputLines()[1]);
    }

    @Test
    void giveNegativeBase_whenRun_thenError() {
        setInput("-3 2");
        powerOfNumber.run();
        assertEquals("Only 2 non-negative integers are allowed.", getOutputLines()[1]);
    }

    @Test
    void giveNegativeExp_whenRun_thenError() {
        setInput("4 -2");
        powerOfNumber.run();
        assertEquals("Only 2 non-negative integers are allowed.", getOutputLines()[1]);
    }

    @Test
    void giveEmpty_whenRun_thenError() {
        setInput("");
        powerOfNumber.run();
        assertEquals("Only 2 non-negative integers are allowed.", getOutputLines()[1]);
    }

    @Test
    void giveBlank_whenRun_thenError() {
        setInput(" ");
        powerOfNumber.run();
        assertEquals("Only 2 non-negative integers are allowed.", getOutputLines()[1]);
    }

    @Test
    void giveLess_whenRun_thenError() {
        setInput("5");
        powerOfNumber.run();
        assertEquals("Only 2 non-negative integers are allowed.", getOutputLines()[1]);
    }

    @Test
    void giveMore_whenRun_thenError() {
        setInput("5 4 5");
        powerOfNumber.run();
        assertEquals("Only 2 non-negative integers are allowed.", getOutputLines()[1]);
    }

}
