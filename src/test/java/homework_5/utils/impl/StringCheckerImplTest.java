package homework_5.utils.impl;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.util.regex.PatternSyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class StringCheckerImplTest extends UnitBase {

    @Test
    void setPatternValidTest() {
        String pattern = "\\s+.*[\\w]?";

        new StringCheckerImpl().setPattern(pattern);
    }

    @Test
    void setPatternInvalidTest() {
        String pattern = "\\";

        assertThrows(PatternSyntaxException.class, () -> new StringCheckerImpl().setPattern(pattern));
    }

    @Test
    void checkValidDataTest() {
        String pattern = "[abc]{0,3}";
        String input = "abc";

        assertTrue(new StringCheckerImpl().setPattern(pattern).checkData(input));
    }

    @Test
    void checkInvalidDataTest() {
        String pattern = "[abc]{0,3}";
        String input = "abd";

        assertFalse(new StringCheckerImpl().setPattern(pattern).checkData(input));
    }
}