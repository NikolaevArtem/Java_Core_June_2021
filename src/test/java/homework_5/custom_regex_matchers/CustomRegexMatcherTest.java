package homework_5.custom_regex_matchers;

import base.UnitBase;
import homework_5.custom_regex_matcher.CustomRegexMatcher;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CustomRegexMatcherTest extends UnitBase {

    @ParameterizedTest
    @MethodSource("testCasesIncorrect")
    public void checkIncorrectEmails(String email) {
        setInput(email);
        CustomRegexMatcher customRegexMatcher = new CustomRegexMatcher();
        Assertions.assertFalse(customRegexMatcher.run());
    }

    public static Stream<Arguments> testCasesIncorrect() {
        return Stream.of(
                Arguments.of("_awdawd@mail.ru"),
                Arguments.of("awdawmail.ru"),
                Arguments.of("adwawd@.ru"),
                Arguments.of("awdawdw@"),
                Arguments.of("awdawdw@mail"),
                Arguments.of("awdawdw@ru"),
                Arguments.of("awdawdw@."),
                Arguments.of("awdawdw@awda_ru")
        );
    }

    @ParameterizedTest
    @MethodSource("testCasesCorrect")
    public void checkCorrectEmails(String email) {
        setInput(email);
        CustomRegexMatcher customRegexMatcher = new CustomRegexMatcher();
        Assertions.assertTrue(customRegexMatcher.run());
    }

    public static Stream<Arguments> testCasesCorrect() {
        return Stream.of(
                Arguments.of("awdawd@mail.ru"),
                Arguments.of("awdaw@tinkof.com"),
                Arguments.of("2.adwawd@group.ru"),
                Arguments.of("2_adwawd@group.ru"),
                Arguments.of("awda.213wdw@mail.net")
        );
    }
}
