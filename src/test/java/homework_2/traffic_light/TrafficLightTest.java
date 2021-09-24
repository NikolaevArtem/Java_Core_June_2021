package homework_2.traffic_light;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrafficLightTest extends UnitBase {

    @Test
    void givenMinValue_whenRun_thenPrintColor() {
        setInput("0");
        new TrafficLight().run();
        assertTrue(getOutput().contains("GREEN"));
    }

    @Test
    void givenNumberFrom0InclusiveTo35NotInclusive_whenRun_thenPrintColor() {
        setInput("34");
        new TrafficLight().run();
        assertTrue(getOutput().contains("GREEN"));
    }


    @Test
    void givenNumberFrom35InclusiveTo40NotInclusive_whenRun_thenPrintColor() {
        setInput("39");
        new TrafficLight().run();
        assertTrue(getOutput().contains("YELLOW"));
    }

    @Test
    void givenNumberFrom40InclusiveTo55NotInclusive_whenRun_thenPrintColor() {
        setInput("54");
        new TrafficLight().run();
        assertTrue(getOutput().contains("RED"));
    }

    @Test
    void givenNumberFrom55InclusiveTo60NotInclusive_whenRun_thenPrintColor() {
        setInput("59");
        new TrafficLight().run();
        assertTrue(getOutput().contains("YELLOW"));
    }

    @Test
    void givenMaxValue86399_whenRun_thenPrintColor() {
        setInput("86399");
        new TrafficLight().run();
        assertTrue(getOutput().contains("YELLOW"));
    }

    @Test
    void givenNumberBiggerThanItIsAllowed_whenRun_then_printErrorMessage() {
        setInput("86400");
        new TrafficLight().run();
        assertTrue(getOutput().contains("The day is over"));
    }

    @Test
    void givenNegativeInteger_whenRun_thenPrintErrorMessage() {
        setInput("-1");
        new TrafficLight().run();
        assertTrue(getOutput().contains("Only 1 non-negative integer is allowed as passed parameter"));
    }

    @Test
    void givenString_whenRun_thenPrintErrorMessage() {
        setInput("abc");
        new TrafficLight().run();
        assertTrue(getOutput().contains("Only 1 non-negative integer is allowed as passed parameter"));
    }

    @Test
    void givenSeveralArguments_whenRun_thenPrintErrorMessage() {
        setInput("2 2");
        new TrafficLight().run();
        assertTrue(getOutput().contains("Only 1 non-negative integer is allowed as passed parameter"));
    }
}