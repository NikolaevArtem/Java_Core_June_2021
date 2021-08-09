package homework_2.traffic_light;

import base.UnitBase;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TrafficLightTest extends UnitBase {

    public static final String ERROR_MESSAGE = "Only 1 non-negative integer is allowed as passed parameter";
    public static final String DAY_OVER = "The day is over";

    @Test
    public void negativeParamTest() {
        TrafficLight trafficLight = new TrafficLight();
        setInput("-1");
        trafficLight.run();
        Assertions.assertEquals(ERROR_MESSAGE, getOutputLines()[0]);
    }

    @Test
    public void notNumberParamTest() {
        TrafficLight trafficLight = new TrafficLight();
        setInput("number");
        trafficLight.run();
        Assertions.assertEquals(ERROR_MESSAGE, getOutputLines()[0]);
    }

    @Test
    public void tooLargeNumberParamTest() {
        TrafficLight trafficLight = new TrafficLight();
        setInput("86400");
        trafficLight.run();
        Assertions.assertEquals(DAY_OVER, getOutputLines()[0]);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void correctParam1Test(String input,  String expected) {
        TrafficLight trafficLight = new TrafficLight();
        setInput(input);
        trafficLight.run();
        Assertions.assertEquals(expected, getOutputLines()[0]);
    }

    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("0", "Green"),
                Arguments.of("1", "Green"),
                Arguments.of("35", "Yellow"),
                Arguments.of("54", "Red")
        );

    }
}