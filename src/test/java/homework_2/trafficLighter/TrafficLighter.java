package homework_2.trafficLighter;

import base.UnitBase;
import homework_2.traffic_light.Traffic_light;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrafficLighter extends UnitBase {

    @Test
    public void testInput61ToSeeGreen() throws IOException {
        setInput("61");

        Traffic_light traffic_light = new Traffic_light();
        traffic_light.run();
        printOut();
        removeFromOutput("Please input number");

        assertTrue(getOutputLines()[0].contains("Green"));
    }

    @Test
    public void testInput86400() throws IOException {
        setInput("86400");

        Traffic_light traffic_light = new Traffic_light();
        traffic_light.run();
        printOut();
        removeFromOutput("Please input number");

        assertEquals("it's a new day...", getOutputLines()[0]);
    }

    @Test
    public void testInputZero() throws IOException {
        setInput("0");

        Traffic_light traffic_light = new Traffic_light();
        traffic_light.run();
        printOut();
        removeFromOutput("Please input number");

        assertTrue(getOutputLines()[0].contains("Green"));
    }

    @Test
    public void testInputNegativeValue() throws IOException {
        setInput("-2");

        Traffic_light traffic_light = new Traffic_light();
        traffic_light.run();
        printOut();
        removeFromOutput("Please input number");

        assertEquals("Error, negative numbers are not valid", getOutputLines()[0]);
    }

    @Test
    public void testInput45() throws IOException {
        setInput("45");

        Traffic_light traffic_light = new Traffic_light();
        traffic_light.run();
        printOut();
        removeFromOutput("Please input number");

        assertTrue(getOutputLines()[0].contains("Red"));
    }

    @Test
    public void testInput39() throws IOException {
        setInput("39");

        Traffic_light traffic_light = new Traffic_light();
        traffic_light.run();
        printOut();
        removeFromOutput("Please input number");

        assertTrue(getOutputLines()[0].contains("Yellow"));
    }

    @Test
    public void testInputText() throws IOException {
        setInput("text");

        Traffic_light traffic_light = new Traffic_light();
        traffic_light.run();
        printOut();
        removeFromOutput("Please input number");

        assertEquals("Invalid data format, please enter integer", getOutputLines()[0]);
    }

}
