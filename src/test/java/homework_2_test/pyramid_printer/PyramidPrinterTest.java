package homework_2_test.pyramid_printer;

import base.UnitBase;
import homework_2.pyramid_printer.PyramidPrinter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PyramidPrinterTest extends UnitBase {

    private final String errorMsg = "Only 1 non-negative integer is allowed as passed parameter";

    @Test
    void givenThree_whenRun_thenPrintPyramid() {
        setInput("3");
        new PyramidPrinter().run();

        removeFromOutput("Enter pyramid height: ");

        StringBuilder out = new StringBuilder("x");
        for (int i = 0; i < 3; i++) {
            assertEquals(out.toString(), getOutputLines()[i]);
            out.append("x");
        }
    }

    @Test
    void givenThreeAndSpaces_whenRun_thenPrintPyramid() {
        setInput(" 3 ");
        new PyramidPrinter().run();

        removeFromOutput("Enter pyramid height: ");

        StringBuilder out = new StringBuilder("x");
        for (int i = 0; i < 3; i++) {
            assertEquals(out.toString(), getOutputLines()[i]);
            out.append("x");
        }
    }

    @Test
    void givenZero_whenRun_thenEmptyOutput() {
        setInput("0");
        new PyramidPrinter().run();

        removeFromOutput("Enter pyramid height: ");

        assertEquals("", getOutput());
    }

    @Test
    void givenNegativeNumber_whenRun_thenErrorMessage() {
        setInput("-1");
        new PyramidPrinter().run();

        removeFromOutput("Enter pyramid height: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenTwoNumbers_whenRun_thenErrorMessage() {
        setInput("2 2");
        new PyramidPrinter().run();

        removeFromOutput("Enter pyramid height: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenWord_whenRun_thenErrorMessage() {
        setInput("three");
        new PyramidPrinter().run();

        removeFromOutput("Enter pyramid height: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenValidNumberAndWord_whenRun_thenErrorMessage() {
        setInput("3 three");
        new PyramidPrinter().run();

        removeFromOutput("Enter pyramid height: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenFloatingPoint_whenRun_thenErrorMessage() {
        setInput("3.0");
        new PyramidPrinter().run();

        removeFromOutput("Enter pyramid height: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenNonAlphabetic_whenRun_thenErrorMessage() {
        setInput("$");
        new PyramidPrinter().run();

        removeFromOutput("Enter pyramid height: ");

        assertEquals(errorMsg, getOutput());
    }
}