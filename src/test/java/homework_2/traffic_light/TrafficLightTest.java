package homework_2.traffic_light;

import base.UnitBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TrafficLightTest extends UnitBase{

    private static String welcomeMessage = "Enter seconds value (int) from 0 - 86399: ";
    private static String errorMessage1 = "Only 1 non-negative integer is allowed as passed parameter";
    private static String errorMessage2 = "Day is over!";

    @ParameterizedTest
    @MethodSource("testCases")
    void test_MainCases(final String input, final String expected) {
        setInput(input);
        new TrafficLight().run();
        printOut();
        removeFromOutput(welcomeMessage);
        String actual = getOutput();
        assertTrue(actual.contains(expected));
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("22", getTrafficLightOutput(22)),
                Arguments.of("40", getTrafficLightOutput(40)),
                Arguments.of("0", getTrafficLightOutput(0)),
                Arguments.of("60", getTrafficLightOutput(60)),
                Arguments.of("41", getTrafficLightOutput(41)),
                Arguments.of("86399", getTrafficLightOutput(86399)),
                Arguments.of("005", getTrafficLightOutput(5))
        );
    }

    @ParameterizedTest
    @MethodSource("Negative_NonDigit_Values")
    void test_Negative_NonDigit_Values(final String input, final String expected) {
        setInput(input);
        new TrafficLight().run();
        printOut();
        removeFromOutput(welcomeMessage);
        String actual = getOutput();
        assertTrue(actual.contains(expected));
    }

    static Stream<Arguments> Negative_NonDigit_Values() {
        return Stream.of(
                Arguments.of("test", errorMessage1),
                Arguments.of("5878 545454 464", errorMessage1),
                Arguments.of("hello", errorMessage1),
                Arguments.of("-5", errorMessage1),
                Arguments.of("-100000000", errorMessage1),
                Arguments.of("", errorMessage1),
                Arguments.of(" ", errorMessage1),
                Arguments.of("2147483648", errorMessage1),
                Arguments.of("87399", errorMessage2)
        );
    }

    private static String getTrafficLightOutput(int inputInt) {
        int SecondsInLastMinute = inputInt % 60;
        String currentColorText;
        if (SecondsInLastMinute < 35) {
            currentColorText = "green";
        } else if (SecondsInLastMinute < 40) {
            currentColorText = "yellow";
        } else if (SecondsInLastMinute < 55) {
            currentColorText = "red";
        } else {
            currentColorText = "yellow";
        }
        return currentColorText.toUpperCase();
    }
}