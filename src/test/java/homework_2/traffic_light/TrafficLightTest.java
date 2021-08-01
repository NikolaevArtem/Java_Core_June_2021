package homework_2.traffic_light;

import base.UnitBaseMode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class  TrafficLightTest extends UnitBaseMode {

    private final TrafficLight trafficLight = new TrafficLight();
    private final String METHOD_NAME = "run";
    private final String STRING_TO_DEL = "Enter the number";

    @ParameterizedTest
    @ValueSource(strings = {"0", "5", "61"})
    void runTestValidArg1(String input) {
        setInput(input);

        run(trafficLight, METHOD_NAME, STRING_TO_DEL);

        assertTrue(getOutput().contains("Green light"));
    }

    @Test
    void runTestValidArg2() {
        setInput("35");

        run(trafficLight, METHOD_NAME, STRING_TO_DEL);

        assertTrue(getOutput().contains("Yellow light"));
    }

    @Test
    void runTestValidArg3() {
        setInput("54");

        run(trafficLight, METHOD_NAME, STRING_TO_DEL);

        assertTrue(getOutput().contains("Red light"));
    }

    @Test
    void runTestValidArg4() {
        setInput("86401");

        run(trafficLight, METHOD_NAME, STRING_TO_DEL);

        assertTrue(getOutput().contains("Day is over"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-12", "12345678901234567890123456", "asd"})
    void runTestInvalidArg(String inputString) {
        setInput(inputString);

        run(trafficLight, METHOD_NAME, STRING_TO_DEL);

        assertTrue(getOutput().contains("Only 1 non-negative integer is allowed as passed parameter"));
    }
}