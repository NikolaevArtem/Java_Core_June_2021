package Homework_2.TrafficLightTest;

import Homework_2.TrafficLight.TrafficLight;
import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficLightTest extends UnitBase {

    @Test
    void Case30_Green() {
        setInput("30");

        new TrafficLight().run();

        printOut();
        removeFromOutput("Please enter the amount of seconds as integer within 0 - 86399 range: ");
        assertEquals("GREEN", getOutput());
    }

    @Test
    void Case36_Yellow() {
        setInput("36");

        new TrafficLight().run();

        printOut();
        removeFromOutput("Please enter the amount of seconds as integer within 0 - 86399 range: ");
        assertEquals("YELLOW", getOutput());
    }

    @Test
    void Case55_Yellow() {
        setInput("55");

        new TrafficLight().run();

        printOut();
        removeFromOutput("Please enter the amount of seconds as integer within 0 - 86399 range: ");
        assertEquals("YELLOW", getOutput());
    }

    @Test
    void Case48_Red() {
        setInput("48");

        new TrafficLight().run();

        printOut();
        removeFromOutput("Please enter the amount of seconds as integer within 0 - 86399 range: ");
        assertEquals("RED", getOutput());
    }

    @Test
    void CaseNegative_Error() {
        setInput("-2");

        new TrafficLight().run();

        printOut();
        removeFromOutput("Please enter the amount of seconds as integer within 0 - 86399 range: ");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutput());
    }

    @Test
    void CaseOutOfRange_Error() {
        setInput("86400");

        new TrafficLight().run();

        printOut();
        removeFromOutput("Please enter the amount of seconds as integer within 0 - 86399 range: ");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutput());
    }

    @Test
    void CaseLong_Error() {
        setInput("2147483648");

        new TrafficLight().run();

        printOut();
        removeFromOutput("Please enter the amount of seconds as integer within 0 - 86399 range: ");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutput());
    }

    @Test
    void CaseSymbol_Error() {
        setInput("test");

        new TrafficLight().run();

        printOut();
        removeFromOutput("Please enter the amount of seconds as integer within 0 - 86399 range: ");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutput());
    }

    @Test
    void CaseTwoInt_Error() {
        setInput("5 65");

        new TrafficLight().run();

        printOut();
        removeFromOutput("Please enter the amount of seconds as integer within 0 - 86399 range: ");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutput());
    }

    @Test
    void CaseDouble_Error() {
        setInput("5.65");

        new TrafficLight().run();

        printOut();
        removeFromOutput("Please enter the amount of seconds as integer within 0 - 86399 range: ");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutput());
    }

}
