package homework_5.custom_regex_matcher;

import base.UnitBase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CustomRegexMatcherTest extends UnitBase {

    @Test
    void testValidPhoneNumber() {
        String expected = "true";
        setInput("+1 (267) 759-9000");
        CustomRegexMatcher.run();
        printOut();
        assertEquals(expected, getOutput());
    }

    @Test
    void testValidUnicodeInputNumber() {
        String expected = "true";
        setInput("\u002B\u0031 \u0028\u0032\u0036\u0037\u0029 \u0037\u0035\u0039\u002D\u0038\u0039\u0038\u0039");
        CustomRegexMatcher.run();
        printOut();
        assertEquals(expected, getOutput());
    }

    public static Stream<Arguments> incorrectPhoneNumbersFormats() {
        return Stream.of(
                Arguments.of("+9 (2902) 123-4567"),
                Arguments.of("not number at all, ho-ho"),
                Arguments.of("-2 (123) 456-7890"),
                Arguments.of("(+1) (123) 456-7890"),
                Arguments.of("_12345678901"),
                Arguments.of("+1 234 567-8909"),
                Arguments.of("+1 (3.14) 742-7580"),
                Arguments.of("\u1F606")
        );
    }

    @ParameterizedTest
    @MethodSource("incorrectPhoneNumbersFormats")
    void testSetOfIncorrectPhoneNumbersFormats(String input) {
        String expected = "false";
        setInput(input);
        CustomRegexMatcher.run();
        printOut();
        assertEquals(expected, getOutput());
    }

}
