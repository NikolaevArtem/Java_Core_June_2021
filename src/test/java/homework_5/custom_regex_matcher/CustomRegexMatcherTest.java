package homework_5.custom_regex_matcher;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CustomRegexMatcherTest extends UnitBase {
    @Test
    public void correctEmptyJson(){
        setInput("{\"users\":[]}");
        new CustomRegexMatcher().run();
        assertEquals("true", getOutput());
    }

    @Test
    public void incorrectEmptyJson(){
        setInput("{}");
        new CustomRegexMatcher().run();
        assertEquals("false", getOutput());
    }

    @Test
    public void correctJson(){
        setInput("{\"users\":[{\"userName\":\"SomeName1\",\"justName\":\"Sergey\"},{\"userName\":\"user1234\"}]}");
        new CustomRegexMatcher().run();
        assertEquals("true", getOutput());
    }

    @Test
    public void incorrectUserNameJson(){
        setInput("{\"users\":[{\"userName\":\"1SomeName\"}]}");
        new CustomRegexMatcher().run();
        assertEquals("false", getOutput());
    }

    @Test
    public void incorrectLengthOfUserNameJson(){
        setInput("{\"users\":[{\"userName\":\"a23456789012345678901\"}]}");
        new CustomRegexMatcher().run();
        assertEquals("false", getOutput());
    }
}
