package homework.homework_2.pyramid_printer;

import base.UnitBase;
import homework_2.pyramid_printer.PyramidPrinter;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class PyramidPrinterTest extends UnitBase {
    @Test
    void givenPositiveInt_whenInputIsThree_thenPrintPyramid() {
        setInput("3");

        new PyramidPrinter().run();
        removeFromOutput("Enter the Pyramid size. please: ");
        printOut();
        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
        assertEquals("xxx", getOutputLines()[2]);

    }

    @Test
    void givenZero_whenZeroInInput_thenDoNothing() {
        setInput("0");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Enter the Pyramid size. please: ");
        assertEquals("", getOutputLines()[0]);
    }

    @Test
    void givenNothing_whenEmptyInput_thenWriteErrMsgAndStop() {
        setInput("");

        new PyramidPrinter().run();
        removeFromOutput("Enter the Pyramid size. please: ");
        printOut();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void givenString_whenStringInput_thenWriteErrMsgAndStop() {
        setInput("Some string");

        new PyramidPrinter().run();
        removeFromOutput("Enter the Pyramid size. please: ");
        printOut();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void givenToBigNumber_whenInputBiggerIntMAX_thenWriteErrMsgAndStop() {
        setInput("999999999999");

        new PyramidPrinter().run();
        removeFromOutput("Enter the Pyramid size. please: ");
        printOut();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void givenNegativeNumber_whenInputLessThanZero_thenWriteErrMsgAndStop() {
        setInput("-1");

        new PyramidPrinter().run();
        removeFromOutput("Enter the Pyramid size. please: ");
        printOut();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void givenNotOneArg_whenInputIsDivided_thenWriteErrMsgAndStop() {
        setInput("2 3");

        new PyramidPrinter().run();
        removeFromOutput("Enter the Pyramid size. please: ");
        printOut();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void givenNotInteger_whenDouble_thenWriteErrMsgAndStop() {
        setInput("0.6");

        new PyramidPrinter().run();
        removeFromOutput("Enter the Pyramid size. please: ");
        printOut();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }


}