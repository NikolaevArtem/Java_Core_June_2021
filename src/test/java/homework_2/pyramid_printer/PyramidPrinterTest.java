package homework_2.pyramid_printer;

import base.UnitBase;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class PyramidPrinterTest extends UnitBase {

    @Test
    void givenEmptyArgument_whenRun_thenNoSuchElementException() {
        setInput("");
        assertThrows(NoSuchElementException.class, () -> new PyramidPrinter().run());
    }

    @Test
    void givenZeroAsArgument_whenRun_thenEmptyString() {
        setInput("0");
        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Welcome to the Pyramid Printer Application");
        removeFromOutput("Enter the height parameter");
        assertEquals("", getOutputLines()[0]);
    }


    @Test
    void givenTenAsArgument_whenRun_thenTenRowsPyramid() {
        setInput("10");
        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Welcome to the Pyramid Printer Application");
        removeFromOutput("Enter the height parameter");
        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
        assertEquals("xxx", getOutputLines()[2]);
        assertEquals("xxxx", getOutputLines()[3]);
        assertEquals("xxxxx", getOutputLines()[4]);
        assertEquals("xxxxxx", getOutputLines()[5]);
        assertEquals("xxxxxxx", getOutputLines()[6]);
        assertEquals("xxxxxxxx", getOutputLines()[7]);
        assertEquals("xxxxxxxxx", getOutputLines()[8]);
        assertEquals("xxxxxxxxxx", getOutputLines()[9]);
    }

    @Test
    void givenMinusOneAsArgument_whenRun_thenErrorMessage() {
        setInput("-1");
        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Welcome to the Pyramid Printer Application");
        removeFromOutput("Enter the height parameter");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }


    @Test
    void givenStringValueAsArgument_whenRun_thenErrorMessage() {
        setInput("StringAsValue");
        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Welcome to the Pyramid Printer Application");
        removeFromOutput("Enter the height parameter");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }


    @Test
    void givenTwoArgumentsAsArgument_whenRun_thenErrorMessage() {
        setInput("1 2");
        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Welcome to the Pyramid Printer Application");
        removeFromOutput("Enter the height parameter");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }


    @Test
    void givenDoubleAsArgument_whenRun_thenErrorMessage() {
        setInput("0.12345");
        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Welcome to the Pyramid Printer Application");
        removeFromOutput("Enter the height parameter");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

}