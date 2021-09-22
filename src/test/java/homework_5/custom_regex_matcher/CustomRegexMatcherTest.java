package homework_5.custom_regex_matcher;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomRegexMatcherTest extends UnitBase {

    CustomRegexMatcher customRegexMatcher = new CustomRegexMatcher();

    @Test
    void givenRegexAndGoogle_whenRun_returnURLIsValid() {
        setInput("https://www.google.com/");
        customRegexMatcher.run();
        assertEquals("URL is valid", getOutputLines()[1]);
    }

    @Test
    void givenRegexAndEpam_whenRun_returnURLIsValid() {
        setInput("https://www.epam.com/careers");
        customRegexMatcher.run();
        assertEquals("URL is valid", getOutputLines()[1]);
    }

    @Test
    void givenRegexAndFPT_whenRun_returnURLIsValid() {
        setInput("ftp://websiteaddress.com");
        customRegexMatcher.run();
        assertEquals("URL is valid", getOutputLines()[1]);
    }

    @Test
    void givenRegexAndNumber_whenRun_returnURLIsNotValid() {
        setInput("123456789");
        customRegexMatcher.run();
        assertEquals("URL is not valid", getOutputLines()[1]);
    }

    @Test
    void givenRegexAndString_whenRun_returnURLIsNotValid() {
        setInput("String");
        customRegexMatcher.run();
        assertEquals("URL is not valid", getOutputLines()[1]);
    }

}