package homework_2;

import base.UnitBase;
import homework_2.traffic_light.TrafficLight;
import org.junit.jupiter.api.Test;

import static homework_2.traffic_light.TrafficLight.ERROR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrafficLightTest extends UnitBase {

    @Test
    void given2_whenRun_thenGreen() {
        setInput("2");
        runPrintRemoveFromOutput();
        assertTrue(getOutput().contains("GREEN"));
    }

    @Test
    void given95_whenRun_thenYellow() {
        setInput("95");
        runPrintRemoveFromOutput();
        assertTrue(getOutput().contains("YELLOW"));
    }

    @Test
    void given100_whenRun_thenRed() {
        setInput("160");
        runPrintRemoveFromOutput();
        assertTrue(getOutput().contains("RED"));
    }

    @Test
    void givenNAN_whenRun_thenERROR() {
        setInput("abc");
        runPrintRemoveFromOutput();
        assertEquals(ERROR, getOutput());
    }

    @Test
    void givenNegNumber_whenRun_thenERROR() {
        setInput("-1");
        runPrintRemoveFromOutput();
        assertEquals(ERROR, getOutput());
    }

    @Test
    void given2args_whenRun_thenERROR() {
        setInput("1 2");
        runPrintRemoveFromOutput();
        assertEquals(ERROR, getOutput());
    }

    @Test
    void givenBigNumber_whenRun_thenDayIsOver() {
        setInput("86400");
        runPrintRemoveFromOutput();
        assertEquals("The day is over", getOutput());
    }

    private void runPrintRemoveFromOutput() {
        new TrafficLight().run();
        printOut();
        removeFromOutput("Please, input a number of seconds:");
    }
}
