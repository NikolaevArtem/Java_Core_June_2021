package homework_2.pyramid_printer;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PyramidPrinterTest extends UnitBase {

    @Test
    void given_not_correct() {
        setInput("tjtjs");

        new PyramidPrinter().run();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void given_empty() {
        setInput("");

        new PyramidPrinter().run();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void given_big_integer() {
        setInput("4236262634264754");

        new PyramidPrinter().run();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void given_negative_integer() {
        setInput("-1");

        new PyramidPrinter().run();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void given_0() {
        setInput("0");

        new PyramidPrinter().run();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void given_1() {
        setInput("1");

        new PyramidPrinter().run();
        assertEquals("x", getOutputLines()[0]);
    }

    @Test
    void given_4() {
        setInput("4");

        new PyramidPrinter().run();
        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
        assertEquals("xxx", getOutputLines()[2]);
        assertEquals("xxxx", getOutputLines()[3]);
    }
}