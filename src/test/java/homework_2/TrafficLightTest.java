package homework_2;

import homework_2.traffic_light.TrafficLight;
import org.junit.jupiter.api.Test;

import static homework_2.traffic_light.TrafficLight.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficLightTest extends base.UnitBase {

    protected final String RED_VALUE = RED.substring(1);
    protected final String YELLOW_VALUE = YELLOW.substring(1);
    protected final String GREEN_VALUE = GREEN.substring(1);

    @Test
    void getGreenTest() {
        setInput("5");

        new TrafficLight().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(GREEN_VALUE + "GREEN" + RESET, getOutput());
    }

    @Test
    void getYellowTest() {
        setInput("35");

        new TrafficLight().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(YELLOW_VALUE + "YELLOW" + RESET, getOutput());
    }

    @Test
    void getRedTest() {
        setInput("54");

        new TrafficLight().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(RED_VALUE + "RED" + RESET, getOutput());
    }

    @Test
    void nullInputTest() {
        setInput("0");

        new TrafficLight().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(GREEN_VALUE + "GREEN" + RESET, getOutput());
    }

    @Test
    void tooBigInputTest() {
        setInput("86401");

        new TrafficLight().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void stringInputTest() {
        setInput("string");

        new TrafficLight().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void charInputTest() {
        setInput("c");

        new TrafficLight().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(ERROR_MESSAGE, getOutput());
    }
}
