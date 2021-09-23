package homework_2_tests;

import homework_2.traffic_light.TrafficLight;
import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficLightTest extends UnitBase{

    private final String errorMassage = "Only 1 non-negative integer is allowed as passed parameter";

    private void run(){
        new TrafficLight().run();
        removeFromOutput("Please enter time in seconds:");
        printOut();
    }

    @Test
    void given0_whenRun_thenGreen() {
        setInput("0");

        run();

        assertEquals("[32mGREEN\u001B[0m", getOutput());
    }

    @Test
    void given34_whenRun_thenGreen() {
        setInput("34");

        run();

        assertEquals("[32mGREEN\u001B[0m", getOutput());
    }

    @Test
    void given35_whenRun_thenYellow() {
        setInput("35");

        run();

        assertEquals("[33mYELLOW\u001B[0m", getOutput());
    }

    @Test
    void given54_whenRun_thenRed() {
        setInput("54");

        run();

        assertEquals("[31mRED\u001B[0m", getOutput());
    }

    @Test
    void given86401_whenRun_thenTheDayIsOver() {
        setInput("86401");

        run();

        assertEquals("The day is over", getOutput());
    }

    @Test
    void givenLetter_whenRun_thenErrorMassage() {
        setInput("A");

        run();

        assertEquals(errorMassage, getOutput());
    }

    @Test
    void givenWord_whenRun_thenErrorMassage() {
        setInput("one");

        run();

        assertEquals(errorMassage, getOutput());
    }

    @Test
    void givenTwoDigits_whenRun_thenErrorMassage() {
        setInput("8 9");

        run();

        assertEquals(errorMassage, getOutput());
    }

    @Test
    void givenDouble_whenRun_thenErrorMassage() {
        setInput("5.0");

        run();

        assertEquals(errorMassage, getOutput());
    }
}
