package homework_5.power_of_number;

import base.UnitBase;
import homework_5.custom_regex_matcher.CustomRegexMatcher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerOfNumberTest extends UnitBase {
    @Test
    void zero_test() {
        setInput("");
        new PowerOfNumber().run();
        assertEquals("Only 2 non-negative integers are allowed", getOutputLines()[0]);
    }

    @Test
    void bad_test() {
        setInput("546 ftd");
        new PowerOfNumber().run();
        assertEquals("Only 2 non-negative integers are allowed", getOutputLines()[0]);
    }

    @Test
    void negative_test() {
        setInput("-3 3");
        new PowerOfNumber().run();
        assertEquals("Only 2 non-negative integers are allowed", getOutputLines()[0]);
    }

    @Test
    void zero_one_test() {
        setInput("0 1");
        new PowerOfNumber().run();
        assertEquals("0", getOutputLines()[0]);
    }

    @Test
    void one_one_test() {
        setInput("1 1");
        new PowerOfNumber().run();
        assertEquals("1", getOutputLines()[0]);
    }

    @Test
    void one_ten_test() {
        setInput("1 10");
        new PowerOfNumber().run();
        assertEquals("1", getOutputLines()[0]);
    }

    @Test
    void two_two_test() {
        setInput("2 2");
        new PowerOfNumber().run();
        assertEquals("4", getOutputLines()[0]);
    }

    @Test
    void two_four_test() {
        setInput("2 4");
        new PowerOfNumber().run();
        assertEquals("16", getOutputLines()[0]);
    }

    @Test
    void ten_two_test() {
        setInput("10 2");
        new PowerOfNumber().run();
        assertEquals("100", getOutputLines()[0]);
    }

    @Test
    void ten_three_test() {
        setInput("10 3");
        new PowerOfNumber().run();
        assertEquals("1000", getOutputLines()[0]);
    }
}