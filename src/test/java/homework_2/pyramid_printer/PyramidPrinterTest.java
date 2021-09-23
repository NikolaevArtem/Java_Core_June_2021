package homework_2.pyramid_printer;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PyramidPrinterTest extends UnitBase {

    @Test
    void EmptyInputTest() {
        setInput("");

        new PyramidPrinter().run();
        removeFromOutput("Please type a positive integer number:");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter",
                getOutputLines()[0]);
    }

    @Test
    void NullInputTest() {
        setInput("0");

        new PyramidPrinter().run();
        removeFromOutput("Please type a positive integer number:");
        assertEquals("",
                getOutputLines()[0]);
    }

    @Test
    void CorrectInputTest() {
        setInput("5");

        new PyramidPrinter().run();
        removeFromOutput("Please type a positive integer number:");
        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
        assertEquals("xxx", getOutputLines()[2]);
        assertEquals("xxxx", getOutputLines()[3]);
        assertEquals("xxxxx", getOutputLines()[4]);
    }

    @Test
    void NegativeInputTest() {
        setInput("-5");

        new PyramidPrinter().run();
        removeFromOutput("Please type a positive integer number:");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter",
                getOutputLines()[0]);
    }

    @Test
    void LongNotIntInputTest() {
        setInput("99999999999999999");

        new PyramidPrinter().run();
        removeFromOutput("Please type a positive integer number:");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter",
                getOutputLines()[0]);
    }

    @Test
    void StringInputTest() {
        setInput("hello");

        new PyramidPrinter().run();
        removeFromOutput("Please type a positive integer number:");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter",
                getOutputLines()[0]);
    }

    @Test
    void DoubleInputTest() {
        setInput("0.5");

        new PyramidPrinter().run();
        removeFromOutput("Please type a positive integer number:");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter",
                getOutputLines()[0]);
    }
}
