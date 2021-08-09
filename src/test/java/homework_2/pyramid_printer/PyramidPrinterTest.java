package homework_2.pyramid_printer;

import base.UnitBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PyramidPrinterTest extends UnitBase {

    public static final String ERROR_MESSAGE = "Only 1 non-negative integer is allowed as passed parameter";

    @Test
    public void notNumberArgumentTest() {
        PyramidPrinter pyramidPrinter = new PyramidPrinter();
        setInput("number");
        pyramidPrinter.run();
        printOut();
        Assertions.assertEquals(ERROR_MESSAGE, getOutputLines()[0]);
    }

    @Test
    public void zeroNumberArgument() {
        PyramidPrinter pyramidPrinter = new PyramidPrinter();
        setInput("0");
        pyramidPrinter.run();
        printOut();
        Assertions.assertEquals("", getOutputLines()[0]);
    }

    @Test
    public void negativeNumberArgument() {
        PyramidPrinter pyramidPrinter = new PyramidPrinter();
        setInput("-1");
        pyramidPrinter.run();
        printOut();
        Assertions.assertEquals(ERROR_MESSAGE, getOutputLines()[0]);
    }

    @Test
    public void pyramidTest() {
        PyramidPrinter pyramidPrinter = new PyramidPrinter();
        setInput("5");
        pyramidPrinter.run();
        printOut();
        String[] expected = "* ** *** **** *****".split(" ");
        String[] actual = getOutputLines();
        Assertions.assertArrayEquals(expected, actual);
    }
}
