package homework_2.traffic_light;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import base.UnitBase;

public class TrafficLightTest extends UnitBase {

    final String ERR_MSG = "Only 1 non-negative integer is allowed as passed parameter";
    final String WELCOME_MSG = "Enter the number from 0 to 86399";
    final String RED = "[31mRED\u001B[0m";
    final String GREEN = "[32mGREEN\u001B[0m";
    final String YELLOW = "[33mYELLOW\u001B[0m";

    @Test
    public void givenNull_whenRun_thenPrintErrMsg() {
        setInput("");
        TrafficLight.run();
        printOut();
        removeFromOutput(WELCOME_MSG);
        assertEquals(ERR_MSG, getOutputLines()[0]);
    }

    @Test
    public void givenString_whenRun_thenPrintErrMsg() {
        setInput("someString");
        TrafficLight.run();
        printOut();
        removeFromOutput(WELCOME_MSG);
        assertEquals(ERR_MSG, getOutputLines()[0]);
    }

    @Test
    public void givenDouble_whenRun_thenPrintErrMsg() {
        setInput("2.55");
        TrafficLight.run();
        printOut();
        removeFromOutput(WELCOME_MSG);
        assertEquals(ERR_MSG, getOutputLines()[0]);
    }

    @Test
    public void givenMoreArguments_whenRun_thenPrintErrMsg() {
        setInput("2 5");
        TrafficLight.run();
        printOut();
        removeFromOutput(WELCOME_MSG);
        assertEquals(ERR_MSG, getOutputLines()[0]);
    }

    @Test
    public void given0_whenRun_thenPrintErrMsg() {
        setInput("0");
        TrafficLight.run();
        printOut();
        removeFromOutput(WELCOME_MSG);
        assertEquals(GREEN, getOutputLines()[0]);
    }

    @Test
    public void given65_whenRun_thenPrintErrMsg() {
        setInput("65");
        TrafficLight.run();
        printOut();
        removeFromOutput(WELCOME_MSG);
        assertEquals(GREEN, getOutputLines()[0]);
    }

    @Test
    public void given35_whenRun_thenPrintErrMsg() {
        setInput("35");
        TrafficLight.run();
        printOut();
        removeFromOutput(WELCOME_MSG);
        assertEquals(YELLOW, getOutputLines()[0]);
    }

    @Test
    public void given55_whenRun_thenPrintErrMsg() {
        setInput("55");
        TrafficLight.run();
        printOut();
        removeFromOutput(WELCOME_MSG);
        assertEquals(YELLOW, getOutputLines()[0]);
    }

    @Test
    public void given155_whenRun_thenPrintErrMsg() {
        setInput("155");
        TrafficLight.run();
        printOut();
        removeFromOutput(WELCOME_MSG);
        assertEquals(YELLOW, getOutputLines()[0]);
    }

    @Test
    public void given40_whenRun_thenPrintErrMsg() {
        setInput("40");
        TrafficLight.run();
        printOut();
        removeFromOutput(WELCOME_MSG);
        assertEquals(RED, getOutputLines()[0]);
    }

    @Test
    public void given114_whenRun_thenPrintErrMsg() {
        setInput("114");
        TrafficLight.run();
        printOut();
        removeFromOutput(WELCOME_MSG);
        assertEquals(RED, getOutputLines()[0]);
    }

    @Test
    public void givenTooBig_whenRun_thenPrintErrMsg() {
        setInput("86401");
        TrafficLight.run();
        printOut();
        removeFromOutput(WELCOME_MSG);
        assertEquals("The day is over", getOutputLines()[0]);
    }
}
