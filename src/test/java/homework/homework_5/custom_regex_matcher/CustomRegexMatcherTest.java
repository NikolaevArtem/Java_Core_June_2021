package homework.homework_5.custom_regex_matcher;
import homework.unit_base.UnitBase;

import homework_5.custom_regex_matcher.CustomRegexMatcher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomRegexMatcherTest extends UnitBase {
    String greet = "Enter password-ish string, should have 1 lowercase letter, 1 uppercase letter, 1 number, and be at least 8 characters long";

    CustomRegexMatcher crm = new CustomRegexMatcher();
    @Test
    public void givenEmptyInput_whenRun_thenNPEThrown() {
        setInput("");
        assertThrows(NullPointerException.class, () ->
                crm.run());
    }

    @Test
    public void givenSignsNotInRegex_whenRun_thenFalse() {
        setInput("!!123tr>>?");
        crm.run();
        removeFromOutput(greet);
        assertEquals("false", getOutput());
    }

    @Test
    public void givenShortString_whenRun_thenFalse() {
        setInput("string");
        crm.run();
        removeFromOutput(greet);
        assertEquals("false", getOutput());
    }

    @Test
    public void given8PlusLengthLowercase_whenRun_thenFalse() {
        setInput("abcdefabcdef");
        crm.run();
        removeFromOutput(greet);
        assertEquals("false", getOutput());
    }

    @Test
    public void given8PlusLengthUppercase_whenRun_thenFalse() {
        setInput("ABCDABCDE");
        crm.run();
        removeFromOutput(greet);
        assertEquals("false", getOutput());
    }

    @Test
    public void given8PlusDigits_whenRun_thenFalse() {
        setInput("123456789");
        crm.run();
        removeFromOutput(greet);
        assertEquals("false", getOutput());
    }

    @Test
    public void givenCorrectOne_whenRun_thenTrue() {
        setInput("A1asdasdasd");
        crm.run();
        removeFromOutput(greet);
        assertEquals("true", getOutput());
    }

    @Test
    public void givenCorrectTwo_whenRun_thenTrue() {
        setInput("passworD123");
        crm.run();
        removeFromOutput(greet);
        assertEquals("true", getOutput());
    }

    @Test
    public void givenCorrectThree_whenRun_thenTrue() {
        setInput("PassWord0123");
        crm.run();
        removeFromOutput(greet);
        assertEquals("true", getOutput());
    }






}
