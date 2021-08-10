package homework_2;

import base.UnitBase;
import homework_2.pyramid_printer.PyramidPrinter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PyramidPrinterTest extends UnitBase {
    private final String ERROR_MSG = "Only 1 non-negative integer is allowed as passed parameter";

    @Test
    void givenInteger3_whenRunPyramidPrinter_thenPrintingPyramidOfSimbolsX() {
        setInput("3");

        new PyramidPrinter().run();
        printOut();

        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
        assertEquals("xxx", getOutputLines()[2]);
    }

    @Test
    void givenInteger1_whenRunPyramidPrinter_thenPrintingOneSimbolX() {
        setInput("1");

        new PyramidPrinter().run();
        printOut();

        assertEquals("x", getOutputLines()[0]);
    }

    @Test
    void givenInteger0_whenRunPyramidPrinter_thenPrintNothing() {
        setInput("0");

        new PyramidPrinter().run();
        printOut();

        assertEquals("", getOutputLines()[0]);
    }

    @Test
    void givenNegativeInteger_whenRunPyramidPrinter_thenPrintErrorMsg() {
        setInput("-1");

        new PyramidPrinter().run();
        printOut();

        assertEquals(ERROR_MSG, getOutputLines()[0]);
    }

    @Test
    void givenStringHi_whenRunPyramidPrinter_thenPrintErrorMsg() {
        setInput("Hi");

        new PyramidPrinter().run();
        printOut();

        assertEquals(ERROR_MSG, getOutputLines()[0]);
    }

    @Test
    void givenEmptyString_whenRunPyramidPrinter_thenPrintErrorMsg() {
        setInput("");

        new PyramidPrinter().run();
        printOut();

        assertEquals(ERROR_MSG, getOutputLines()[0]);
    }
}
