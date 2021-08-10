package homework_1;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends UnitBase {

    @Test
    void givenHiHelloError_whenPrintArgsUntilError_thenPrintingHiHelloAlarm() {
        final String[] given = {"Hi", "Hello", "error"};

        Main.main(given);
        printOut();

        assertEquals("Hi: 2 letters", getOutputLines()[0]);
        assertEquals("Hello: 5 letters", getOutputLines()[1]);
        assertEquals("\033[0;31mAlarm!\033[0m", getOutputLines()[2]);
    }

    @Test
    void givenError_whenPrintArgsUntilError_thenPrintingAlarm() {
        final String[] given = {"error"};

        Main.main(given);
        printOut();

        assertEquals("[0;31mAlarm!\u001B[0m", getOutputLines()[0]);
    }

    @Test
    void givenHiErrorBye_whenPrintArgsUntilError_thenPrintingHiAlarm() {
        final String[] given = {"Hi", "error", "Bye"};

        Main.main(given);
        printOut();

        assertEquals("Hi: 2 letters", getOutputLines()[0]);
        assertEquals("\033[0;31mAlarm!\033[0m", getOutputLines()[1]);
    }

    @Test
    void givenNothing_whenPrintArgsUntilError_thenPrintingNothing() {
        final String[] given = {};

        Main.main(given);
        printOut();

        assertEquals("", getOutputLines()[0]);
    }
}
