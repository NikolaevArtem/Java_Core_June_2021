package homework_2_test.traffic_light;

import base.UnitBase;
import homework_2.traffic_light.TrafficLight;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TrafficLightTest extends UnitBase {

    private final String errorMsg = "Only 1 non-negative integer is allowed as passed parameter";

    @Test
    void given0_whenRun_thenGreenLight() {
        setInput("0");
        new TrafficLight().run();

        removeFromOutput("Enter time in seconds: ");

        String expected = "[32mGREEN\u001B[0m"; // getOutput() trims the first \u001B if it's at the beginning?
        assertEquals(expected, getOutput());
    }

    @Test
    void given5_whenRun_thenGreenLight() {
        setInput("5");
        new TrafficLight().run();

        removeFromOutput("Enter time in seconds: ");

        String expected = "[32mGREEN\u001B[0m";
        assertEquals(expected, getOutput());
    }

    @Test
    void given35_whenRun_thenYellowLight() {
        setInput("35");
        new TrafficLight().run();

        removeFromOutput("Enter time in seconds: ");

        String expected = "[33mYELLOW\u001B[0m";
        assertEquals(expected, getOutput());
    }

    @Test
    void given54_whenRun_thenRedLight() {
        setInput("54");
        new TrafficLight().run();

        removeFromOutput("Enter time in seconds: ");

        String expected = "[31mRED\u001B[0m";
        assertEquals(expected, getOutput());
    }

    @Test
    void given3345_whenRun_thenRedLight() {
        setInput("3345");
        new TrafficLight().run();

        removeFromOutput("Enter time in seconds: ");

        String expected = "[31mRED\u001B[0m";
        assertEquals(expected, getOutput());
    }

    @Test
    void given54WithExtraSpaces_whenRun_thenRedLight() {
        setInput(" 54 ");
        new TrafficLight().run();

        removeFromOutput("Enter time in seconds: ");

        String expected = "[31mRED\u001B[0m";
        assertEquals(expected, getOutput());
    }

    @Test
    void given86400_whenRun_thenTheDayIsOver() {
        setInput("86400");
        new TrafficLight().run();

        removeFromOutput("Enter time in seconds: ");

        String expected = "The day is over";
        assertEquals(expected, getOutput());
    }

    @Test
    void givenMinus1_whenRun_thenErrorMessage() {
        setInput("-1");
        new TrafficLight().run();

        removeFromOutput("Enter time in seconds: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenFloatingPoint_whenRun_thenErrorMessage() {
        setInput("5.0");
        new TrafficLight().run();

        removeFromOutput("Enter time in seconds: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenTwoInts_whenRun_thenErrorMessage() {
        setInput("5 5");
        new TrafficLight().run();

        removeFromOutput("Enter time in seconds: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenWord_whenRun_thenErrorMessage() {
        setInput("cat");
        new TrafficLight().run();

        removeFromOutput("Enter time in seconds: ");

        assertEquals(errorMsg, getOutput());
    }
}