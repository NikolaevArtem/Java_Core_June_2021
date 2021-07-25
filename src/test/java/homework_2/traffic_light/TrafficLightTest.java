package homework_2.traffic_light;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static homework_2.traffic_light.ColorSelector.*;
import static org.junit.jupiter.api.Assertions.*;

class TrafficLightTest extends UnitBase {
    private void run() {
        new TrafficLight().run();
        removeFromOutput("Provide time in seconds:");
        printOut();
    }

    @Test
    void runGood55() {
        setInput("55");

        run();

        assertEquals("The traffic light is" + ANSI_YELLOW + " Yellow" + ANSI_RESET + " now", getOutput());
    }

    @Test
    void runGood7506() {
        setInput("7506");

        run();

        assertEquals("The traffic light is" + ANSI_GREEN + " Green" + ANSI_RESET + " now", getOutput());
    }

    @Test
    void runWithNegative() {
        setInput("-5");

        run();

        assertEquals("Only non-negative numbers is allow.", getOutput());
    }

    @Test
    void runWithInputMismatch() {
        setInput("error");

        run();

        assertEquals("Only numbers is allow.", getOutput());
    }

    @Test
    void runWithOverload() {
        setInput("86401");

        run();

        assertEquals("Day is over.", getOutput());
    }
}