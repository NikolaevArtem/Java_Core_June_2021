package homework_5.power_of_number;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerOfNumberTest extends UnitBase {

    private void run() {
        new PowerOfNumber().run();
        printOut();
        removeFromOutput("Input your numbers: ");
    }

    @Test
    void given23_whenRun_then4() {
        setInput("2 2");

        run();

        assertEquals("4", getOutputLines()[0]);
    }

    @Test
    void given00_whenRun_then1() {
        setInput("0 0");

        run();

        assertEquals("1", getOutputLines()[0]);
    }

    @Test
    void givenEmpty_whenRun_thenErrorMessage() {
        setInput(" ");

        run();

        assertEquals("Only 2 non-negative integers are allowed", getOutputLines()[0]);
    }

    @Test
    void givenInvalidInput_whenRun_thenErrorMessage() {
        setInput("3 rt");

        run();

        assertEquals("Only 2 non-negative integers are allowed", getOutputLines()[0]);
    }

    @Test
    void givenNegativeInput_whenRun_thenErrorMessage() {
        setInput("-2 3");

        run();

        assertEquals("Only 2 non-negative integers are allowed", getOutputLines()[0]);
    }

}
