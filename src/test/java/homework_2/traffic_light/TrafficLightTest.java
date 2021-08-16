package homework_2.traffic_light;

import base.UnitBase;
import homework_2.random_chars_table.RandomCharsTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrafficLightTest extends UnitBase {
    private void run(){
        new TrafficLight().run();
        printOut();
        removeFromOutput("Input number of seconds: ");
    }

    @Test
    void given0_whenRun_thenPrintColor(){
        setInput("0");

        run();

        assertTrue(getOutputLines()[0].contains("GREEN"));

    }

    @Test
    void given57_whenRun_thenPrintColor(){
        setInput("57");

        run();

        assertTrue(getOutputLines()[0].contains("YELLOW"));

    }

    @Test
    void givenMin_whenRun_thenPrintErrorMessage(){
        setInput("-3");

        run();

        assertTrue(getOutputLines()[0].contains("The day is over"));

    }

    @Test
    void givenMax_whenRun_thenPrintErrorMessage(){
        setInput("901000290");

        run();

        assertTrue(getOutputLines()[0].contains("The day is over"));

    }

    @Test
    void givenSmth_whenRun_thenPrintErrorMessage(){
        setInput("sdfghj");

        run();

        assertEquals("Only 1 non-negative integer integer is allowed as passed parameter", getOutputLines()[0]);

    }
}
