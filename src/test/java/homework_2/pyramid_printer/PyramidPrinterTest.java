package homework_2.pyramid_printer;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PyramidPrinterTest extends UnitBase {

    private void run(){
        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Please input number:");
    }

    @Test
    void given0_whenRun_thenPrintZero(){
        setInput("0");

        run();

        assertEquals("n = 0", getOutputLines()[0]);

    }

    @Test
    void given1_whenRun_thenPrintPyramid(){
        setInput("1");

        run();

        assertEquals("x", getOutputLines()[0]);
    }

    @Test
    void given3_whenRun_thenPrintPyramid(){
        setInput("3");

        run();

        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
        assertEquals("xxx", getOutputLines()[2]);

    }

    @Test
    void givenSmth_whenRun_thenPrintErrorMessage(){
        setInput("dksksk");

        run();

        assertEquals("Only 1 non-negative integer integer is allowed as passed parameter", getOutputLines()[0]);

    }
}
