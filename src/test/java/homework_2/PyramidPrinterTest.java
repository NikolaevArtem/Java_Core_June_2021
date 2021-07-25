package homework_2;

import base.UnitBase;
import homework_2.pyramidPrinter.PyramidPrinter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PyramidPrinterTest extends UnitBase {

    @Test
    void given5_whenRun_thenFiveLinesPrinted() {
        setInput("5");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Please, input a number:");

        Assertions.assertEquals("x", getOutputLines()[0]);
        Assertions.assertEquals("xx", getOutputLines()[1]);
        Assertions.assertEquals("xxx", getOutputLines()[2]);
        Assertions.assertEquals("xxxx", getOutputLines()[3]);
        Assertions.assertEquals("xxxxx", getOutputLines()[4]);
    }

    @Test
    void givenZero_whenRun_thenEmpty() {
        setInput("0");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Please, input a number:");

        Assertions.assertEquals("", getOutput());
    }

    @Test
    void givenNegativeNumber_whenRun_thenError() {
        setInput("-1");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Please, input a number:");

        Assertions.assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutput());
    }

    @Test
    void givenNaN_whenRun_thenError() {
        setInput("text");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Please, input a number:");

        Assertions.assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutput());
    }
}
