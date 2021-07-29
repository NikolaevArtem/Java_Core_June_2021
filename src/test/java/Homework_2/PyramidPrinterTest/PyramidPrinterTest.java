package Homework_2.PyramidPrinterTest;

import Homework_2.PyramidPrinter.PyramidPrinter;
import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PyramidPrinterTest extends UnitBase {

    @Test
    void CaseSymbol_error() {
        setInput("Hello!");

        new PyramidPrinter().run();

        removeFromOutput("Enter the pyramid height as a single integer: ");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutput());

    }

    @Test
    void CaseDouble_error() {
        setInput("0.1");

        new PyramidPrinter().run();

        removeFromOutput("Enter the pyramid height as a single integer: ");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutput());
    }

    @Test
    void CaseStandard_pass() {
        setInput("4");

        new PyramidPrinter().run();

        printOut();
        removeFromOutput("Enter the pyramid height as a single integer: ");
        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
        assertEquals("xxx", getOutputLines()[2]);
        assertEquals("xxxx", getOutputLines()[3]);
    }

    @Test
    void CaseZero_pass() {
        setInput("0");

        new PyramidPrinter().run();

        removeFromOutput("Enter the pyramid height as a single integer: ");
        assertEquals("", getOutput());
    }

    @Test
    void CaseNegative_error() {
        setInput("-5");

        new PyramidPrinter().run();

        removeFromOutput("Enter the pyramid height as a single integer: ");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutput());
    }

    @Test
    void CaseLong_error() {
        setInput("2147483648");

        new PyramidPrinter().run();

        removeFromOutput("Enter the pyramid height as a single integer: ");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutput());
    }

    @Test
    void CaseOutOfMemory_error() {
        setInput("100500");

        new PyramidPrinter().run();

        removeFromOutput("Enter the pyramid height as a single integer: ");
        assertEquals("Heap space is out of memory, please input a smaller integer", getOutput());
    }
}
