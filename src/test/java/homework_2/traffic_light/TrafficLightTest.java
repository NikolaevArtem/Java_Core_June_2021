package homework_2.traffic_light;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class TrafficLightTest extends UnitBase {

    @Test
    void given_minSeconds_whenRun_then_printColor() {
        setInput("0");

        new TrafficLight().run();

        assertTrue(getOutput().contains("GREEN"));
    }

    @Test
    void given_maxSeconds_whenRun_then_printColor() {
        setInput("86399");

        new TrafficLight().run();

        assertTrue(getOutput().contains("YELLOW"));
    }

    @Test
    void given_5_whenRun_then_printColor() {
        setInput("5");

        new TrafficLight().run();

        assertTrue(getOutput().contains("GREEN"));
    }

    @Test
    void given_35_whenRun_then_printColor() {
        setInput("35");

        new TrafficLight().run();

        assertTrue(getOutput().contains("YELLOW"));
    }

    @Test
    void given_54_whenRun_then_printColor() {
        setInput("54");

        new TrafficLight().run();

        assertTrue(getOutput().contains("RED"));
    }


    @Test
    void given_86401_whenRun_then_printErrorMessage() {
        setInput("86401");

        new TrafficLight().run();

        assertTrue(getOutput().contains("The day is over!"));
    }

    @Test
    void given_negativeInteger_whenRun_then_printErrorMessage() {
        setInput("-1");

        new TrafficLight().run();

        assertTrue(getOutput().contains("Only 1 non-negative integer is allowed as passed parameter"));
    }



    @Test
    void given_string_whenRun_then_printErrorMessage() {
        setInput("abc");

        new TrafficLight().run();

        assertTrue(getOutput().contains("Only 1 non-negative integer is allowed as passed parameter"));
    }

    @Test
    void given_severalArguments_whenRun_then_printErrorMessage() {
        setInput("2 2");

        new TrafficLight().run();

        assertTrue(getOutput().contains("Only 1 non-negative integer is allowed as passed parameter"));
    }

}