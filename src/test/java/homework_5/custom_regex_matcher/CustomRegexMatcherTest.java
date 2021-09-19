package homework_5.custom_regex_matcher;

import base.UnitBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CustomRegexMatcherTest extends UnitBase {
    private final String GREETING = "Enter the car's number:";
    CustomRegexMatcher customRegexMatcher = new CustomRegexMatcher();

    /*
    @ParameterizedTest
    @MethodSource ("rightRussianCases")
    public void givenRightCarNumbers_whenRussian_thenTrueResult (String input, String expected) {
        setInput(input);
        customRegexMatcher.run();
        getOutput();
        removeFromOutput(GREETING);
        Assertions.assertEquals(expected, getOutputLines() [0]);

    }

    static Stream<Arguments> rightRussianCases() {
        return Stream.of(
                Arguments.of("Р386АВ14", "true"),
                Arguments.of("Р386ав114", "true"),
                Arguments.of("Р386Ав14", "true"),
                Arguments.of("О770ЕХ14", "true"),
                Arguments.of("о770ЕХ14", "true"),
                Arguments.of("о770ех114", "true")
        );
    }
     */

    @ParameterizedTest
    @MethodSource ("rightEnglishCases")
    public void givenRightCarNumbers_whenEnglish_thenTrueResult (String input, String expected) {
        setInput(input);
        customRegexMatcher.run();
        getOutput();
        removeFromOutput(GREETING);
        Assertions.assertEquals(expected, getOutputLines() [0]);

    }

    static Stream<Arguments> rightEnglishCases() {
        return Stream.of(
                Arguments.of("P386AB14", "true"),
                Arguments.of("p386ab114", "true"),
                Arguments.of("P386Ab14", "true"),
                Arguments.of("O770EX14", "true"),
                Arguments.of("o770Ex14", "true"),
                Arguments.of("o770ex114", "true")
        );
    }

    @ParameterizedTest
    @MethodSource ("wrongRussianAndEnglishCases")
    public void givenWrongCarNumbers_whenEnglishAndRussian_thenFalseResult (String input, String expected) {
        setInput(input);
        customRegexMatcher.run();
        getOutput();
        removeFromOutput(GREETING);
        Assertions.assertEquals(expected, getOutputLines() [0]);

    }

    static Stream<Arguments> wrongRussianAndEnglishCases() {
        return Stream.of(
                Arguments.of("G386AB14", "false"),
                Arguments.of("п386ab114", "false"),
                Arguments.of("P386Ав1114", "false"),
                Arguments.of("O770EX4", "false"),
                Arguments.of("o770Ex", "false"),
                Arguments.of("GS386AB14", "false"),
                Arguments.of("G386ABs14", "false"),
                Arguments.of("o77чex114", "false")
        );
    }


}
