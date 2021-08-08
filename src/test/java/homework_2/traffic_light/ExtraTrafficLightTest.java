package homework_2.traffic_light;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static homework_2.traffic_light.ColorSelector.*;
import static org.junit.jupiter.api.Assertions.*;

class ExtraTrafficLightTest extends UnitBase {
    private void run() {
        new ExtraTrafficLight().run();
        removeFromOutput("Provide time in \"hh:mm:ss\" format: ");
        printOut();
    }

    @Test
    void givenValidArguments_whenRun_thenYellowOutput() {
        setInput("23:59:59");

        run();

        assertEquals("The traffic light is" + ANSI_YELLOW + " Yellow" + ANSI_RESET + " now", getOutput());
    }

    @Test
    void givenOneWrongArgument_whenRun_thenInputError() {
        setInput("25:45:45");

        run();

        assertEquals("You entered an invalid date.", getOutput());
    }

    @Test
    void givenTwoWrongArguments_whenRun_thenInputError() {
        setInput("25:65:45");

        run();

        assertEquals("You entered an invalid date.", getOutput());
    }

    @Test
    void givenThreeWrongArguments_whenRun_thenInputError() {
        setInput("25:65:67");

        run();

        assertEquals("You entered an invalid date.", getOutput());
    }

    @Test
    void givenAdditionalField_whenRun_thenInputError() {
        setInput("25:65:67:67");

        run();

        assertEquals("You entered an invalid date.", getOutput());
    }

    @Test
    void givenNaN_whenRun_thenNumberFormatError() {
        setInput("error");

        run();

        assertEquals("Only numbers is allow.", getOutput());
    }

    @Test
    void givenZero_whenRun_thenInputError() {
        setInput("0");

        run();

        assertEquals("Incorrect input.", getOutput());
    }

    @Test
    void givenNegativeArgument_whenRun_thenInputError() {
        setInput("-5:23:45");

        run();

        assertEquals("You entered an invalid date.", getOutput());
    }

    @Test
    void givenOutOfBoundsArguments_whenRun_thenInputError() {
        setInput("5 5 5 5 5");

        run();

        assertEquals("Incorrect input.", getOutput());
    }
}