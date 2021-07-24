package homework_2.pyramid_printer;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PyramidPrinterTest extends UnitBase {

    @Test
    void given_1_whenRun_then_printPyramid() {
        setInput("1");

        new PyramidPrinter().run();

        removeFromOutput("Please input number");

        assertEquals("x", getOutputLines()[0]);
    }

    @Test
    void given_3_whenRun_then_printPyramid() {
        setInput("3");

        new PyramidPrinter().run();

        removeFromOutput("Please input number");

        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
        assertEquals("xxx", getOutputLines()[2]);
    }

    @Test
    void given_0_whenRun_then_printNothing() {
        setInput("0");

        new PyramidPrinter().run();

        removeFromOutput("Please input number");

        assertEquals("", getOutputLines()[0]);
    }

    @Test
    void given_emptyArgument_whenRun_then_printErrorMessage() {
        setInput("");

        new PyramidPrinter().run();

        assertTrue(getOutput().contains("Only 1 non-negative integer is allowed as passed parameter!"));
    }

    @Test
    void  given_smth_whenRun_then_printErrorMessage() {
        setInput("abc");

        new PyramidPrinter().run();

        assertTrue(getOutput().contains("Only 1 non-negative integer is allowed as passed parameter!"));
    }

    @Test
    void given_negativeInteger_whenRun_then_printErrorMessage() {
        setInput("-1");

        new PyramidPrinter().run();

        assertTrue(getOutput().contains("Only 1 non-negative integer is allowed as passed parameter!"));
    }

    @Test
    void given_floatingPointArgument_whenRun_then_printErrorMessage() {
        setInput("0.5");

        new PyramidPrinter().run();

        assertTrue(getOutput().contains("Only 1 non-negative integer is allowed as passed parameter!"));
    }

    @Test
    void given_tooBigNumber_whenRun_then_printErrorMessage() {
        setInput("9999999999");

        new PyramidPrinter().run();

        assertTrue(getOutput().contains("Only 1 non-negative integer is allowed as passed parameter!"));
    }

}