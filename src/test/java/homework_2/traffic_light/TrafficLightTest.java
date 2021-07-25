package homework_2.traffic_light;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficLightTest extends UnitBase {

    final String RED_COLOUR = "[31m";
    final String GREEN_COLOUR = "[32m";
    final String YELLOW_COLOUR = "[33m";
    final String RESET_COLOUR = "\u001B[0m";

    @Test
    public void given10Seconds_whenRun_thenPrintTheGreenLight() {
        setInput("10");
        new TrafficLight().run();
        getOutputLines();
        removeFromOutput(TrafficLight.greeting);
        assertEquals(GREEN_COLOUR + "GREEN" + RESET_COLOUR, getOutputLines()[0]);
    }

    @Test
    public void given0Seconds_whenRun_thenPrintTheGreenLight() {
        setInput("0");
        new TrafficLight().run();
        getOutputLines();
        removeFromOutput(TrafficLight.greeting);
        assertEquals(GREEN_COLOUR + "GREEN" + RESET_COLOUR, getOutputLines()[0]);
    }

    @Test
    public void given86305Seconds_whenRun_thenPrintTheGreenLight() {
        setInput("86305");
        new TrafficLight().run();
        getOutputLines();
        removeFromOutput(TrafficLight.greeting);
        assertEquals(GREEN_COLOUR + "GREEN" + RESET_COLOUR, getOutputLines()[0]);
    }


    @Test
    public void given35Seconds_whenRun_thenPrintTheYellowLight() {
        setInput("35");
        new TrafficLight().run();
        getOutputLines();
        removeFromOutput(TrafficLight.greeting);
        assertEquals(YELLOW_COLOUR + "YELLOW" + RESET_COLOUR, getOutputLines()[0]);
    }

    @Test
    public void given55Seconds_whenRun_thenPrintTheYellowLight() {
        setInput("55");
        new TrafficLight().run();
        getOutputLines();
        removeFromOutput(TrafficLight.greeting);
        assertEquals(YELLOW_COLOUR + "YELLOW" + RESET_COLOUR, getOutputLines()[0]);
    }
    @Test
    public void given399Seconds_whenRun_thenPrintTheYellowLight() {
        setInput("399");
        new TrafficLight().run();
        getOutputLines();
        removeFromOutput(TrafficLight.greeting);
        assertEquals(YELLOW_COLOUR + "YELLOW" + RESET_COLOUR, getOutputLines()[0]);
    }

    @Test
    public void given40Seconds_whenRun_thenPrintTheRedLight() {
        setInput("40");
        new TrafficLight().run();
        getOutputLines();
        removeFromOutput(TrafficLight.greeting);
        assertEquals(RED_COLOUR + "RED" + RESET_COLOUR, getOutputLines()[0]);
    }

    @Test
    public void given54Seconds_whenRun_thenPrintTheRedLight() {
        setInput("54");
        new TrafficLight().run();
        getOutputLines();
        removeFromOutput(TrafficLight.greeting);
        assertEquals(RED_COLOUR + "RED" + RESET_COLOUR, getOutputLines()[0]);
    }

    @Test
    public void given3646Seconds_whenRun_thenPrintTheRedLight() {
        setInput("3646");
        new TrafficLight().run();
        getOutputLines();
        removeFromOutput(TrafficLight.greeting);
        assertEquals(RED_COLOUR + "RED" + RESET_COLOUR, getOutputLines()[0]);
    }

    @Test
    public void givenNegativeInteger_whenRun_thenErrorAndStop() {
        setInput("-10");
        new TrafficLight().run();
        getOutputLines();
        removeFromOutput(TrafficLight.greeting);
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    public void givenString_whenRun_thenErrorAndStop() {
        setInput("asdf");
        new TrafficLight().run();
        getOutputLines();
        removeFromOutput(TrafficLight.greeting);
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    public void givenDouble_whenRun_thenErrorAndStop() {
        setInput("1.4");
        new TrafficLight().run();
        getOutputLines();
        removeFromOutput(TrafficLight.greeting);
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    public void givenOutOfRangeInteger_whenRun_thenErrorAndStop() {
        setInput("100000");
        new TrafficLight().run();
        getOutputLines();
        removeFromOutput(TrafficLight.greeting);
        assertEquals("The day is over.", getOutputLines()[0]);
    }
}
