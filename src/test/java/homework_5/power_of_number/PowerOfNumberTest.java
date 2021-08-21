package homework_5.power_of_number;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerOfNumberTest extends UnitBase {
    final private static String ERROR_MSG = "Only 2 non-negative integers are allowed";

    @Test
    public void given02_whenRun_thenPrint0() throws Throwable {
        setInput("0 2");
        PowerOfNumber.run();
        printOut();
        removeFromOutput("Enter 2 non-negative integers");

        assertEquals(0, Integer.parseInt(getOutput()));
    }

    @Test
    public void given24_whenRun_thenPrint16() throws Throwable {
        setInput("2 4");
        PowerOfNumber.run();
        printOut();
        removeFromOutput("Enter 2 non-negative integers");

        assertEquals(16, Integer.parseInt(getOutput()));
    }

    @Test
    public void given20_whenRun_thenPrint1() throws Throwable {
        setInput("2 0");
        PowerOfNumber.run();
        printOut();
        removeFromOutput("Enter 2 non-negative integers");

        assertEquals(1, Integer.parseInt(getOutput()));
    }

    @Test
    public void givenOneNumber_whenRun_thenPrintErr() throws Throwable {
        setInput("2 ");
        PowerOfNumber.run();
        printOut();
        removeFromOutput("Enter 2 non-negative integers");

        assertEquals(ERROR_MSG, getOutput());
    }

    @Test
    public void givenMoreNumbersThenNeeded_whenRun_thenPrintErr() throws Throwable {
        setInput("2 3 4");
        PowerOfNumber.run();
        printOut();
        removeFromOutput("Enter 2 non-negative integers");

        assertEquals(ERROR_MSG, getOutput());
    }

    @Test
    public void givenString_whenRun_thenPrintErr() throws Throwable {
        setInput("asg djj");
        PowerOfNumber.run();
        printOut();
        removeFromOutput("Enter 2 non-negative integers");

        assertEquals(ERROR_MSG, getOutput());
    }

    @Test
    public void givenDoubleNumbers_whenRun_thenPrintErr() throws Throwable {
        setInput("2.0 3.0");
        PowerOfNumber.run();
        printOut();
        removeFromOutput("Enter 2 non-negative integers");

        assertEquals(ERROR_MSG, getOutput());
    }

    @Test
    public void givenNegative_whenRun_thenPrintErr() throws Throwable {
        setInput("-2 3");
        PowerOfNumber.run();
        printOut();
        removeFromOutput("Enter 2 non-negative integers");

        assertEquals(ERROR_MSG, getOutput());
    }

}
