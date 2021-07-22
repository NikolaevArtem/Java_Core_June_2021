package homework_2;

import base.UnitBase;
import homework_2.pyramid_printer.PyramidPrinter;
import org.junit.jupiter.api.Test;

import static homework_2.pyramid_printer.PyramidPrinter.ERROR;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PyramidPrinterTest extends UnitBase {

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

    @Test
    void givenNegNumber_whenRun_thenERROR() {
        setInput("-1");
        runPrintRemoveFromOutput();
        assertEquals(ERROR, getOutput());
    }

    @Test
    void givenNAN_whenRun_thenERROR() {
        setInput("abc");
        runPrintRemoveFromOutput();
        assertEquals(ERROR, getOutput());
    }

    @Test
    void given2args_whenRun_thenERROR() {
        setInput("2 3");
        runPrintRemoveFromOutput();
        assertEquals(ERROR, getOutput());
    }

    private void runPrintRemoveFromOutput() {
        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Please, input a number:");
    }
}
