package homework_5.power_of_number;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerOfNumberTest extends UnitBase {
    private static final String ERROR_MSG = "Only 2 non-negative integers are allowed";

    @Test
    public void givenTwoNumbers_whenRun_thenAnswer(){
        setInput("2 3");
        new PowerOfNumber().run();
        assertEquals("8", getOutput());
    }

    @Test
    public void givenZeroPow_whenRun_thenOne(){
        setInput("10 0");
        new PowerOfNumber().run();
        assertEquals("1", getOutput());
    }

    @Test
    public void givenNegative_whenRun_thenErrorMsg(){
        setInput("2 -1");
        new PowerOfNumber().run();
        assertEquals(ERROR_MSG, getOutput());
    }

    @Test
    public void givenNotNumber_whenRun_thenErrorMsg(){
        setInput("2 abba");
        new PowerOfNumber().run();
        assertEquals(ERROR_MSG, getOutput());
    }
}
