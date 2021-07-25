package homework_2.pyramid_printer;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.Constants.ERROR_MESSAGE_PYRAMID_PRINTER;
import static utils.Constants.INFO_MESSAGE_PYRAMID_PRINTER;

public class PyramidPrinterTest extends UnitBase {

    void run() {
        new PyramidPrinter().run();
        removeFromOutput(INFO_MESSAGE_PYRAMID_PRINTER);
        printOut();
    }

    @Test
    void given1_whenRun_thenPrintPyramid() {
        setInput("1");
        run();
        assertEquals("x", getOutput());
    }

    @Test
    void given5_whenRun_thenPrintPyramid() {
        setInput("5");
        run();
        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
        assertEquals("xxx", getOutputLines()[2]);
        assertEquals("xxxx", getOutputLines()[3]);
        assertEquals("xxxxx", getOutputLines()[4]);
    }

    @Test
    void givenNaN_whenRun_getWrongFormatMessage() {
        setInput("word");
        run();
        assertEquals(ERROR_MESSAGE_PYRAMID_PRINTER, getOutput());
    }

    @Test
    void givenNegativeNumber_whenRun_getWrongFormatMessage() {
        setInput("-5");
        run();
        assertEquals(ERROR_MESSAGE_PYRAMID_PRINTER, getOutput());
    }
}
