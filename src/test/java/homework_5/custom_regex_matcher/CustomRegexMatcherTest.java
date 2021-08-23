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
    @MethodSource("testsCases")
    void givenNumber_whenRun_thenTrue(String input) {
        setInput(input);
        new CustomRegexMatcher().run();
        getOutput();
        assertEquals("true", getOutputLines()[7]);
    }

    static Stream<Arguments> testsCases() {
        return Stream.of(
                Arguments.of("+7-999-248-20-21"),
                Arguments.of("8-999-248-20-21"),
                Arguments.of("+7-(999)-248-20-21"),
                Arguments.of("+7 (999) 248-20 21"),
                Arguments.of("8-(999)-248-20-21"),
                Arguments.of("+7 999 248 20 21"),
                Arguments.of("8 999 248 20 21")
        );
    }

    @ParameterizedTest
    @MethodSource("testsCases2")
    void givenNumber_whenRun_thenFalse(String input) {
        setInput(input);
        new CustomRegexMatcher().run();
        getOutput();
        assertEquals("false", getOutputLines()[7]);
    }

    static Stream<Arguments> testsCases2() {
        return Stream.of(
                Arguments.of("+7 (999-248-20-21"),
                Arguments.of("8-999-(248)-20-21"),
                Arguments.of("+7-(999)-248-20-211"),
                Arguments.of("8-(999)-248-201-21"),
                Arguments.of("+79992482021"),
                Arguments.of("A 9F9 248 2021"),
                Arguments.of("8 999 248"),
                Arguments.of("8 999 2021"),
                Arguments.of("999 248 2021"),
                Arguments.of("999 248 20 21"),
                Arguments.of("it's not a number at all"),
                Arguments.of(" ")
        );
    }
}
