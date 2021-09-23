package homework_2;

import base.UnitBase;
import homework_2.traffic_light.TrafficLight;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrafficLightTest extends UnitBase {

    private static final String ERROR = "Only 1 non-negative integer is allowed as passed parameter";

    @Test
    void given2_whenRun_thenGreen() {
        setInput("2");
        runPrintRemoveFromOutput();
        assertTrue(getOutput().contains("GREEN"));
    }

    @Test
    void given95_whenRun_thenYellow() {
        setInput("95");
        runPrintRemoveFromOutput();
        assertTrue(getOutput().contains("YELLOW"));
    }

    @Test
    void given100_whenRun_thenRed() {
        setInput("160");
        runPrintRemoveFromOutput();
        assertTrue(getOutput().contains("RED"));
    }

    @Test
    void givenBigNumber_whenRun_thenDayIsOver() {
        setInput("86400");
        runPrintRemoveFromOutput();
        assertEquals("The day is over", getOutput());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 2", "-1", "abc"})
    void givenERROR_whenRun_thenERROR(String input) {
        setInput(input);
        runPrintRemoveFromOutput();
        assertEquals(ERROR, getOutput());
    }

    private void runPrintRemoveFromOutput() {
        new TrafficLight().run();
        printOut();
        removeFromOutput("Please, input a number of seconds:");
    }
}
