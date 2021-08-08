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
    void given55_whenRun_thenYellowOutput() {
        setInput("55");

        run();

        assertEquals("The traffic light is" + ANSI_YELLOW + " Yellow" + ANSI_RESET + " now", getOutput());
    }

    @Test
    void given7506_whenRun_thenGreenOutput() {
        setInput("7506");

        run();

        assertEquals("The traffic light is" + ANSI_GREEN + " Green" + ANSI_RESET + " now", getOutput());
    }

    @Test
    void givenNegative_whenRun_thenInputError() {
        setInput("-5");

        run();

        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutput());
    }

    @Test
    void givenNan_whenRun_thenInputError() {
        setInput("error");

        run();

        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutput());
    }

    @Test
    void givenMoreThanDay_whenRun_thenDayOverError() {
        setInput("86401");

        run();

        assertEquals("Day is over.", getOutput());
    }
}