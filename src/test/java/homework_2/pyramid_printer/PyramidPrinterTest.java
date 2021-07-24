package homework_2.pyramid_printer;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PyramidPrinterTest extends UnitBase {

    void removeOutputDifference() {
        removeFromOutput("Pyramid Printer App \nEnter height: ");
    }

    @Test
    void givenHeight5_whenRun_thenReturn_Pyramid5Height() {
        setInput("5");
        new PyramidPrinter().run();
        printOut();
        removeOutputDifference();
        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
        assertEquals("xxx", getOutputLines()[2]);
        assertEquals("xxxx", getOutputLines()[3]);
        assertEquals("xxxxx", getOutputLines()[4]);
    }

    @Test
    void givenZero_whenRun_thenReturnError() {
        setInput("0");
        new PyramidPrinter().run();
        printOut();
        removeOutputDifference();
        assertEquals("", getOutput());
    }

    @Test
    void given2parameters_whenRun_thenReturnError() {
        setInput("5 2");
        new PyramidPrinter().run();
        printOut();
        removeOutputDifference();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter.", getOutput());
    }

    @Test
    void givenNegative_whenRun_thenReturnError() {
        setInput("-1");
        new PyramidPrinter().run();
        printOut();
        removeOutputDifference();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter.", getOutput());
    }

    @Test
    void givenString_whenRun_thenReturnError() {
        setInput("ThisIsString");
        new PyramidPrinter().run();
        printOut();
        removeOutputDifference();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter.", getOutput());
    }

    @Test
    void givenEmpty_whenRun_thenReturnError() {
        setInput("");
        new PyramidPrinter().run();
        printOut();
        removeOutputDifference();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter.", getOutput());
    }
}