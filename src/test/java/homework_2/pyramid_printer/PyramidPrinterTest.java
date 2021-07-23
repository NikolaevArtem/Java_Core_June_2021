package homework_2.pyramid_printer;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PyramidPrinterTest extends UnitBase {

    @Test
    void givenOne_whenRun_thenPrintPyramid() {
        setInput("1");
        new PyramidPrinter().run();
        printOut();
        removeFromOutput("How many levels should the pyramid be?");

        assertEquals("x", getOutputLines()[0]);
    }

    @Test
    void givenFive_whenRun_thenPrintPyramid() {
        setInput("5");
        new PyramidPrinter().run();
        printOut();
        removeFromOutput("How many levels should the pyramid be?");

        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
        assertEquals("xxx", getOutputLines()[2]);
        assertEquals("xxxx", getOutputLines()[3]);
        assertEquals("xxxxx", getOutputLines()[4]);
    }
}
