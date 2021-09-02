package homework_2_tests;

import homework_2.pyramid_printer.PyramidPrinter;
import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PyramidPrinterTest extends UnitBase{

    private final String errorMassage = "Only 1 non-negative integer is allowed as passed parameter";

    private void run(){
        new PyramidPrinter().run();
        removeFromOutput("Please enter the number:");
        printOut();
    }

    @Test
    void given0_whenRun_thenEmptyPyramid() {
        setInput("0");

        run();

        assertEquals("", getOutput());
    }

    @Test
    void given1_whenRun_thenPrintPyramid() {
        setInput("1");

        run();

        assertEquals("x", getOutputLines()[0]);
    }

    @Test
    void given2_whenRun_thenPrintPyramid() {
        setInput("2");

        run();

        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
    }

    @Test
    void givenMinus1_whenRun_thenErrorMassage() {
        setInput("-1");

        run();

        assertEquals(errorMassage, getOutput());
    }

    @Test
    void givenLetter_whenRun_thenErrorMassage() {
        setInput("A");

        run();

        assertEquals(errorMassage, getOutput());
    }

    @Test
    void givenWord_whenRun_thenErrorMassage() {
        setInput("three");

        run();

        assertEquals(errorMassage, getOutput());
    }

    @Test
    void givenDigitWithSpace_whenRun_thenPyramidPrinter() {
        setInput("  2   ");

        run();

        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
    }

    @Test
    void givenTwoDigits_whenRun_thenErrorMassage() {
        setInput("1 2");

        run();

        assertEquals(errorMassage, getOutput());
    }

    @Test
    void givenDouble_whenRun_thenErrorMassage() {
        setInput("5.0");

        run();

        assertEquals(errorMassage, getOutput());
    }
}
