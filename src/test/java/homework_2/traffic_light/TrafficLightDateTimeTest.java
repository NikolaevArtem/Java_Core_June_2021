package homework_2.traffic_light;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static homework_2.traffic_light.ColorSelector.ANSI_RESET;
import static homework_2.traffic_light.ColorSelector.ANSI_YELLOW;
import static org.junit.jupiter.api.Assertions.*;

class TrafficLightDateTimeTest extends UnitBase {
    final static TrafficLightDateTime trafficLightDateTime = new TrafficLightDateTime();

    private void run() {
        trafficLightDateTime.dateTime();
        removeFromOutput("Provide time in \"hh:mm:ss\" format: ");
        printOut();
    }

    @Test
    void runGood() {
        setInput("23:59:59");

        run();

        assertEquals("The traffic light is" + ANSI_YELLOW + " Yellow" + ANSI_RESET + " now", getOutput());
    }

    @Test
    void runWithOneInputMissmatch() {
        setInput("25:45:45");

        run();

        assertEquals("You entered an invalid date.", getOutput());
    }

    @Test
    void runWithTwoInputMissmatch() {
        setInput("25:65:45");

        run();

        assertEquals("You entered an invalid date.", getOutput());
    }

    @Test
    void runWithThreeInputMissmatch() {
        setInput("25:65:67");

        run();

        assertEquals("You entered an invalid date.", getOutput());
    }

    @Test
    void runWithExtraField() {
        setInput("25:65:67:67");

        run();

        assertEquals("You entered an invalid date.", getOutput());
    }

    @Test
    void runWithNumberFormatException() {
        setInput("error");

        run();

        assertEquals("Only numbers is allow.", getOutput());
    }

    @Test
    void runWithZero() {
        setInput("0");

        run();

        assertEquals("Incorrect input.", getOutput());
    }

    @Test
    void runWithNegative() {
        setInput("-5:23:45");

        run();

        assertEquals("You entered an invalid date.", getOutput());
    }

    @Test
    void runWithOutOfBounds() {
        setInput("5 5 5 5 5");

        run();

        assertEquals("Incorrect input.", getOutput());
    }
}