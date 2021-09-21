package homework_5.custom_regex_matcher;

import base.UnitBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PowerOfNumberTest extends UnitBase {

    private static String welcomeMessage = "Enter your email: ";

    @ParameterizedTest
    @MethodSource("testCases")
    void test_MainCases(final String input, final String expected) {
        setInput(input);
        new CustomRegexMatcher().readFromConsole();
        removeFromOutput(welcomeMessage);
        printOut();
        String actual = getOutput();
        assertEquals(expected, actual);
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("abelyaevskov@gmail.com", "true"),
                Arguments.of("abelyaevskov@narod.biz.ru", "true"),
                Arguments.of("abelyaevskov", "false"),
                Arguments.of("abelyaevskov@", "false"),
                Arguments.of("0", "false"),
                Arguments.of(" ", "false"),
                Arguments.of("123abelyaevskov@gmail.com", "false"),
                Arguments.of("abelyaevskov@123gmail.com", "false")
        );
    }


}