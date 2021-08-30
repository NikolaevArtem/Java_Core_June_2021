package homework_5.custom_regex_matcher;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomRegexMatcherTest extends UnitBase {

    @Test
    void validInputTest() {
        final String input_value = "test_email@test_host.com";
        setInput(input_value);

        String result = new CustomRegexMatcher().run();

        removeFromOutput("Введите данные:");
        assertEquals("true", result);
        assertEquals("true", getOutputLines()[0]);
    }

    @Test
    void EmptyInputTest() {
        final String input_value = "";
        setInput(input_value);

        assertThrows(NoSuchElementException.class, () -> new CustomRegexMatcher().run());
    }

    @Test
    void notValidInputTest() {
        final String input_value = "@test_host.com";
        setInput(input_value);

        String result = new CustomRegexMatcher().run();

        removeFromOutput("Введите данные:");
        assertEquals("false", result);
        assertEquals("false", getOutputLines()[0]);
    }
}