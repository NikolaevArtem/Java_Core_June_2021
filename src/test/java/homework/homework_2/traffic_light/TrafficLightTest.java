package homework.homework_2.traffic_light;

import base.UnitBase;
import homework_2.traffic_light.TrafficLight;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TrafficLightTest extends UnitBase {

    final String ERR_MSG = "Only 1 non-negative integer is allowed as passed parameter";

    //tested cases           negative
    //                       string
    //                       more than 86399
    //                       0
    //                       60
    //                       5
    //                       30
    //                       35
    //                       57
    //                       45
    // 11                    52 seconds


    @Test
    public void givenNegative_whenRun_thenErrOccurs() {
        setInput("-1");

        new TrafficLight().run();
        removeFromOutput("Enter the number, please.");
        printOut();
        assertEquals(ERR_MSG, getOutput());
    }

    @Test
    public void givenString_whenRun_thenErrOccurs() {
        setInput("string");

        new TrafficLight().run();
        removeFromOutput("Enter the number, please.");
        printOut();
        assertEquals(ERR_MSG, getOutput());
    }

    @Test
    public void givenBiggerThen86399_whenRun_thenDayIsOver() {
        setInput("86400");

        new TrafficLight().run();
        removeFromOutput("Enter the number, please.");
        printOut();
        assertEquals("The day is over", getOutput());
    }

    @Test
    public void givenZero_whenRun_thenIsGREEN() {
        setInput("0");

        new TrafficLight().run();
        removeFromOutput("Enter the number, please.");
        printOut();
        assertTrue(getOutput().contains("GREEN"));
    }

    @Test
    public void givenSixty_whenRun_thenIsGREEN() {
        setInput("60");

        new TrafficLight().run();
        removeFromOutput("Enter the number, please.");
        printOut();
        assertTrue(getOutput().contains("GREEN"));
    }

    @Test
    public void givenFive_whenRun_thenIsGREEN() {
        setInput("5");

        new TrafficLight().run();
        removeFromOutput("Enter the number, please.");
        printOut();
        assertTrue(getOutput().contains("GREEN"));
    }

    @Test
    public void givenThirty_whenRun_thenIsGREEN() {
        setInput("30");

        new TrafficLight().run();
        removeFromOutput("Enter the number, please.");
        printOut();
        assertTrue(getOutput().contains("GREEN"));
    }

    @Test
    public void givenThirtyFive_whenRun_thenIsYELLOW() {
        setInput("35");

        new TrafficLight().run();
        removeFromOutput("Enter the number, please.");
        printOut();
        assertTrue(getOutput().contains("YELLOW"));
    }

    @Test
    public void givenFiftySeven_whenRun_thenIsYELLOW() {
        setInput("57");

        new TrafficLight().run();
        removeFromOutput("Enter the number, please.");
        printOut();
        assertTrue(getOutput().contains("YELLOW"));
    }

    @Test
    public void givenFoutryFive_whenRun_thenIsRED() {
        setInput("45");

        new TrafficLight().run();
        removeFromOutput("Enter the number, please.");
        printOut();
        assertTrue(getOutput().contains("RED"));
    }

    @Test
    public void givenFiftyTwo_whenRun_thenIsRED() {
        setInput("52");

        new TrafficLight().run();
        removeFromOutput("Enter the number, please.");
        printOut();
        assertTrue(getOutput().contains("RED"));
    }


}