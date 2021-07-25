package homework_2;

import homework_2.pyramid_printer.PyramidPrinter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PyramidPrinterTest extends base.UnitBase {

    @Test
    void correctInputTest1() {
        setInput("2");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Please, input number:");

        assertEquals("x", getOutputLines()[0]);
        assertEquals("xx", getOutputLines()[1]);
    }

    @Test
    void correctInputTest2() {
        setInput("8");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Please, input number:");

        assertEquals("x", getOutputLines()[0]);
        assertEquals("xxxx", getOutputLines()[3]);
        assertEquals("xxxxxxxx", getOutputLines()[7]);
    }

    @Test
    void nullInputTest(){
        setInput("0");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Please, input number:");

        assertEquals("", getOutputLines()[0]);
    }

    @Test
    void negativeInputTest(){
        setInput("-10");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Please, input number:");

        assertEquals("Number should be non-negative!", getOutput());
    }

    @Test
    void stringInputTest(){
        setInput("string");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Please, input number:");

        assertEquals("Wrong input format!", getOutput());
    }

    @Test
    void bigNumberInputTest(){
        setInput("5666677772444198455342456");

        new PyramidPrinter().run();
        printOut();
        removeFromOutput("Please, input number:");

        assertEquals("Wrong input format!", getOutput());
    }
}
