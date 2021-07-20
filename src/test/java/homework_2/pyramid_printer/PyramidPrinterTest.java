package homework_2.pyramid_printer;

import org.junit.jupiter.api.Test;

public class PyramidPrinterTest {

    @Test
    void test() {
        final String[] args = new String[0];
        final String actual = new PyramidPrinter(args).checkAndPrint();
        final String expected = "x";
    }

}
