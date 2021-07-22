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
        assertEquals("green", getOutputLines()[0]);
    }

    @Test
    public void trafficTestOnYellowColor() {
        setInput("36");
        new TrafficLight().run();
        printOut();
        assertEquals("yellow", getOutputLines()[0]);
    }

    @Test
    public void trafficTestOnRedColor() {
        setInput("43");
        new TrafficLight().run();
        printOut();
        assertEquals("red", getOutputLines()[0]);
    }

    @Test
    public void trafficTestOnString() {
        setInput("Str");
        new TrafficLight().run();
        printOut();
        assertEquals("Please use number", getOutputLines()[0]);
    }
    @Test
    public void trafficTestOnNegativeNumber() {
        setInput("-5");
        new TrafficLight().run();
        printOut();
        assertEquals("Please use positive number", getOutputLines()[0]);
    }
    @Test
    public void trafficTestOnBigNumber() {
        setInput("86999");
        new TrafficLight().run();
        printOut();
        assertEquals("Please use number between 0 and 86399", getOutputLines()[0]);
    }
    @Test
    public void trafficTestOnDouble() {
        setInput("3.0");
        new TrafficLight().run();
        printOut();
        assertEquals("Please use number", getOutputLines()[0]);
    }
}
