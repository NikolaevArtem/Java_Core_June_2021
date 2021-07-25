package homework_2.random_chars_table;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.Constants.ERROR_MESSAGE_RANDOM_CHARS_TABLE;
import static utils.Constants.INFO_MESSAGE_RANDOM_CHARS_TABLE;
import static utils.Constants.MAX_CHAR;
import static utils.Constants.MIN_CHAR;


public class RandomCharsTableTest extends UnitBase {

    void run() {
        new RandomCharsTable().run();
        removeFromOutput(INFO_MESSAGE_RANDOM_CHARS_TABLE);
        printOut();
    }

    @Test
    void testPrintAlphabetChars() {
        setInput("1 2 odd");
        run();
        removeFromOutput("Odd letters - ");
        removeFromOutput("|");
        removeFromOutput("\n");
        getOutput().replace(",", "|");
        String[] chars = getOutput().split("|");
        assertTrue(chars[0].charAt(0) >= MIN_CHAR && chars[0].charAt(0) <= MAX_CHAR);
        assertTrue(chars[1].charAt(0) >= MIN_CHAR && chars[1].charAt(0) <= MAX_CHAR);
        assertTrue(chars[2].charAt(0) >= MIN_CHAR && chars[2].charAt(0) <= MAX_CHAR);
    }

    @Test
    void givenOddStrategy_whenRun_thenPrintOddChars() {
        setInput("2 8 odd");
        run();
        removeFromOutput("Odd letters - ");
        List<String> letters = new ArrayList<>();
        if (getOutputLines()[getOutputLines().length - 1].contains(",")) {
            letters = Arrays.asList(getOutputLines()[getOutputLines().length - 1].split(", "));
        } else {
            letters.add(getOutputLines()[2]);
        }
        for (String s : letters) {
            char ch = s.charAt(0);
            assertNotEquals(ch % 2, 0);
        }
    }

    @Test
    void givenEvenStrategy_whenRun_thenPrintEvenChars() {
        setInput("7 5 even");
        run();
        removeFromOutput("Even letters - ");
        List<String> letters = new ArrayList<>();
        if (getOutputLines()[getOutputLines().length - 1].contains(",")) {
            letters = Arrays.asList(getOutputLines()[getOutputLines().length - 1].split(", "));
        } else {
            letters.add(getOutputLines()[2]);
        }
        for (String s : letters) {
            char ch = s.charAt(0);
            assertEquals(ch % 2, 0);
        }
    }

    @Test
    void givenNaN_whenRun_thenPrintNotIntegerMessage() {
        setInput("word 1 even");
        run();
        assertEquals(ERROR_MESSAGE_RANDOM_CHARS_TABLE, getOutput());
    }

    @Test
    void given2ndNaN_whenRun_thenPrintNotIntegerMessage() {
        setInput("1 word odd");
        run();
        assertEquals(ERROR_MESSAGE_RANDOM_CHARS_TABLE, getOutput());
    }

    @Test
    void givenWrongStrategy_whenRun_thenPrintNotIntegerMessage() {
        setInput("1 3 5");
        run();
        assertEquals(ERROR_MESSAGE_RANDOM_CHARS_TABLE, getOutput());
    }
}
