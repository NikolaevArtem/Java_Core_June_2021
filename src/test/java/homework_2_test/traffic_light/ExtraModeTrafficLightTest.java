package homework_2_test.traffic_light;

import base.UnitBase;
import homework_2.traffic_light.ExtraModeTrafficLight;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ExtraModeTrafficLightTest extends UnitBase {

    private final String errorMsg = "Not a valid hh:mm:ss format";

    @Test
    void given0_whenRun_thenGreenLight() {
        setInput("00:00:00");
        new ExtraModeTrafficLight().run();

        removeFromOutput("Enter time of the day in hh:mm:ss(hh:mm) format: ");

        String expected = "[32mGREEN\u001B[0m"; // getOutput() trims the first \u001B if it's at the beginning?
        assertEquals(expected, getOutput());
    }

    @Test
    void given5_whenRun_thenGreenLight() {
        setInput("00:00:05");
        new ExtraModeTrafficLight().run();

        removeFromOutput("Enter time of the day in hh:mm:ss(hh:mm) format: ");

        String expected = "[32mGREEN\u001B[0m";
        assertEquals(expected, getOutput());
    }

    @Test
    void given35_whenRun_thenYellowLight() {
        setInput("00:00:35");
        new ExtraModeTrafficLight().run();

        removeFromOutput("Enter time of the day in hh:mm:ss(hh:mm) format: ");

        String expected = "[33mYELLOW\u001B[0m";
        assertEquals(expected, getOutput());
    }

    @Test
    void given54_whenRun_thenRedLight() {
        setInput("00:00:54");
        new ExtraModeTrafficLight().run();

        removeFromOutput("Enter time of the day in hh:mm:ss(hh:mm) format: ");

        String expected = "[31mRED\u001B[0m";
        assertEquals(expected, getOutput());
    }

    @Test
    void given121255_whenRun_thenYellowLight() {
        setInput("12:12:55");
        new ExtraModeTrafficLight().run();

        removeFromOutput("Enter time of the day in hh:mm:ss(hh:mm) format: ");

        String expected = "[33mYELLOW\u001B[0m";
        assertEquals(expected, getOutput());
    }

    @Test
    void given5WithExtraSpaces_whenRun_thenGreenLight() {
        setInput(" 00:00:05 ");
        new ExtraModeTrafficLight().run();

        removeFromOutput("Enter time of the day in hh:mm:ss(hh:mm) format: ");

        String expected = "[32mGREEN\u001B[0m";
        assertEquals(expected, getOutput());
    }

    @Test
    void givenSecondsFieldOmitted_whenRun_thenGreenLight() {
        setInput("12:55");
        new ExtraModeTrafficLight().run();

        removeFromOutput("Enter time of the day in hh:mm:ss(hh:mm) format: ");

        String expected = "[32mGREEN\u001B[0m";
        assertEquals(expected, getOutput());
    }

    @Test
    void givenBiggerThenDay_whenRun_thenErrorMessage() {
        setInput("24:00:00");
        new ExtraModeTrafficLight().run();

        removeFromOutput("Enter time of the day in hh:mm:ss(hh:mm) format: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenMinusOneDigitHours_whenRun_thenErrorMessage() {
        setInput("0:00:00");
        new ExtraModeTrafficLight().run();

        removeFromOutput("Enter time of the day in hh:mm:ss(hh:mm) format: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenOneDigitMinutes_whenRun_thenErrorMessage() {
        setInput("00:0:00");
        new ExtraModeTrafficLight().run();

        removeFromOutput("Enter time of the day in hh:mm:ss(hh:mm) format: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenOneDigitSeconds_whenRun_thenErrorMessage() {
        setInput("00:00:0");
        new ExtraModeTrafficLight().run();

        removeFromOutput("Enter time of the day in hh:mm:ss(hh:mm) format: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenNegativeFormat_whenRun_thenErrorMessage() {
        setInput("-00:00:00");
        new ExtraModeTrafficLight().run();

        removeFromOutput("Enter time of the day in hh:mm:ss(hh:mm) format: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenColonOmitted_whenRun_thenErrorMessage() {
        setInput("000000");
        new ExtraModeTrafficLight().run();

        removeFromOutput("Enter time of the day in hh:mm:ss(hh:mm) format: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenColonReplacedWithSpaces_whenRun_thenErrorMessage() {
        setInput("00 00 00");
        new ExtraModeTrafficLight().run();

        removeFromOutput("Enter time of the day in hh:mm:ss(hh:mm) format: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenTwoTimeFieldsOmitted_whenRun_thenErrorMessage() {
        setInput("00");
        new ExtraModeTrafficLight().run();

        removeFromOutput("Enter time of the day in hh:mm:ss(hh:mm) format: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenWord_whenRun_thenErrorMessage() {
        setInput("cat");
        new ExtraModeTrafficLight().run();

        removeFromOutput("Enter time of the day in hh:mm:ss(hh:mm) format: ");

        assertEquals(errorMsg, getOutput());
    }
}