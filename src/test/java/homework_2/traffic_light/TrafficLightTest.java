package homework_2.traffic_light;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficLightTest extends UnitBase {

    @Test
    public void given10Sec_whenRun_thenGreen() {
        setInput("10");
        new TrafficLight().run();
        removeFromOutput("Enter seconds:");
        assertEquals("Colour of traffic light is GREEN", getOutputLines()[0]);
    }

    @Test
    public void given99Sec_whenRun_thenYellow() {
        setInput("99");
        new TrafficLight().run();
        removeFromOutput("Enter seconds:");
        assertEquals("Colour of traffic light is YELLOW", getOutputLines()[0]);
    }

    @Test
    public void given165Sec_whenRun_thenRed() {
        setInput("165");
        new TrafficLight().run();
        removeFromOutput("Enter seconds:");
        assertEquals("Colour of traffic light is RED", getOutputLines()[0]);
    }

    @Test
    public void given659Sec_whenRun_thenYellow() {
        setInput("659");
        new TrafficLight().run();
        removeFromOutput("Enter seconds:");
        assertEquals("Colour of traffic light is YELLOW", getOutputLines()[0]);
    }

    @Test
    public void givenString_whenRun_thenErrorMsg() {
        setInput("aaa");
        new TrafficLight().run();
        removeFromOutput("Enter seconds:");
        assertEquals("Can't parse input string to integer", getOutputLines()[0]);
    }

    @Test
    public void givenNegativeNumber_whenRun_thenErrorMsg() {
        setInput("-1");
        new TrafficLight().run();
        removeFromOutput("Enter seconds:");
        assertEquals("Input String is out of range", getOutputLines()[0]);
    }

    @Test
    public void givenTooBigNumber_whenRun_thenErrorMsg() {
        setInput("86400");
        new TrafficLight().run();
        removeFromOutput("Enter seconds:");
        assertEquals("Input String is out of range", getOutputLines()[0]);
    }
}
