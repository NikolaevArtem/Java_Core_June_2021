package homework_2.pyramid_printer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PyramidPrinterTest {

    @Test
    void testRightCasePyramidPrinter() {
        PyramidPrinter ppr = new PyramidPrinter();

        final StringBuilder actual = ppr.buildPyramidString(3);
        final String expected = "x" + '\n' + "xx" + '\n' + "xxx" + '\n';

        assertEquals(actual.toString(), expected);
    }

    @Test
    void testNegativeNumberInParameterCasePyramidPrinter() {
        PyramidPrinter ppr = new PyramidPrinter();
        Assertions.assertThrows(ArithmeticException.class, () -> ppr.buildPyramidString(-3));
    }
}