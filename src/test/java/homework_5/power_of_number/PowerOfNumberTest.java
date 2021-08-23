package homework_5.power_of_number;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerOfNumberTest extends UnitBase {

    @Test
    void given5and2_whenPoW_then25() {
        String expected = String.valueOf((int) Math.pow(5, 2));
        setInput("5 2");
        PowerOfNumber.run();
        assertEquals(expected, getOutput());
        printOut();
    }

    @Test
    void given0and5_whenPoW_then25() {
        String expected = String.valueOf((int) Math.pow(0, 5));
        setInput("0 5");
        PowerOfNumber.run();
        assertEquals(expected, getOutput());
        printOut();
    }

    @Test
    void given3and0_whenPoW_then1() {
        String expected = String.valueOf((int) Math.pow(3, 0));
        setInput("3 0");
        PowerOfNumber.run();
        assertEquals(expected, getOutput());
        printOut();
    }

    @Test
    void givenWrongInput_whenPoW_thenPrintError() {
        String expected = "Only 2 non-negative integers are allowed";
        setInput("asd fdf");
        PowerOfNumber.run();
        assertEquals(expected, getOutput());
        printOut();
    }

    @Test
    void givenOnlyOneArgument_whenPoW_thenPrintError() {
        String expected = "Only 2 non-negative integers are allowed";
        setInput("5");
        PowerOfNumber.run();
        assertEquals(expected, getOutput());
        printOut();
    }
}