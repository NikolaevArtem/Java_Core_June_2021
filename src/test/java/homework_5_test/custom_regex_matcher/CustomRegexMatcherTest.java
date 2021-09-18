package homework_5_test.custom_regex_matcher;

import base.UnitBase;
import homework_5.custom_regex_matcher.CustomRegexMatcher;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomRegexMatcherTest extends UnitBase {

    @ParameterizedTest
    @MethodSource("goodCases")
    void testGoodCases(String expected, String input) {
        setInput(input);

        new CustomRegexMatcher().run();
        removeFromOutput("Enter ip-address for validation: ");

        assertEquals(expected, getOutput());
    }

    @ParameterizedTest
    @MethodSource("badCases")
    void testBadCases(String expected, String input) {
        setInput(input);

        new CustomRegexMatcher().run();
        removeFromOutput("Enter ip-address for validation: ");

        assertEquals(expected, getOutput());
    }

    static Stream<Arguments> goodCases() {
        return Stream.of(
                Arguments.of("true", "000.12.12.034"),
                Arguments.of("true", "121.234.12.12"),
                Arguments.of("true", "23.45.12.56"),
                Arguments.of("true", "255.2.001.47"),
                Arguments.of("true", "192.168.1.1")
        );
    }

    static Stream<Arguments> badCases() {
        return Stream.of(
                Arguments.of("false", "000.12.234.23.23"),
                Arguments.of("false", "666.666.23.23"),
                Arguments.of("false", ".213.123.23.32"),
                Arguments.of("false", "23.45.22.32."),
                Arguments.of("false", "I.Am.not.an.ip"),
                Arguments.of("false", "122.23"),
                Arguments.of("false", "Hello.IP")
        );
    }
}
