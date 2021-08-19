package homework_5.custom_regex_matcher;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static homework_5.custom_regex_matcher.utils.Constants.ERROR_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomRegexMatcherTest extends UnitBase {
    private final CustomRegexMatcher customRegexMatcher = new CustomRegexMatcher();

    @Test
    void test_noArgs_thenGetErrorMessage() {
        String[] args = {};
        customRegexMatcher.run(args);
        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void test_ValidArg_thenGetTrue() {
        String[] args = {"2021-02-09T18:18:24:424Z – [username9] - wanna scoop 182l"};
        customRegexMatcher.run(args);
        assertEquals("true", getOutput());
    }

    @Test
    void test_ValidArgs_thenGetTrue() {
        String[] args = {"2021-02-09T18:18:24:424Z – [username9] - wanna scoop 182l",
                "2021-02-09T18:18:23:081Z – [username10] - wanna top up 66l",
                "2021-02-09T18:18:27:941Z – [username7] - wanna top up 148l"};
        customRegexMatcher.run(args);
        assertEquals("true\ntrue\ntrue", getOutput());
    }

    @Test
    void test_ValidArgsAndInvalidArgs_thenGetTrueFalseTrue() {
        String[] args = {"2021-02-09T18:18:30:557Z – [username7] - wanna top up 173l",
                "202102-09T18:18:31:117Z – [username9] - wanna top up 96l",
                "2021-02-09T18:20:27:448Z – [username6] - wanna scoop 21l"};
        customRegexMatcher.run(args);
        assertEquals("true\nfalse\ntrue", getOutput());
    }

    @Test
    void test_InvalidArgs_thenGetFalse() {
        String[] args = {"2021-0209T18:18:30:557Z – [username7] - wanna top up 173l",
                "202102-09T18:18:31:117Z – [username9] - wanna top up 96l",
                "Just a string"};
        customRegexMatcher.run(args);
        assertEquals("false\nfalse\nfalse", getOutput());
    }

}
