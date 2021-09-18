package homework_5_tests;

import base.UnitBase;
import homework_5.custom_regex_matcher.CustomRegexMatcher;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomRegexMatcherTest extends UnitBase {

    private void run() {
        new CustomRegexMatcher().run();
        removeFromOutput("Enter your password: ");
        printOut();
    }

    @ParameterizedTest
    @MethodSource("testTrueCases")
    void givenCorrectPassword_whenRun_thenTrue(String input, String expected) {
        setInput(input);

        run();

        assertEquals(expected, getOutput());
    }

    private static Stream<Arguments> testTrueCases() {
        return Stream.of(
                Arguments.of("Cheeseburger1!", "Password security: true"),
                Arguments.of("21$cheeseburgeR", "Password security: true"),
                Arguments.of("2cheese!Burger", "Password security: true")
        );
    }

    @ParameterizedTest
    @MethodSource("testFalseCases")
    void givenIncorrectPassword_whenRun_thenFalse(String input, String expected) {
        setInput(input);

        run();

        assertEquals(expected, getOutput());
    }

    private static Stream<Arguments> testFalseCases() {
        return Stream.of(
                Arguments.of("cheeseburger1!", "Password must contain uppercase letters."),
                Arguments.of("21& cheeseburgeR", "Password must not contain a space."),
                Arguments.of("cheeseBurger1", "Password must contain special characters: !, $, %, #, ^"),
                Arguments.of(" cheeseBurger21! ", "Password must not contain a space."),
                Arguments.of("2!", "Password at least 8 characters long must contain lowercase and uppercase letters, digits and special characters: !, $, %, #, ^.")
        );
    }



}
