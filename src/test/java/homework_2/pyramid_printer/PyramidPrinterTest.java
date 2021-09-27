package homework_2.pyramid_printer;

import base.UnitBase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PyramidPrinterTest extends UnitBase {
    private final String GREET = "Enter the base of the pyramid, valid value is integer:";
    private final String HINT = "Only 1 non-negative integer is allowed as passed parameter! Please, try again";
    PyramidPrinter pyramidPrinter = new PyramidPrinter();


    @Test
    void given0_whenOk_then_0 (){
        setInput("0");
        pyramidPrinter.run();
        printOut();
        removeFromOutput(GREET);
        assertEquals("", getOutputLines()[0]);
    }

    @Test
    void given1_whenOk_then_1 (){
        setInput("1");
        pyramidPrinter.run();
        printOut();
        removeFromOutput(GREET);
        assertEquals("x", getOutputLines()[0]);
    }

    @Test
    void given2_whenOk_then_2 (){
        setInput("2");
        pyramidPrinter.run();
        printOut();
        removeFromOutput(GREET);
        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
    }

    @Test
    void given5_whenOk_then_5 (){
        setInput("5");
        pyramidPrinter.run();
        printOut();
        removeFromOutput(GREET);
        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
        assertEquals("xxx", getOutputLines()[2]);
        assertEquals("xxxx", getOutputLines()[3]);
        assertEquals("xxxxx", getOutputLines()[4]);

    }

    @Test
    void givenString_whenBad_then_Hint (){
        setInput("Qwe");
        pyramidPrinter.run();
        printOut();
        removeFromOutput(GREET);
        assertEquals(HINT, getOutputLines()[0]);
    }

    @Test
    void givenFractal_whenBad_then_Hint (){
        setInput("2.5");
        pyramidPrinter.run();
        printOut();
        removeFromOutput(GREET);
        assertEquals(HINT, getOutputLines()[0]);
    }

    @Test
    void givenNegative_whenBad_then_Hint (){
        setInput("-5");
        pyramidPrinter.run();
        printOut();
        removeFromOutput(GREET);
        assertEquals(HINT, getOutputLines()[0]);
    }

    @Test
    void givenBigInt_whenBad_then_Hint (){
        setInput("99999999999999999999999999999");
        pyramidPrinter.run();
        printOut();
        removeFromOutput(GREET);
        assertEquals(HINT, getOutputLines()[0]);
    }

}
