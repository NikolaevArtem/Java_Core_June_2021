package homework_2;

import base.UnitBase;
import homework_2.traffic_light.TrafficLight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficLightTest extends UnitBase {
    private final String ERROR_MSG_DAY_IS_OVER = "The day is over";
    private final String ERROR_MSG = "Only 1 non-negative integer is allowed as passed parameter";
    private final int MAX_VALUE_OF_SECS = 86399;

    @Test
    void givenInteger0_whenRunTrafficLight_thenPrintingGreen() {
        setInput("0");

        new TrafficLight().run();
        printOut();

        assertEquals("GREEN", getOutputLines()[0]);
    }

    @Test
    void givenInteger25_whenRunTrafficLight_thenPrintingGreen() {
        setInput("25");

        new TrafficLight().run();
        printOut();

        assertEquals("GREEN", getOutputLines()[0]);
    }

    @Test
    void givenInteger35_whenRunTrafficLight_thenPrintingYellow() {
        setInput("35");

        new TrafficLight().run();
        printOut();

        assertEquals("YELLOW", getOutputLines()[0]);
    }

    @Test
    void givenInteger37_whenRunTrafficLight_thenPrintingYellow() {
        setInput("37");

        new TrafficLight().run();
        printOut();

        assertEquals("YELLOW", getOutputLines()[0]);
    }

    @Test
    void givenInteger40_whenRunTrafficLight_thenPrintingRed() {
        setInput("40");

        new TrafficLight().run();
        printOut();

        assertEquals("RED", getOutputLines()[0]);
    }

    @Test
    void givenInteger50_whenRunTrafficLight_thenPrintingRed() {
        setInput("50");

        new TrafficLight().run();
        printOut();

        assertEquals("RED", getOutputLines()[0]);
    }

    @Test
    void givenInteger55_whenRunTrafficLight_thenPrintingYellow() {
        setInput("55");

        new TrafficLight().run();
        printOut();

        assertEquals("YELLOW", getOutputLines()[0]);
    }

    @Test
    void givenInteger59_whenRunTrafficLight_thenPrintingYellow() {
        setInput("59");

        new TrafficLight().run();
        printOut();

        assertEquals("YELLOW", getOutputLines()[0]);
    }

    @Test
    void givenInteger60_whenRunTrafficLight_thenPrintingGreen() {
        setInput("60");

        new TrafficLight().run();
        printOut();

        assertEquals("GREEN", getOutputLines()[0]);
    }

    @Test
    void givenMaxSecsInteger_whenRunTrafficLight_thenPrintingYellow() {
        setInput(String.valueOf(MAX_VALUE_OF_SECS));

        new TrafficLight().run();
        printOut();

        assertEquals("YELLOW", getOutputLines()[0]);
    }

    @Test
    void givenNextToMaxSecsInteger_whenRunTrafficLight_thenPrintingErrorMsg() {
        setInput(String.valueOf(MAX_VALUE_OF_SECS + 1));

        new TrafficLight().run();
        printOut();

        assertEquals(ERROR_MSG_DAY_IS_OVER, getOutputLines()[0]);
    }

    @Test
    void givenNegativeInteger_whenRunTrafficLight_thenPrintingErrorMsg() {
        setInput("-1");

        new TrafficLight().run();
        printOut();

        assertEquals(ERROR_MSG, getOutputLines()[0]);
    }

    @Test
    void givenStringHi_whenRunTrafficLight_thenPrintingErrorMsg() {
        setInput("Hi");

        new TrafficLight().run();
        printOut();

        assertEquals(ERROR_MSG, getOutputLines()[0]);
    }

    @Test
    void givenEmptyString_whenRunTrafficLight_thenPrintingErrorMsg() {
        setInput("");

        new TrafficLight().run();
        printOut();

        assertEquals(ERROR_MSG, getOutputLines()[0]);
    }
}
