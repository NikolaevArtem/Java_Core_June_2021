package homework_5.custom_regex_matcher;

import base.UnitBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomRegexMatcherTest extends UnitBase {

    @ParameterizedTest
    @MethodSource("validPhoneNumbers")
    void testPhoneNumbers(String number) {
        setInput(number);
        new CustomRegexMatcher().run();
        assertTrue(getOutput().contains("true"));
    }

    @ParameterizedTest
    @MethodSource("invalidPhoneNumbers")
    void testInvalidPhoneNumbers(String number) {
        setInput(number);
        new CustomRegexMatcher().run();
        assertTrue(getOutput().contains("false"));
    }

    private static Stream<Arguments> validPhoneNumbers() {
        return Stream.of(
                Arguments.of("79001234567"),
                Arguments.of("89001234567"),
                Arguments.of("8(900)1234567"),
                Arguments.of("+7 (900) 123-45-67"),
                Arguments.of("8 900 123 45 67"),
                Arguments.of("8-900-123-45-67"),
                Arguments.of("8.900.123.45.67")
        );
    }

    private static Stream<Arguments> invalidPhoneNumbers() {
        return Stream.of(
                Arguments.of("7 9 0 0 1 2 3 4 5 6 7"),
                Arguments.of("9001234567777"),
                Arguments.of("7__9001234567"),
                Arguments.of("6(900)1234567"),
                Arguments.of("+7  (900) 123-45-67"),
                Arguments.of("8 9005 123 45 67"),
                Arguments.of("8-900-123-45-6"),
                Arguments.of("900.123.45.67.31")
        );
    }
}