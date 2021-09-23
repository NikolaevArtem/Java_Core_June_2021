package homework_5.custom_regex_matcher;

import base.UnitBase;
import homework_5.power_of_number.PowerOfNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomRegexMatcherTest extends UnitBase {
    @ParameterizedTest
    @MethodSource("validInput")
    void ValidInput(String input) {
        setInput(input);

        new CustomRegexMatcher().run();
        printOut();
        removeFromOutput("Please enter a valid ipv4 address: ");

        assertEquals(getOutput(), "true");
    }

    @ParameterizedTest
    @MethodSource("invalidInput")
    void InvalidInput(String input) {
        setInput(input);

        new CustomRegexMatcher().run();
        printOut();
        removeFromOutput("Please enter a valid ipv4 address: ");

        assertEquals(getOutput(), "false");
    }

    private static Stream<Arguments> validInput() {
        return Stream.of(
                Arguments.of("172.16.254.1"),
                Arguments.of("255.255.255.255"),
                Arguments.of("172.21.118.45"),
                Arguments.of("0.0.0.3"),
                Arguments.of("192.168.0.17")
        );
    }

    private static Stream<Arguments> invalidInput() {
        return Stream.of(
                Arguments.of("1.2.3.0"),
                Arguments.of("0.0.0.256"),
                Arguments.of("x.y.z.t"),
                Arguments.of("1...1"),
                Arguments.of("1.1.1"),
                Arguments.of("1.1.1.1.1"),
                Arguments.of("1000.1.1.1"),
                Arguments.of("1.2.3.04")
        );
    }
}
