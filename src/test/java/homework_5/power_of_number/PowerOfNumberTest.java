package homework_5.power_of_number;

import base.UnitBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PowerOfNumberTest extends UnitBase {
    @ParameterizedTest
    @MethodSource("validInput")
    void ValidInput(String input, String result) {
        setInput(input);

        new PowerOfNumber().run();
        printOut();
        removeFromOutput("Please enter number and power of this number: ");

        assertEquals(getOutput(), result);
    }

    @ParameterizedTest
    @MethodSource("invalidInput")
    void InvalidInput(String input) {
        setInput(input);

        new PowerOfNumber().run();
        printOut();
        removeFromOutput("Please enter number and power of this number: ");

        assertTrue(getOutput().contains("Only 2 non-negative integers are allowed"));
    }

    private static Stream<Arguments> validInput() {
        return Stream.of(
                Arguments.of("2 2", "4"),
                Arguments.of("2 1", "2"),
                Arguments.of("2 0", "1"),
                Arguments.of("0 2", "0"),
                Arguments.of("0 0", "1"),
                Arguments.of("10 2", "100"),
                Arguments.of("2 10", "1024")
        );
    }

    private static Stream<Arguments> invalidInput() {
        return Stream.of(
                Arguments.of("-300 1"),
                Arguments.of("1 -300"),
                Arguments.of("-30 -30"),
                Arguments.of("hello"),
                Arguments.of("one two"),
                Arguments.of("1 2 3 4"),
                Arguments.of("10"),
                Arguments.of(" ")
        );
    }
}
