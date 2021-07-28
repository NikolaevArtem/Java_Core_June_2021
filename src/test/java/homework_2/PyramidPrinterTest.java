package homework_2;

import homework_2.pyramid_printer.PyramidPrinter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PyramidPrinterTest extends base.UnitBase {

    private final String ERROR_MESSAGE = "Only 1 non-negative integer is allowed as passed parameter";
    private final String START_MESSAGE = "Please, input number:";

    @Test
    void correctInputTest1() {
        setInput("2");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
    }

    @Test
    void correctInputTest2() {
        setInput("8");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals("x", getOutputLines()[0]);
        assertEquals("xxxx", getOutputLines()[3]);
        assertEquals("xxxxxxxx", getOutputLines()[7]);
    }

    @Test
    void nullInputTest() {
        setInput("0");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals("", getOutputLines()[0]);
    }

    @Test
    void negativeInputTest() {
        setInput("-10");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void stringInputTest() {
        setInput("string");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void bigNumberInputTest() {
        setInput("5666677772444198455342456");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(ERROR_MESSAGE, getOutput());
    }
}
