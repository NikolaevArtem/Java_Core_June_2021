package homework_5.CustomRegexMatcher;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomRegexMatcherTest extends UnitBase {

    CustomRegexMatcher customRegexMatcher = new CustomRegexMatcher();

    @Test
    void giveRegex_whenRun_returnTrue() {
        customRegexMatcher.regex = "\\w+";
        setInput("Usually");
        customRegexMatcher.run();
        assertEquals("true", getOutputLines()[1]);
    }

    @Test
    void giveRegex_whenRun_returnFalse() {
        customRegexMatcher.regex = "\\w+";
        setInput("Usually string");
        customRegexMatcher.run();
        assertEquals("false", getOutputLines()[1]);
    }

    @Test
    void giveRegexDig_whenRun_returnTrue() {
        customRegexMatcher.regex = "\\d+";
        setInput("880055535");
        customRegexMatcher.run();
        assertEquals("true", getOutputLines()[1]);
    }

    @Test
    void giveRegexDig_whenRun_returnFalse() {
        customRegexMatcher.regex = "\\d+";
        setInput("8800word55535");
        customRegexMatcher.run();
        assertEquals("false", getOutputLines()[1]);
    }

    @Test
    void giveRegexBlank_whenRun_returnTrue() {
        customRegexMatcher.regex = "^[a-zA-Z0-9_ ]*$";
        setInput("two words");
        customRegexMatcher.run();
        assertEquals("true", getOutputLines()[1]);
    }

    @Test
    void giveRegexBlank_whenRun_returnFalse() {
        customRegexMatcher.regex = "^[a-zA-Z0-9_ ]";
        setInput("word");
        customRegexMatcher.run();
        assertEquals("false", getOutputLines()[1]);
    }


    @Test
    void giveRegexTelephone7_whenRun_returnTrue() {
        customRegexMatcher.regex = "^(?:8|\\+7)[0-9]{10}$";
        setInput("+79081234567");
        customRegexMatcher.run();
        assertEquals("true", getOutputLines()[1]);
    }

    @Test
    void giveRegexTelephone8_whenRun_returnTrue() {
        customRegexMatcher.regex = "^(?:8|\\+7)[0-9]{10}$";
        setInput("89081234567");
        customRegexMatcher.run();
        assertEquals("true", getOutputLines()[1]);
    }

    @Test
    void giveRegexTelephone_whenRun_returnFalse() {
        customRegexMatcher.regex = "^(?:8|\\+7)[0-9]{10}$";
        setInput("+790812Z4567");
        customRegexMatcher.run();
        assertEquals("false", getOutputLines()[1]);
    }


}