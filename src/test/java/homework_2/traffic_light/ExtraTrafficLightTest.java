package homework_2.traffic_light;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtraTrafficLightTest extends UnitBase {

    @Test
    void given_minSeconds_whenRun_then_printColor() {
        setInput("0");

        new ExtraTrafficLight().run(1);

        assertTrue(getOutput().contains("GREEN"));
    }

    @Test
    void given_maxSeconds_whenRun_then_printColor() {
        setInput("86399");

        new ExtraTrafficLight().run(1);

        assertTrue(getOutput().contains("YELLOW"));
    }

    @Test
    void given_5_whenRun_then_printColor() {
        setInput("5");

        new ExtraTrafficLight().run(1);

        assertTrue(getOutput().contains("GREEN"));
    }

    @Test
    void given_35_whenRun_then_printColor() {
        setInput("35");

        new ExtraTrafficLight().run(1);

        assertTrue(getOutput().contains("YELLOW"));
    }

    @Test
    void given_54_whenRun_then_printColor() {
        setInput("54");

        new ExtraTrafficLight().run(1);

        assertTrue(getOutput().contains("RED"));
    }


    @Test
    void given_86401_whenRun_then_printErrorMessage() {
        setInput("86401");

        new ExtraTrafficLight().run(1);

        assertTrue(getOutput().contains("The day is over!"));
    }

    @Test
    void given_negativeInteger_whenRun_then_printErrorMessage() {
        setInput("-1");

        new ExtraTrafficLight().run(1);

        assertTrue(getOutput().contains("Only non-negative integers is allowed as passed parameter"));
    }

    @Test
    void given_string_whenRun_then_printErrorMessage() {
        setInput("abc");

        new ExtraTrafficLight().run(1);

        assertTrue(getOutput().contains("Only non-negative integers is allowed as passed parameter"));
    }

    @Test
    void given_minTime_whenRun_then_printColor() {
        setInput("00:00:00");

        new ExtraTrafficLight().run(2);

        assertTrue(getOutput().contains("GREEN"));
    }

    @Test
    void given_maxTime_whenRun_then_printColor() {
        setInput("23:59:59");

        new ExtraTrafficLight().run(2);

        assertTrue(getOutput().contains("YELLOW"));
    }

    @Test
    void given_timeOutOfRange_whenRun_then_printErrorMessage() {
        setInput("24:00:00");

        new ExtraTrafficLight().run(2);

        assertTrue(getOutput().contains("Entered time doesn't match the format!"));
    }

    @Test
    void given_negativeTime_whenRun_then_printErrorMessage() {
        setInput("-23:00:00");

        new ExtraTrafficLight().run(2);

        assertTrue(getOutput().contains("Entered time doesn't match the format!"));
    }
    @Test
    void given_timeWithStringArgument_whenRun_then_printErrorMessage() {
        setInput("23:00:b");

        new ExtraTrafficLight().run(2);

        assertTrue(getOutput().contains("Only non-negative integers is allowed as passed parameter"));
    }
}