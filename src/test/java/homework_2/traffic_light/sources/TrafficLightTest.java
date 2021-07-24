package homework_2.traffic_light.sources;

import base.UnitBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficLightTest extends UnitBase {

    TrafficLight trafficLight = new TrafficLight();

    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("0", "[1;92mGREEN\u001B[0m"),
                Arguments.of("101", "[1;91mRED\u001B[0m"),
                Arguments.of("121", "[1;92mGREEN\u001B[0m"),
                Arguments.of("155", "[1;93mYELLOW\u001B[0m"),
                Arguments.of("86399", "[1;93mYELLOW\u001B[0m"),
                Arguments.of("86400", "The day is over"),
                Arguments.of("anytext", "Only 1 non-negative integer is allowed as passed parameter"),
                Arguments.of("-1", "Only 1 non-negative integer is allowed as passed parameter"),
                Arguments.of("", "Only 1 non-negative integer is allowed as passed parameter")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void testFactorial(String in, String expected) {
        setInput(in);
        trafficLight.run();
        printOut();
        removeFromOutput("Please, input seconds gone from the day start: ");
        assertEquals(expected, getOutputLines()[0]);
    }

}