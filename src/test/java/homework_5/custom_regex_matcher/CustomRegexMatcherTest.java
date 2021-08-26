package homework_5.custom_regex_matcher;

import base.UnitBase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomRegexMatcherTest extends UnitBase {

    @Test
    public void givenMatching1_whenRun_thenPrintTrue() {
        setInput("allzza4279@gmail.com");
        CustomRegexMatcher.run();
        printOut();
        removeFromOutput("Please, enter your string...");

        assertEquals("true",getOutput());
    }

    @Test
    public void givenMatching2_whenRun_thenPrintTrue() {
        setInput("dimatroshkin@mail.ru");
        CustomRegexMatcher.run();
        printOut();
        removeFromOutput("Please, enter your string...");

        assertEquals("true",getOutput());
    }

    @Test
    public void givenNonMatching1_whenRun_thenPrintFalse() {
        setInput("my email is: dimatroshkin@mail.ru");
        CustomRegexMatcher.run();
        printOut();
        removeFromOutput("Please, enter your string...");

        assertEquals("false",getOutput());
    }

    @Test
    public void givenNonMatching2_whenRun_thenPrintFalse() {
        setInput("/.epof@.rert.surr");
        CustomRegexMatcher.run();
        printOut();
        removeFromOutput("Please, enter your string...");

        assertEquals("false",getOutput());
    }
}
