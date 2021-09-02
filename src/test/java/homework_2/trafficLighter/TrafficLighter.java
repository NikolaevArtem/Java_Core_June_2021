package homework_2.trafficLighter;

import base.UnitBase;
import homework_2.traffic_light.TrafficLight;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrafficLighter extends UnitBase {

    @Test
    public void testInput61ToSeeGreen() throws IOException {
        setInput("61");

        TrafficLight traffic_light = new TrafficLight ();
        traffic_light.run();
        printOut();
        removeFromOutput("Please input number");

        assertTrue(getOutputLines()[0].contains("Green"));
    }

    @Test
    public void testInput86400() throws IOException {
        setInput("86400");

        TrafficLight traffic_light = new TrafficLight ();
        traffic_light.run();
        printOut();
        removeFromOutput("Please input number");

        assertEquals("it's a new day...", getOutputLines()[0]);
    }

    @Test
    public void testInputZero() throws IOException {
        setInput("0");

        TrafficLight traffic_light = new TrafficLight ();
        traffic_light.run();
        printOut();
        removeFromOutput("Please input number");

        assertTrue(getOutputLines()[0].contains("Green"));
    }

    @Test
    public void testInputNegativeValue() throws IOException {
        setInput("-2");

        TrafficLight traffic_light = new TrafficLight ();
        traffic_light.run();
        printOut();
        removeFromOutput("Please input number");

        assertEquals("Error, negative numbers are not valid", getOutputLines()[0]);
    }

    @Test
    public void testInput45() throws IOException {
        setInput("45");

        TrafficLight traffic_light = new TrafficLight ();
        traffic_light.run();
        printOut();
        removeFromOutput("Please input number");

        assertTrue(getOutputLines()[0].contains("Red"));
    }

    @Test
    public void testInput39() throws IOException {
        setInput("39");

        TrafficLight traffic_light = new TrafficLight ();
        traffic_light.run();
        printOut();
        removeFromOutput("Please input number");

        assertTrue(getOutputLines()[0].contains("Yellow"));
    }

    @Test
    public void testInput55() throws IOException {
        setInput("55");

        TrafficLight traffic_light = new TrafficLight ();
        traffic_light.run();
        printOut();
        removeFromOutput("Please input number");

        assertTrue(getOutputLines()[0].contains("Yellow"));
    }

    @Test
    public void testInputText() throws IOException {
        setInput("text");

        TrafficLight traffic_light = new TrafficLight ();
        traffic_light.run();
        printOut();
        removeFromOutput("Please input number");

        assertEquals("Invalid data format, please enter integer", getOutputLines()[0]);
    }

}
