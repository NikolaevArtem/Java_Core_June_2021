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
    void givenSeconds0_whenRun_ThenReturnGreen() {
        setInput("0");
        new TrafficLight().run();
        printOut();
        removeOutputDifference();
        assertEquals("GREEN", getOutput());
    }

    @Test
    void givenSeconds35_whenRun_ThenReturnYellow() {
        setInput("35");
        new TrafficLight().run();
        printOut();
        removeOutputDifference();
        assertEquals("YELLOW", getOutput());
    }

    @Test
    void givenSeconds45_whenRun_ThenReturnYellow() {
        setInput("54");
        new TrafficLight().run();
        printOut();
        removeOutputDifference();
        assertEquals("RED", getOutput());
    }

    @Test
    void givenSeconds1204_whenRun_ThenReturnGreen() {
        setInput("1204");
        new TrafficLight().run();
        printOut();
        removeOutputDifference();
        assertEquals("GREEN", getOutput());
    }

    @Test
    void givenString_whenRun_ThenReturnError() {
        setInput("ThisIsString");
        new TrafficLight().run();
        printOut();
        removeOutputDifference();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter.", getOutput());
    }

    @Test
    void givenOver_whenRun_ThenReturnOver() {
        setInput("457891");
        new TrafficLight().run();
        printOut();
        removeOutputDifference();
        assertEquals("The day is over", getOutput());
    }

    @Test
    void givenNegative_whenRun_ThenReturnError() {
        setInput("-1");
        new TrafficLight().run();
        printOut();
        removeOutputDifference();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter.", getOutput());
    }

    @Test
    void given2parameters_whenRun_ThenReturnError() {
        setInput("567 992");
        new TrafficLight().run();
        printOut();
        removeOutputDifference();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter.", getOutput());
    }

    @Test
    void givenEmpty_whenRun_ThenReturnError() {
        setInput("");
        new TrafficLight().run();
        printOut();
        removeOutputDifference();
        assertEquals("Only 1 non-negative integer is allowed as passed parameter.", getOutput());
    }
}