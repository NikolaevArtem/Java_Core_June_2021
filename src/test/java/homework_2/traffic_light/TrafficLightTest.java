package homework_2.traffic_light;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrafficLightTest extends UnitBase {

    void removeOutputDifference(){
        removeFromOutput("Traffic Light App.");
        removeFromOutput("Enter the number of seconds between 0 and 86399 inclusive:");
        removeFromOutput("\u001b[32m");
        removeFromOutput("\u001b[31m");
        removeFromOutput("\u001b[33m");
        removeFromOutput("\u001b[0m");
    }

    @Test
    void givenSeconds0_whenRun_thenReturnGreen() {
        setInput("0");
        new TrafficLight().run();
        printOut();
        removeOutputDifference();
        assertEquals("GREEN", getOutput());
    }

    @Test
    void givenSeconds35_whenRun_thenReturnYellow() {
        setInput("35");
        new TrafficLight().run();
        printOut();
        removeOutputDifference();
        assertEquals("YELLOW", getOutput());
    }

    @Test
    void givenSeconds45_whenRun_thenReturnYellow() {
        setInput("54");
        new TrafficLight().run();
        printOut();
        removeOutputDifference();
        assertEquals("RED", getOutput());
    }

    @Test
    void givenSeconds1204_whenRun_thenReturnGreen() {
        setInput("1204");
        new TrafficLight().run();
        printOut();
        removeOutputDifference();
        assertEquals("GREEN", getOutput());
    }

    @Test
    void givenString_whenRun_thenReturnError() {
        setInput("ThisIsString");
        new TrafficLight().run();
        printOut();
        removeOutputDifference();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter.", getOutput());
    }

    @Test
    void givenOver_whenRun_thenReturnOver() {
        setInput("457891");
        new TrafficLight().run();
        printOut();
        removeOutputDifference();
        assertEquals("The day is over", getOutput());
    }

    @Test
    void givenNegative_whenRun_thenReturnError() {
        setInput("-1");
        new TrafficLight().run();
        printOut();
        removeOutputDifference();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter.", getOutput());
    }

    @Test
    void given2parameters_whenRun_thenReturnError() {
        setInput("567 992");
        new TrafficLight().run();
        printOut();
        removeOutputDifference();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter.", getOutput());
    }

    @Test
    void givenEmpty_whenRun_thenReturnError() {
        setInput("");
        new TrafficLight().run();
        printOut();
        removeOutputDifference();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter.", getOutput());
    }
}