package homework_5_test;

import base.UnitBase;
import homework_5.power_of_number.PowerOfNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PowerOfNumberTest extends UnitBase {

    private static final String ERROR_MESSAGE = "Only 2 non-negative integers are allowed";

    @Test
    void givenTwoTwo_whenRun_thenFour() {
        setInput("2 2");
        new PowerOfNumber().run();

        removeFromOutput("Enter number and power: ");

        String expected = "4";
        assertEquals(expected, getOutput());
    }

    @Test
    void givenTwoOne_whenRun_thenTwo() {
        setInput("2 1");
        new PowerOfNumber().run();

        removeFromOutput("Enter number and power: ");

        String expected = "2";
        assertEquals(expected, getOutput());
    }

    @Test
    void givenTwoZero_whenRun_thenOne() {
        setInput("2 0");
        new PowerOfNumber().run();

        removeFromOutput("Enter number and power: ");

        String expected = "1";
        assertEquals(expected, getOutput());
    }

    @Test
    void givenZeroTwo_whenRun_thenZero() {
        setInput("0 2");
        new PowerOfNumber().run();

        removeFromOutput("Enter number and power: ");

        String expected = "0";
        assertEquals(expected, getOutput());
    }

    @Test
    void givenTwo_whenRun_thenErrorMessage() {
        setInput("2");
        new PowerOfNumber().run();

        removeFromOutput("Enter number and power: ");

        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void givenTwoTwoTwo_whenRun_thenErrorMessage() {
        setInput("2 2 2");
        new PowerOfNumber().run();

        removeFromOutput("Enter number and power: ");

        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void givenTwoLetter_whenRun_thenErrorMessage() {
        setInput("2 a");
        new PowerOfNumber().run();

        removeFromOutput("Enter number and power: ");

        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void givenLetterTwo_whenRun_thenErrorMessage() {
        setInput("a 2");
        new PowerOfNumber().run();

        removeFromOutput("Enter number and power: ");

        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void givenTwoTwoLetter_whenRun_thenErrorMessage() {
        setInput("2 2 a");
        new PowerOfNumber().run();

        removeFromOutput("Enter number and power: ");

        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void givenString_whenRun_thenErrorMessage() {
        setInput("Hello");
        new PowerOfNumber().run();

        removeFromOutput("Enter number and power: ");

        assertEquals(ERROR_MESSAGE, getOutput());
    }
}
