package homework_2.pyramid_printer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class PyramidPrinterTest {

    @Test
    void test1() {
        PyramidPrinter ppr = new PyramidPrinter();

        try {
            ppr.buildPyramidString(3);
        } catch (ArithmeticException e) {
        } catch (NumberFormatException e) {

        }
        final StringBuilder actual = ppr.getPyramidString();
        final String expected = "x" + '\n' + "xx" + '\n' + "xxx" + '\n';

        assertEquals(actual.toString(), expected);
    }

    @Test
    void test2() {
        PyramidPrinter ppr = new PyramidPrinter();

        Assertions.assertThrows(ArithmeticException.class, () -> ppr.buildPyramidString(-3));
    }
}