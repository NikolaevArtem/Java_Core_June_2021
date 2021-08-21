package homework_5.power_of_number;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerOfNumberTest extends UnitBase {

    PowerOfNumber powerOfNumber = new PowerOfNumber();

    private static final String ERROR = "Only 2 non-negative integers are allowed";

    @Test
    void test3_inPow_5() {
        String expected = String.valueOf((int) Math.pow(3, 5));
        setInput("3 5");
        powerOfNumber.run();
        printOut();
        removeFromOutput("Please, input the values in format: number power\n");
        assertEquals(expected, getOutputLines()[0]);
    }

    @Test
    void test0_inPow_0() {
        String expected = String.valueOf((int) Math.pow(0, 0));
        setInput("0 0");
        powerOfNumber.run();
        printOut();
        removeFromOutput("Please, input the values in format: number power\n");
        assertEquals(expected, getOutputLines()[0]);
    }

    @Test
    void givenEmptyString_WhenGetInput_ThenError() {
        setInput("");
        powerOfNumber.run();
        printOut();
        removeFromOutput("Please, input the values in format: number power\n");
        assertEquals(ERROR, getOutputLines()[0]);
    }

    @Test
    void givenMoreValues_WhenGetInput_ThenError() {
        setInput("1 2 3 4 str");
        powerOfNumber.run();
        printOut();
        removeFromOutput("Please, input the values in format: number power\n");
        assertEquals(ERROR, getOutputLines()[0]);
    }

    @Test
    void givenLessValues_WhenGetInput_ThenError() {
        setInput("1  ");
        powerOfNumber.run();
        printOut();
        removeFromOutput("Please, input the values in format: number power\n");
        assertEquals(ERROR, getOutputLines()[0]);
    }

    @Test
    void givenDoubles_WhenGetInput_ThenError() {
        setInput("1.93 2.47");
        powerOfNumber.run();
        printOut();
        removeFromOutput("Please, input the values in format: number power\n");
        assertEquals(ERROR, getOutputLines()[0]);
    }

    @Test
    void givenOverflowNumbers_WhenGetInput_ThenError() {
        setInput("999999999999999999 999999999999999999");
        powerOfNumber.run();
        printOut();
        removeFromOutput("Please, input the values in format: number power\n");
        assertEquals(ERROR, getOutputLines()[0]);
    }

}
