package homework_2.pyramid_printer;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PyramidPrinter_test extends UnitBase {

    @Test
    void testGivenZero() throws IOException {

    setInput("0");

    PyramidPrinter pyramidPrinter2 = new PyramidPrinter();
    pyramidPrinter2.run();
    printOut();
    removeFromOutput("Please input number");

    assertEquals("", getOutputLines()[0]);
}

    @Test
    public void testInput2() throws IOException {
    setInput("2");

    PyramidPrinter pyramidPrinter = new PyramidPrinter();
    pyramidPrinter.run();
    printOut();
    removeFromOutput("Please input number");

    assertEquals("x", getOutputLines()[0]);
    assertEquals("xx", getOutputLines()[1]);
}

    @Test
    public void testInput3() throws IOException {
        setInput("3");

        PyramidPrinter pyramidPrinter = new PyramidPrinter();
        pyramidPrinter.run();
        printOut();
        removeFromOutput("Please input number");

        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
        assertEquals("xxx", getOutputLines()[2]);
    }

    @Test
    public void testInputNegative1() throws IOException {
        setInput("-1");

        PyramidPrinter pyramidPrinter = new PyramidPrinter();
        pyramidPrinter.run();
        printOut();
        removeFromOutput("Please input number");

        assertEquals("Error, negative numbers are not valid", getOutputLines()[0]);
    }

    @Test
    public void testInputBig1234567890123456() throws IOException {
        setInput("1234567890123456");

        PyramidPrinter pyramidPrinter = new PyramidPrinter();
        pyramidPrinter.run();
        printOut();
        removeFromOutput("Please input number");

        assertEquals("Error, only numbers are allowed", getOutputLines()[0]);
    }

    @Test
    public void testInputText() throws IOException {
        setInput("text");

        PyramidPrinter pyramidPrinter = new PyramidPrinter();
        pyramidPrinter.run();
        printOut();
        removeFromOutput("Please input number");

        assertEquals("Error, only numbers are allowed", getOutputLines()[0]);
    }

}

