package homework_2.pyramid_printer;

import base.UnitBase;
import org.junit.jupiter.api.Test;

public class PyramidPrinterTest extends UnitBase {

    @Test
    void test() {
        new PyramidPrinter().run();
        final String expected = "x";
    }

}
