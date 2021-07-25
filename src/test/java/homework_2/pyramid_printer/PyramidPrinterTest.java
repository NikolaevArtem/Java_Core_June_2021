package homework_2.pyramid_printer;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PyramidPrinterTest extends UnitBase {

    @Test
    void Empty_Input_Error() {
        setInput("");

        new PyramidPrinter().run();
        printOut();

        assertEquals("Error: integer only", getOutputLines()[0]);
    }

    @Test
    void String_Input_Error() {
        setInput("s");

        new PyramidPrinter().run();
        printOut();

        assertEquals("Error: integer only", getOutputLines()[0]);
    }


    @Test
    void Zero_Input_Empty() {
        setInput("0");

        new PyramidPrinter().run();
        printOut();

        assertEquals("", getOutputLines()[0]);
    }

    @Test
    void One_Input_OneString() {
        setInput("1");

        new PyramidPrinter().run();
        printOut();

        assertEquals("x", getOutputLines()[0]);
    }


    @Test
    void Two_Input_TwoString() {
        setInput("2");

        new PyramidPrinter().run();
        printOut();

        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
    }


}


