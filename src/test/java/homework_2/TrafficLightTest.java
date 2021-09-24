package homework_2;

import base.UnitBase;
import homework_2.traffic_light.TrafficLight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficLightTest extends UnitBase {

    @Test
    public void trafficTestOnGreenColor() {
        setInput("3");
        new TrafficLight().run();
        printOut();
        assertEquals("GREEN", getOutputLines()[0]);
    }

    @Test
    public void trafficTestOnYellowColor() {
        setInput("36");
        new TrafficLight().run();
        printOut();
        assertEquals("YELLOW", getOutputLines()[0]);
    }

    @Test
    public void trafficTestOnRedColor() {
        setInput("43");
        new TrafficLight().run();
        printOut();
        assertEquals("RED", getOutputLines()[0]);
    }

    @Test
    public void trafficTestOnString() {
        setInput("Str");
        new TrafficLight().run();
        printOut();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }
    @Test
    public void trafficTestOnNegativeNumber() {
        setInput("-5");
        new TrafficLight().run();
        printOut();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }
    @Test
    public void trafficTestOnBigNumber() {
        setInput("86999");
        new TrafficLight().run();
        printOut();
        assertEquals("The day is over", getOutputLines()[0]);
    }
    @Test
    public void trafficTestOnDouble() {
        setInput("3.0");
        new TrafficLight().run();
        printOut();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }
}
