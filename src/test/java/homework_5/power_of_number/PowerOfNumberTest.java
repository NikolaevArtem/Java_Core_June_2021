package homework_5.power_of_number;

import base.UnitBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PowerOfNumberTest extends UnitBase {

    @ParameterizedTest
    @MethodSource
    void runTestValidInput(String input, String result) {
        setInput(input);

        new PowerOfNumber().run();
        printOut();
        removeFromOutput("Enter the number and degree");

        assertEquals(getOutput(), result);
    }

    @ParameterizedTest
    @MethodSource
    void runTestInvalidInput(String input) {
        setInput(input);

        new PowerOfNumber().run();
        printOut();
        removeFromOutput("Enter the number and degree");

        assertTrue(getOutput().contains("Only 2 non-negative integers are allowed"));
    }

    private static Stream<Arguments> runTestInvalidInput() {
        return Stream.of(
                Arguments.of("-2 0"),
                Arguments.of("2 -1"),
                Arguments.of("-2 -2"),
                Arguments.of("a 3"),
                Arguments.of("2 a"),
                Arguments.of("a a"),
                Arguments.of("2"),
                Arguments.of(""),
                Arguments.of("2 8 9")
        );
    }

    private static Stream<Arguments> runTestValidInput() {
        return Stream.of(
                Arguments.of("2 0", "1"),
                Arguments.of("2 1", "2"),
                Arguments.of("2 2", "4"),
                Arguments.of("2 3", "8"),
                Arguments.of("2 4", "16"),
                Arguments.of("2 5", "32"),
                Arguments.of("2 6", "64"),
                Arguments.of("2 7", "128"),
                Arguments.of("2 8", "256"),
                Arguments.of("2 9", "512"),
                Arguments.of("2 10", "1024"),
                Arguments.of("10 2", "100"),
                Arguments.of("10 3", "1000"),
                Arguments.of("10 4", "10000"),
                Arguments.of("10 10", "10000000000"),
                Arguments.of("11 10", "25937424601")
        );
    }

}