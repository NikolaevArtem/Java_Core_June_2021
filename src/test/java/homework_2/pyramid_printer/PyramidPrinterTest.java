package homework_2.pyramid_printer;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static homework_2.pyramid_printer.utils.MessageType.ERROR_WRONG_FORMAT_MESSAGE;
import static homework_2.pyramid_printer.utils.MessageType.INFO_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PyramidPrinterTest extends UnitBase {

    void run() {
        new PyramidPrinter().start();
        removeFromOutput(INFO_MESSAGE.getMessage());
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
        assertEquals(ERROR_WRONG_FORMAT_MESSAGE.getMessage(), getOutput());
    }

    @Test
    void givenNegativeNumber_whenRun_getWrongFormatMessage() {
        setInput("-5");
        run();
        assertEquals(ERROR_WRONG_FORMAT_MESSAGE.getMessage(), getOutput());
    }
}
