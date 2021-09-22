package homework_2.pyramid_printer;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PyramidPrinterTest extends UnitBase {

    private void run() {
        new PyramidPrinter().run();
        removeFromOutput("Enter a valid INT value for create a pyramid:");
        printOut();
    }

    @Test
    void givenPositive1_whenRun_thenExpected() {
        setInput("1");

        run();

        assertEquals("x", getOutput());
    }

    @Test
    void givenPositive3_whenRun_thenExpected() {
        setInput("3");

        run();

        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
        assertEquals("xxx", getOutputLines()[2]);
    }

    @Test
    void givenZero_whenRun_thenExpected() {
        setInput("0");

        run();

        assertEquals("", getOutput());
    }

    @Test
    void givenNegative_whenRun_thenExpectedError() {
        setInput("-5");

        run();

        assertEquals("Only 1 non-negative integer is allowed.", getOutput());
    }

    @Test
    void givenNaN_whenRun_thenExpectedError() {
        setInput("asd");

        run();

        assertEquals("Only 1 non-negative integer is allowed.", getOutput());
    }
}