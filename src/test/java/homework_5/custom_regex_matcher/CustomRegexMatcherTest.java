package homework_5.custom_regex_matcher;

import base.UnitBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CustomRegexMatcherTest extends UnitBase {

    @ParameterizedTest
    @MethodSource
    void runTestValidInput(String input) {
        setInput(input);

        new CustomRegexMatcher().run();
        printOut();
        removeFromOutput("Enter the phone number");

        assertEquals(getOutput(), "true");
    }

    @ParameterizedTest
    @MethodSource
    void runTestInvalidInput(String input) {
        setInput(input);

        new CustomRegexMatcher().run();
        printOut();
        removeFromOutput("Enter the phone number");

        assertEquals(getOutput(), "false");
    }

    private static Stream<Arguments> runTestValidInput() {
        return Stream.of(
                Arguments.of("8(499)1111111"),
                Arguments.of("+7(499)111-11-11"),
                Arguments.of("+7(499)1111111"),
                Arguments.of("8(499)111 11 11"),
                Arguments.of("+7(499)111 11 11"),
                Arguments.of("8 499 111-11-11"),
                Arguments.of("84991111111"),
                Arguments.of("+7 111 111 11 11")
        );
    }

    private static Stream<Arguments> runTestInvalidInput() {
        return Stream.of(
                Arguments.of("8(905 336 52 45"),
                Arguments.of("8 905) 336 52 45"),
                Arguments.of("8(905)336 52 5"),
                Arguments.of("8(905)336 2 45"),
                Arguments.of(" "),
                Arguments.of(""),
                Arguments.of("8(905)33 52 45"),
                Arguments.of("8(90)336 52 45"),
                Arguments.of("+8(905)336 52 45"),
                Arguments.of("+(905)336 52 45"),
                Arguments.of("8(4991111111"),
                Arguments.of("8499)1111111"),
                Arguments.of("8(499)1 111111"),
                Arguments.of("49)1 111111"),
                Arguments.of("(905)336 52 45")
        );
    }

}