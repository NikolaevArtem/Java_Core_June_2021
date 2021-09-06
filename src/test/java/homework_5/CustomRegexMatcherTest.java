package homework_5;

import base.UnitBase;
import homework_5.custom_regex_matcher.CustomRegexMatcher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomRegexMatcherTest extends UnitBase {

    @Test
    void givenCorrectInputs_whenRun_thenReturnTrue() {
        setInput("9876 867576 Saltikova-Schedrina Mary-Jane Ivanovna");
        new CustomRegexMatcher().run();
        assertTrue(Boolean.parseBoolean(getOutputLines()[0]));

        setInput("9876867576 Saltikova Mary Semenova");
        new CustomRegexMatcher().run();
        assertTrue(Boolean.parseBoolean(getOutputLines()[1]));

        setInput("9876867576 Saltikova Mary-Jane");
        new CustomRegexMatcher().run();
        assertTrue(Boolean.parseBoolean(getOutputLines()[2]));

        setInput("9876   867576    Saltikova-Schedrina   Mary-Jane   Ivanovna");
        new CustomRegexMatcher().run();
        assertTrue(Boolean.parseBoolean(getOutputLines()[3]));
    }

    @Test
    void givenInCorrectInputs_whenRun_thenReturnTrue() {
        setInput("9876 867576 saltikova-Schedrina Mary-jane ivanovna");
        new CustomRegexMatcher().run();
        assertFalse(Boolean.parseBoolean(getOutputLines()[0]));

        setInput("9876 867576Schedrina MaryIvanovna");
        new CustomRegexMatcher().run();
        assertFalse(Boolean.parseBoolean(getOutputLines()[1]));
    }
}
