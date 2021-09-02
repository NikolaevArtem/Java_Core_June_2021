package homework_5.custom_regex_matcher;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomRegexMatcherTest extends UnitBase {

    @Test
    void givenCorrectUserName_whenCheckRegex_thenTrue() {
        String expected = "true";
        setInput("nuker228");
        new CustomRegexMatcher().run();
        removeFromOutput("Enter your username, it must only contain letters, numbers and dot, minimum length 5, maximum length 10(inclusive):");
        assertEquals(expected, getOutput());
        printOut();
    }

    @Test
    void givenCorrectUserNameWithDot_whenCheckRegex_thenTrue() {
        String expected = "true";
        setInput("nuker.228");
        new CustomRegexMatcher().run();
        removeFromOutput("Enter your username, it must only contain letters, numbers and dot, minimum length 5, maximum length 10(inclusive):");
        assertEquals(expected, getOutput());
        printOut();
    }

    @Test
    void givenIncorrectUserName_whenCheckRegex_thenFalse() {
        String expected = "false";
        setInput("nuker@228");
        new CustomRegexMatcher().run();
        removeFromOutput("Enter your username, it must only contain letters, numbers and dot, minimum length 5, maximum length 10(inclusive):");
        assertEquals(expected, getOutput());
        printOut();
    }

}