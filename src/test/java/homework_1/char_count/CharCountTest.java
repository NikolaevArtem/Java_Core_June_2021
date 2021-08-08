package homework_1.char_count;

import base.UnitBase;
import homework_1.Main;
import org.junit.jupiter.api.Test;

import static homework_1.CharCount.ANSI_RED;
import static homework_1.CharCount.ANSI_RESET;
import static org.junit.jupiter.api.Assertions.*;

class CharCountTest extends UnitBase {
    @Test
    void givenError_whenRun_thenExpected() {
        String[] args = {"some", "new", "word", "and", "error"};
        Main.main(args);
        printOut();
        assertEquals("some: 4 letters", getOutputLines()[0]);
        assertEquals("new: 3 letters", getOutputLines()[1]);
        assertEquals("word: 4 letters", getOutputLines()[2]);
        assertEquals("and: 3 letters", getOutputLines()[3]);
        assertEquals(ANSI_RED + "Alarm!" + ANSI_RESET, getOutputLines()[4]);
    }

    @Test
    void givenNoError_whenRun_thenExpected() {
        String[] args = {"some", "new", "word", "and", "no error"};
        Main.main(args);
        printOut();
        assertEquals("some: 4 letters", getOutputLines()[0]);
        assertEquals("new: 3 letters", getOutputLines()[1]);
        assertEquals("word: 4 letters", getOutputLines()[2]);
        assertEquals("and: 3 letters", getOutputLines()[3]);
        assertEquals("no error: 8 letters", getOutputLines()[4]);
    }

    @Test
    void givenZeroArguments_whenRun_thenExpected() {
        String[] args = {};
        Main.main(args);
        printOut();
        assertEquals("", getOutputLines()[0]);
    }
}