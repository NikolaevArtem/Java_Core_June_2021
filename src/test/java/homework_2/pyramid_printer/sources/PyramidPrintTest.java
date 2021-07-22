package homework_2.pyramid_printer.sources;

import homework_2.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PyramidPrintTest extends UnitBase {

    @Test
    void testZero() {
        setInput("0");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Please, input pyramids height value: ");
        assertEquals("", getOutputLines()[0]);
    }

    @Test
    void testNegative() {
        setInput("-278");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Please, input pyramids height value: ");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void test7() {
        setInput("7");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Please, input pyramids height value: ");
        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
        assertEquals("xxx", getOutputLines()[2]);
        assertEquals("xxxx", getOutputLines()[3]);
        assertEquals("xxxxx", getOutputLines()[4]);
        assertEquals("xxxxxx", getOutputLines()[5]);
        assertEquals("xxxxxxx", getOutputLines()[6]);
    }

    @Test
    void testMAXIntegerPlusOne() {
        setInput(String.valueOf(Integer.MAX_VALUE + 1));

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Please, input pyramids height value: ");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void testString() {
        setInput("anytext");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Please, input pyramids height value: ");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[1]);
    }

}
