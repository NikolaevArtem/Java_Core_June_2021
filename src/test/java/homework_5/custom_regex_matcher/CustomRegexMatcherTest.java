package homework_5.custom_regex_matcher;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomRegexMatcherTest extends UnitBase {
    @Test
    void zero_test() {
        setInput("");
        new CustomRegexMatcher().run();
        assertEquals("false", getOutputLines()[1]);
    }

    @Test
    void one_test() {
        setInput("1");
        new CustomRegexMatcher().run();
        assertEquals("false", getOutputLines()[1]);
    }

    @Test
    void normal_test() {
        setInput("t@mail.com");
        new CustomRegexMatcher().run();
        assertEquals("true", getOutputLines()[1]);
    }

    @Test
    void address_bad_test1() {
        setInput("t@mai.com");
        new CustomRegexMatcher().run();
        assertEquals("false", getOutputLines()[1]);
    }

    @Test
    void address_bad_test2() {
        setInput("h55t@mail.44tm");
        new CustomRegexMatcher().run();
        assertEquals("false", getOutputLines()[1]);
    }

    @Test
    void address_bad_test3() {
        setInput("4hht@mai.com");
        new CustomRegexMatcher().run();
        assertEquals("false", getOutputLines()[1]);
    }

    @Test
    void address_bad_test4() {
        setInput("@mai.com");
        new CustomRegexMatcher().run();
        assertEquals("false", getOutputLines()[1]);
    }

    @Test
    void address_bad_test5() {
        setInput("mai.comdfdf@frg");
        new CustomRegexMatcher().run();
        assertEquals("false", getOutputLines()[1]);
    }

    @Test
    void address_bad_test6() {
        setInput("maic@@mail.com");
        new CustomRegexMatcher().run();
        assertEquals("false", getOutputLines()[1]);
    }

    @Test
    void address_bad_test7() {
        setInput("maic@mail..com");
        new CustomRegexMatcher().run();
        assertEquals("false", getOutputLines()[1]);
    }
}