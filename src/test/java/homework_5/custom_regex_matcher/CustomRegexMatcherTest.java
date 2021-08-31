package homework_5.custom_regex_matcher;

import base.UnitBase;
import homework_4.custom_file_reader.CustomFileReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomRegexMatcherTest extends UnitBase {

    @Test
    void givenNull_whenRun_thenException() {

        Exception exception = assertThrows(NullPointerException.class, () -> {
            setInput(null);
            new CustomRegexMatcher().run();
        });

    }

    @Test
    void givenEmpty_whenRun_thenFalse() {
        setInput("");

        new CustomRegexMatcher().run();
        printOut();

        assertEquals("false", getOutputLines()[0]);
    }


    @Test
    void givenString_whenRun_thenFalse() {
        setInput("not a node");

        new CustomRegexMatcher().run();
        printOut();

        assertEquals("false", getOutputLines()[0]);
    }

    @Test
    void givenNode_whenRun_thenTrue() {
        setInput("<from>Jani</from>");

        new CustomRegexMatcher().run();
        printOut();

        assertEquals("true", getOutputLines()[0]);
    }


}
