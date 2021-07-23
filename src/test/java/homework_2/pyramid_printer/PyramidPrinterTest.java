package homework_2.pyramid_printer;

import base.UnitBaseMode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * todo Document type PyramidPrinterTest
 */
class PyramidPrinterTest extends UnitBaseMode {

    private final PyramidPrinter pyramidPrinter = new PyramidPrinter();
    private final String METHOD_NAME = "run";
    private final String STRING_TO_DEL = "Enter the number";

    @Test
    void runTest() {
        setInput("0");

        run(pyramidPrinter, METHOD_NAME, STRING_TO_DEL);

        assertEquals("", getOutput());
    }

    @Test
    void runTest1() {
        setInput("1");

        run(pyramidPrinter, METHOD_NAME, STRING_TO_DEL);
        String[] expectedArray = {"x"};

        assertArrayEquals(expectedArray, getOutputLines());
    }

    @Test
    void runTest2() {
        setInput("2");

        run(pyramidPrinter, METHOD_NAME, STRING_TO_DEL);
        String[] expectedArray = {"x", "xx"};

        assertArrayEquals(expectedArray, getOutputLines());
    }

    @Test
    void runTest10() {
        setInput("10");

        run(pyramidPrinter, METHOD_NAME, STRING_TO_DEL);
        String[] expectedArray = {"x", "xx", "xxx", "xxxx", "xxxxx", "xxxxxx", "xxxxxxx", "xxxxxxxx", "xxxxxxxxx", "xxxxxxxxxx"};

        assertArrayEquals(expectedArray, getOutputLines());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "asd", "123456789012345678901234567890"})
    void runTestInvalidArg(String input) {
        setInput(input);

        run(pyramidPrinter, METHOD_NAME, STRING_TO_DEL);

        assertTrue(getOutput().contains("Only 1 non-negative integer is allowed as passed parameter"));
    }
}