package homework_2;

import base.UnitBase;
import homework_2.pyramid_printer.PyramidPrinter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PyramidPrinterTest extends UnitBase {

    private static final String ERROR = "Only 1 non-negative integer is allowed as passed parameter";

    @Test
    void given3_whenRun_then3linesOfX() {
        setInput("3");
        runPrintRemoveFromOutput();

        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
        assertEquals("xxx", getOutputLines()[2]);
    }

    @Test
    void given0_whenRun_thenEmpty() {
        setInput("0");
        runPrintRemoveFromOutput();
        assertEquals("", getOutput());
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 3", "abc", "-1"})
    void givenERROR_whenRun_thenERROR(String input) {
        setInput(input);
        runPrintRemoveFromOutput();
        assertEquals(ERROR, getOutput());
    }

    private void runPrintRemoveFromOutput() {
        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Please, input a number:");
    }
}
