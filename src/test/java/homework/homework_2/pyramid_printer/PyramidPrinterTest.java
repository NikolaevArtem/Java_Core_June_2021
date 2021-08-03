package homework.homework_2.pyramid_printer;

import base.UnitBase;
import homework_2.pyramid_printer.PyramidPrinter;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class PyramidPrinterTest extends UnitBase {

    final String ERR_MSG = "Only 1 non-negative integer is allowed as passed parameter";

    //tested cases           correct input 3
    //                       zero input
    //                       empty input
    //                       string input
    //                       input bigger INT_MAX.VALUE
    //                       negative number
    //                       more that one argument
    // 8                     double value

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
    void givenZero_whenRun_thenDoNothing() {
        setInput("0");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Enter the Pyramid size. please: ");
        assertEquals("", getOutputLines()[0]);
    }

    @Test
    void givenNothing_whenRun_thenWriteErrMsgAndStop() {
        setInput("");

        new PyramidPrinter().run();
        removeFromOutput("Enter the Pyramid size. please: ");
        printOut();
        assertEquals(ERR_MSG, getOutputLines()[0]);
    }

    @Test
    void givenString_whenRun_thenWriteErrMsgAndStop() {
        setInput("Some string");

        new PyramidPrinter().run();
        removeFromOutput("Enter the Pyramid size. please: ");
        printOut();
        assertEquals(ERR_MSG, getOutputLines()[0]);
    }

    @Test
    void givenToBigNumber_whenRun_thenWriteErrMsgAndStop() {
        setInput("999999999999");

        new PyramidPrinter().run();
        removeFromOutput("Enter the Pyramid size. please: ");
        printOut();
        assertEquals(ERR_MSG, getOutputLines()[0]);
    }

    @Test
    void givenNegativeNumber_whenRun_thenWriteErrMsgAndStop() {
        setInput("-1");

        new PyramidPrinter().run();
        removeFromOutput("Enter the Pyramid size. please: ");
        printOut();
        assertEquals(ERR_MSG, getOutputLines()[0]);
    }

    @Test
    void givenMoreThatOne_whenRun_thenWriteErrMsgAndStop() {
        setInput("2 3");

        new PyramidPrinter().run();
        removeFromOutput("Enter the Pyramid size. please: ");
        printOut();
        assertEquals(ERR_MSG, getOutputLines()[0]);
    }

    @Test
    void givenNotAnInteger_whenRun_thenWriteErrMsgAndStop() {
        setInput("0.6");

        new PyramidPrinter().run();
        removeFromOutput("Enter the Pyramid size. please: ");
        printOut();
        assertEquals(ERR_MSG, getOutputLines()[0]);
    }


}