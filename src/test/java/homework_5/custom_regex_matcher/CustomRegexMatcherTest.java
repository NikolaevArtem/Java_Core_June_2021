package homework_5.custom_regex_matcher;

import base.UnitBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomRegexMatcherTest extends UnitBase {

    @Test
    void givenMatchingString_whenRun_thenTrueReturned() {
        setInput("KissKiss#1");

        new CustomRegexMatcher().run();
        printOut();

        Assertions.assertEquals("true", getOutput());
    }

    @Test
    void givenTooShortString_whenRun_thenFalseReturned() {
        setInput("test");

        new CustomRegexMatcher().run();
        printOut();

        Assertions.assertEquals("false",getOutput());
    }

    @Test
    void givenNotMatchingString_whenRun_thenFalseReturned() {
        setInput("test1test1");

        new CustomRegexMatcher().run();
        printOut();

        Assertions.assertEquals("false", getOutput());
    }
}