package homework_2.traffic_light;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficLightTest extends UnitBase {

    @Test
    void givenEmpty_whenRun_thenError() {
        setInput("");

        new TrafficLight().run();
        printOut();

        assertEquals("Error: integer only", getOutputLines()[0]);
    }

    @Test
    void givenNegative_whenRun_thenError() {
        setInput("-1");

        new TrafficLight().run();
        printOut();

        assertEquals("Error: positive only", getOutputLines()[0]);
    }

    @Test
    void givenString_whenRun_thenError() {
        setInput("s");

        new TrafficLight().run();
        printOut();

        assertEquals("Error: integer only", getOutputLines()[0]);
    }

    @Test
    void given_20_whenRun_thenGreen() {
        setInput("20");

        new TrafficLight().run();
        printOut();

        assertEquals("Green", getOutputLines()[0]);
    }

    @Test
    void given_36_whenRun_thenYellow() {
        setInput("36");

        new TrafficLight().run();
        printOut();

        assertEquals("Yellow", getOutputLines()[0]);
    }

    @Test
    void given_45_whenRun_thenRed() {
        setInput("45");

        new TrafficLight().run();
        printOut();

        assertEquals("Red", getOutputLines()[0]);
    }

    @Test
    void given_56_whenRun_thenYellow() {
        setInput("56");

        new TrafficLight().run();
        printOut();

        assertEquals("Yellow", getOutputLines()[0]);
    }

    @Test
    void given_80_whenRun_thenGreen() {
        setInput("80");

        new TrafficLight().run();
        printOut();

        assertEquals("Green", getOutputLines()[0]);
    }
}
