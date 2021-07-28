package homework_2;

import homework_2.traffic_light.TrafficLight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrafficLightTest extends base.UnitBase {

    protected final String START_MESSAGE = "Please, input time:";
    private final String ERROR_MESSAGE = "Only 1 non-negative integer is allowed as passed parameter";

    @Test
    void getGreenTest() {
        setInput("5");

        new TrafficLight().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertTrue(getOutput().contains("GREEN"));
    }

    @Test
    void getYellowTest() {
        setInput("35");

        new TrafficLight().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertTrue(getOutput().contains("YELLOW"));
    }

    @Test
    void getRedTest() {
        setInput("54");

        new TrafficLight().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertTrue(getOutput().contains("RED"));
    }

    @Test
    void nullInputTest() {
        setInput("0");

        new TrafficLight().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertTrue(getOutput().contains("GREEN"));
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
