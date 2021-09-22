package homework_2.pyramid_printer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import base.UnitBase;

class PyramidPrinterTest extends UnitBase {

    @Test
    void givenPositiveIntFour_whenRun_thenPrintPyramid() {
        setInput("4");

        PyramidPrinter.run();
        printOut();
        removeFromOutput("Enter 1 positive integer");

        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
        assertEquals("xxx", getOutputLines()[2]);
        assertEquals("xxxx", getOutputLines()[3]);
    }

    @Test
    void givenZero_whenRun_thenWriteErrMsgAndStop() {
        setInput("0");

        PyramidPrinter.run();
        printOut();
        removeFromOutput("Enter 1 positive integer");

        assertEquals("", getOutputLines()[0]);
    }

    @Test
    void givenNothing_whenRun_thenWriteErrMsgAndStop() {
        setInput("");

        PyramidPrinter.run();
        printOut();
        removeFromOutput("Enter 1 positive integer");

        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void givenNegativeInt_whenRun_thenWriteErrMsgAndStop() {
        setInput("-4");

        PyramidPrinter.run();
        printOut();
        removeFromOutput("Enter 1 positive integer");

        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void givenDouble_whenRun_thenWriteErrMsgAndStop() {
        setInput("2.5");

        PyramidPrinter.run();
        printOut();
        removeFromOutput("Enter 1 positive integer");

        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void givenString_whenRun_thenWriteErrMsgAndStop() {
        setInput("String");

        PyramidPrinter.run();
        printOut();
        removeFromOutput("Enter 1 positive integer");

        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void givenMoreThenOneInput_whenRun_thenWriteErrMsgAndStop() {
        setInput("3 0");

        PyramidPrinter.run();
        printOut();
        removeFromOutput("Enter 1 positive integer");

        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

}
