package homework_2.pyramid_printer;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PyramidPrinterDTest extends UnitBase {
    private void run() {
        new PyramidPrinterD().run();
        removeFromOutput("Enter a valid INT value for create a pyramid:");
        printOut();
    }

    @Test
    void runWithOneArgument() {
        setInput("1");

        run();

        assertEquals("1", getOutput());
    }

    @Test
    void runWithThreeArguments() {
        setInput("3");

        run();

        assertEquals("3", getOutputLines()[0]);
        assertEquals("33", getOutputLines()[1]);
        assertEquals("333", getOutputLines()[2]);
    }

    @Test
    void runWithZeroArguments() {
        setInput("0");

        run();

        assertEquals("",getOutput());
    }

    @Test
    void runWithNegativeArgument() {
        setInput("-5");

        run();

        assertEquals("Only 1 non-negative integer is allowed.",getOutput());
    }

    @Test
    void runWithNotNumberArgument() {
        setInput("asd");

        run();

        assertEquals("Only 1 non-negative integer is allowed.",getOutput());
    }
}