package homework_2.pyramid_printer;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PyramidPrinterTest extends UnitBase {

    @Test
    public void givenTwo_whenRun() {
        setInput("2");
        new PyramidPrinter().run();
        removeFromOutput("Enter height of pyramid:");
        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
    }

    @Test
    public void givenMinusOne_whenRun() {
        setInput("-1");
        new PyramidPrinter().run();
        removeFromOutput("Enter height of pyramid:");
        assertEquals("Out of range (input should be >= 0)", getOutputLines()[0]);
    }

    @Test
    public void givenString_whenRun(){
        setInput("aaa");
        new PyramidPrinter().run();
        removeFromOutput("Enter height of pyramid:");
        assertEquals("Can't parse input string to integer", getOutputLines()[0]);
    }
}
