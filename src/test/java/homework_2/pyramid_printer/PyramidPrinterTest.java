package homework_2.pyramid_printer;


import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class PyramidPrinterTest extends UnitBase {


    @Test
    public void givenOne_whenRun_thenPrintPyramid() {
        setInput("1");
        new PyramidPrinter().run();
        printOut();
        removeFromOutput("How many levels should the pyramid be?");
        assertEquals("x", getOutputLines()[0]);
    }

    @Test
    public void givenFive_whenRun_thenPrintPyramid() {
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

    @Test
    public void givenNegativeInt_whenRun_thenPrintPyramid() {
        setInput("-1");
        new PyramidPrinter().run();
        printOut();
        removeFromOutput("How many levels should the pyramid be?");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    public void givenZero_whenRun_thenPrintPyramid() {
        setInput("0");
        new PyramidPrinter().run();
        printOut();
        removeFromOutput("How many levels should the pyramid be?");
        assertEquals("", getOutputLines()[0]);
    }

    @Test
    public void givenNotInteger_whenRun_thenPrintPyramid() {
        setInput("asdfa");
        new PyramidPrinter().run();
        printOut();
        removeFromOutput("How many levels should the pyramid be?");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    public void givenMoreThanInteger_whenRun_thenPrintPyramid() {
        setInput("300000000000");
        new PyramidPrinter().run();
        printOut();
        removeFromOutput("How many levels should the pyramid be?");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }


}
