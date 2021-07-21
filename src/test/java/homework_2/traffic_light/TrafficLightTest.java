package homework_2.traffic_light;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TrafficLightTest extends UnitBase {
    @Test
    void InputZeroAsArgument() {
        setInput("0");

        new TrafficLight().run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("GREEN", getOutputLines()[0]);
    }

    @Test
    void InputFiftyFiveAsArgument() {
        setInput("55");

        new TrafficLight().run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("YELLOW", getOutputLines()[0]);
    }

    @Test
    void InputThirtyFiveAsArgument() {
        setInput("35");

        new TrafficLight().run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("YELLOW", getOutputLines()[0]);
    }

    @Test
    void InputFiftyAsArgument() {
        setInput("50");

        new TrafficLight().run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("RED", getOutputLines()[0]);
    }

    @Test
    void InputMinusOneAsArgument() {
        setInput("-1");

        new TrafficLight().run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void InputStringValueAsArgument() {
        setInput("String");

        new TrafficLight().run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void InputTwoArguments() {
        setInput("2 2");

        new TrafficLight().run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void InputDoubleAsArgument() {
        setInput("0.1");

        new TrafficLight().run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void InputDigitalValueBiggerThenIntegerAsArgument() {
        setInput("9999999999");

        new TrafficLight().run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void InputValueBiggerThenSecInOneDayAsArgument() {
        setInput("86401");

        new TrafficLight().run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("The day is over", getOutputLines()[0]);
    }

    @Test
    void InputEmptyArgument() {
        setInput("");
        assertThrows(NoSuchElementException.class, () -> new TrafficLight().run());
    }

}