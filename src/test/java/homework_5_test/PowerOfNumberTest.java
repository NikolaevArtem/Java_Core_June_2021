package homework_5_test;

import base.UnitBase;
import homework_5.power_of_number.PowerOfNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PowerOfNumberTest extends UnitBase {

    private static final String ERROR_MESSAGE = "Only 2 non-negative integers are allowed";

    @ParameterizedTest
    @MethodSource("validTestCases")
    void testValidInput(String in, String expected) {
        setInput(in);
        new PowerOfNumber().run();

        removeFromOutput("Enter number and power: ");

        assertEquals(expected, getOutput());
    }

    @ParameterizedTest
    @MethodSource("invalidTestCases")
    void testInvalidInput(String in) {
        setInput(in);
        new PowerOfNumber().run();

        removeFromOutput("Enter number and power: ");

        assertEquals(ERROR_MESSAGE, getOutput());
    }

    static Stream<Arguments> validTestCases() {
        return Stream.of(
                Arguments.of("2 2", "4"),
                Arguments.of("2 1", "2"),
                Arguments.of("2 0", "1"),
                Arguments.of("0 2", "0")
        );
    }

    static Stream<Arguments> invalidTestCases() {
        return Stream.of(
                Arguments.of("2"),
                Arguments.of("2 2 2"),
                Arguments.of("2 a"),
                Arguments.of("a 2 a"),
                Arguments.of("Hello")
        );
    }
}
