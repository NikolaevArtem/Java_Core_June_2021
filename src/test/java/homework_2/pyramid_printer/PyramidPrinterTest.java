package homework_2.pyramid_printer;

import base.UnitBase;
import org.junit.jupiter.api.Test;


public class PyramidPrinterTest extends UnitBase {

    @Test
    void givenInts_whenRun_thenPrintPyramid() {
        setInput("1");
        new PyramidPrinter().run();
        final String res = getOutput();
    }

}
