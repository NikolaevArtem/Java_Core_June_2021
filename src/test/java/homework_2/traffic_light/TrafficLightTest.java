package homework_2.traffic_light;

import base.UnitBase;
import homework_2.pyramid_printer.PyramidPrinter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrafficLightTest extends UnitBase {
    @Test
    void EmptyInputTest() {
        setInput("");

        new TrafficLight().run();
        removeFromOutput("Please type your current time in seconds:");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter",
                getOutputLines()[0]);
    }

    @Test
    void NullGreenColorInputTest() {
        setInput("0");

        new TrafficLight().run();
        removeFromOutput("Please type your current time in seconds:");
        assertEquals("[32mGREEN\u001B[0m",
                getOutputLines()[0]);
    }

    @Test
    void GreenColorInputTest() {
        setInput("5");

        new TrafficLight().run();
        removeFromOutput("Please type your current time in seconds:");
        assertEquals("[32mGREEN\u001B[0m",
                getOutputLines()[0]);
    }

    @Test
    void YellowColorInputTest() {
        setInput("35");

        new TrafficLight().run();
        removeFromOutput("Please type your current time in seconds:");
        assertEquals("[33mYELLOW\u001B[0m",
                getOutputLines()[0]);
    }

    @Test
    void RedColorInputTest() {
        setInput("54");

        new TrafficLight().run();
        removeFromOutput("Please type your current time in seconds:");
        assertEquals("[31mRED\u001B[0m",
                getOutputLines()[0]);
    }

    @Test
    void DayIsOverInputTest() {
        setInput("86400");

        new TrafficLight().run();
        removeFromOutput("Please type your current time in seconds:");
        assertEquals("The day is over",
                getOutputLines()[0]);
    }

    @Test
    void NegativeInputTest() {
        setInput("-55");

        new TrafficLight().run();
        removeFromOutput("Please type your current time in seconds:");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter",
                getOutputLines()[0]);
    }

    @Test
    void StringInputTest() {
        setInput("hello");

        new TrafficLight().run();
        removeFromOutput("Please type your current time in seconds:");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter",
                getOutputLines()[0]);
    }

    @Test
    void DoubleInputTest() {
        setInput("0.5");

        new TrafficLight().run();
        removeFromOutput("Please type your current time in seconds:");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter",
                getOutputLines()[0]);
    }

    @Test
    void LongInputTest() {
        setInput("999999999999999");

        new TrafficLight().run();
        removeFromOutput("Please type your current time in seconds:");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter",
                getOutputLines()[0]);
    }
}
