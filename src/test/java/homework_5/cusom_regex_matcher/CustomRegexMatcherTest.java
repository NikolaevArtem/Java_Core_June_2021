package homework_5.cusom_regex_matcher;

import base.UnitBase;
import homework_5.custom_regex_matcher.CustomRegexMatcher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomRegexMatcherTest extends UnitBase {
    private void run() {
        new CustomRegexMatcher().run();
        printOut();
        removeFromOutput("Input your address: ");
    }

    @Test
    void givenValidAddress_whenRun_thenTrue() {
        setInput("Barisov pereulok 23");

        run();

        assertEquals("true", getOutputLines()[0]);
    }

    @Test
    void givenValidInputKorpus_whenRun_thenTrue() {
        setInput("Barisov pereulok 23/1");

        run();

        assertEquals("true", getOutputLines()[0]);
    }

    @Test
    void givenInvalidInput_whenRun_thenFalse() {
        setInput("23 Barisov pereulok");

        run();

        assertEquals("false", getOutputLines()[0]);
    }

    @Test
    void givenEmptyAddress_whenRun_thenFalse() {
        setInput(" ");

        run();

        assertEquals("false", getOutputLines()[0]);
    }

}