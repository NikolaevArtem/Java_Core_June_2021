package homework_2.pyramid_printer;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PyramidPrinterTest extends UnitBase {

    @Test
    void givenEmpty_whenRun_thenError() {
        setInput("");

        new PyramidPrinter().run();
        printOut();

        assertEquals("Error: integer only", getOutputLines()[0]);
    }

    @Test
    void givenString_whenRun_thenError() {
        setInput("s");

        new PyramidPrinter().run();
        printOut();

        assertEquals("Error: integer only", getOutputLines()[0]);
    }


    @Test
    void given_0_whenRun_thenError() {
        setInput("0");

        new PyramidPrinter().run();
        printOut();

        assertEquals("", getOutputLines()[0]);
    }

    @Test
    void given_1_whenRun_thenPrint() {
        setInput("1");

        new PyramidPrinter().run();
        printOut();

        assertEquals("x", getOutputLines()[0]);
    }


    @Test
    void given_2_whenRun_thenPrint() {
        setInput("2");

        new PyramidPrinter().run();
        printOut();

        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
    }


}


