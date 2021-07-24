package homework_2.pyramid_printer;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PyramidPrinterTest extends UnitBase {

    @Test
    void ghkghk() {
        setInput("1");
        new PyramidPrinter().run();
        assertEquals("x", getOutputLines()[0]);
    }

    @Test
    void printPyramid() {
        setInput("2");
        new PyramidPrinter().run();
        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
    }
}