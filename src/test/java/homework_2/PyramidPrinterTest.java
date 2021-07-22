package homework_2;

import base.UnitBase;
import homework_2.pyramid_printer.PyramidPrinter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PyramidPrinterTest extends UnitBase {

    @Test
    public void testPyramidWithOneArg() {
        setInput("1");
        new PyramidPrinter().run();
        printOut();
        assertEquals("x", getOutputLines()[0]);
    }

    @Test
    void InputZeroAsArgument() {
        setInput("0");
        new PyramidPrinter().run();
        printOut();
        assertEquals("", getOutputLines()[0]);
    }

    @Test
    public void testPyramidWithTwoArg() {
        setInput("2");
        new PyramidPrinter().run();
        printOut();
        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
    }

    @Test
    public void testPyramidWithStringArg() {
        setInput("String");
        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("Only integer!", getOutputLines()[0]);
    }

    @Test
    public void testPyramidWithNegativeNumberArg() {
        setInput("-2");
        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("Use positive number", getOutputLines()[0]);
    }
    @Test
    public void testPyramidWithDoubleArg() {
        setInput("2.0");
        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("Only integer!", getOutputLines()[0]);
    }
    @Test
    public void testPyramidWithoutArg() {
        setInput("");
        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("Only integer!", getOutputLines()[0]);
    }

}
