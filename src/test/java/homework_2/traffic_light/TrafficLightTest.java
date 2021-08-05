package homework_2.traffic_light;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficLightTest extends UnitBase {
    private static final String RED = "\u001B[31mRED\u001B[0m";
    private static final String YELLOW = "\u001B[33mYELLOW\u001B[0m";
    private static final String GREEN = "\u001B[33mGREEN\u001B[0m";

    @Test
    public void given10Sec_whenRun_thenGreen() {
        setInput("10");
        new TrafficLight().run();
        removeFromOutput("Enter seconds:");
        assertEquals(GREEN, getOutputLines()[0]);
    }

    @Test
    public void given99Sec_whenRun_thenYellow() {
        setInput("99");
        new TrafficLight().run();
        removeFromOutput("Enter seconds:");
        assertEquals(YELLOW, getOutputLines()[0]);
    }

    @Test
    public void given165Sec_whenRun_thenRed() {
        setInput("165");
        new TrafficLight().run();
        removeFromOutput("Enter seconds:");
        assertEquals(RED, getOutputLines()[0]);
    }

    @Test
    public void given659Sec_whenRun_thenYellow() {
        setInput("659");
        new TrafficLight().run();
        removeFromOutput("Enter seconds:");
        assertEquals(YELLOW, getOutputLines()[0]);
    }

    @Test
    public void givenString_whenRun_thenErrorMsg() {
        setInput("aaa");
        new TrafficLight().run();
        removeFromOutput("Enter seconds:");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    public void givenNegativeNumber_whenRun_thenErrorMsg() {
        setInput("-1");
        new TrafficLight().run();
        removeFromOutput("Enter seconds:");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    public void givenTooBigNumber_whenRun_thenErrorMsg() {
        setInput("86400");
        new TrafficLight().run();
        removeFromOutput("Enter seconds:");
        assertEquals("The day is over", getOutputLines()[0]);
    }
}
