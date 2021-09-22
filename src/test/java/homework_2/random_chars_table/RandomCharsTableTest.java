package homework_2.random_chars_table;

import base.UnitBase;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomCharsTableTest extends UnitBase {

    final String tableRegex = "(\\| [A-Z] \\|?)+";
    final String oddLettersRegex = "Odd letters - ([ACEGIKMOQSUWY],? ?)+";
    final String evenLettersRegex = "Even letters - ([^ACEGIKMOQSUWY],? ?)+";

    @Test
    public void givenOdd55_whenRun_thenPrintResult() {
        setInput("5 5 odd");
        new RandomCharsTable().run();
        removeFromOutput(RandomCharsTable.GREETING);
        final String[] out = getOutputLines();
        for (int i = 0; i < out.length - 1; i++) {
            assertTrue(out[i].matches(tableRegex));
        }
        assertTrue(out[out.length - 1].matches(oddLettersRegex));
        assertFalse(out[out.length - 1].matches(evenLettersRegex));
    }

    @Test
    public void givenEven55_whenRun_thenPrintResult() {
        setInput("5 5 even");
        new RandomCharsTable().run();
        removeFromOutput(RandomCharsTable.GREETING);
        final String[] out = getOutputLines();
        for (int i = 0; i < out.length - 1; i++) {
            assertTrue(out[i].matches(tableRegex));
        }
        assertTrue(out[out.length - 1].matches(evenLettersRegex));
        assertFalse(out[out.length - 1].matches(oddLettersRegex));
    }

    @Test
    public void givenEven15_whenRun_thenPrintResult() {
        setInput("1 5 even");
        new RandomCharsTable().run();
        removeFromOutput(RandomCharsTable.GREETING);
        final String[] out = getOutputLines();
        for (int i = 0; i < out.length - 1; i++) {
            assertTrue(out[i].matches(tableRegex));
        }
        assertTrue(out[out.length - 1].matches(evenLettersRegex));
    }

    @Test
    public void givenEven01_whenRun_thenPrintErrorMessage() {
        setInput("0 1 even");
        new RandomCharsTable().run();
        removeFromOutput(RandomCharsTable.GREETING);
        assertEquals(RandomCharsTable.ERROR, getOutputLines()[0]);
    }

    @Test
    public void givenStrings_whenRun_thenPrintErrorMessage() {
        setInput("asd asd even");
        new RandomCharsTable().run();
        removeFromOutput(RandomCharsTable.GREETING);
        assertEquals(RandomCharsTable.ERROR, getOutputLines()[0]);
    }

    @Test
    public void givenOnlyOneParameter_whenRun_thenPrintErrorMessage() {
        setInput("1");
        new RandomCharsTable().run();
        removeFromOutput(RandomCharsTable.GREETING);
        assertEquals(RandomCharsTable.ERROR, getOutputLines()[0]);
    }

    @Test
    public void givenOnlyTwoParameters_whenRun_thenPrintErrorMessage() {
        setInput("1 2");
        new RandomCharsTable().run();
        removeFromOutput(RandomCharsTable.GREETING);
        assertEquals(RandomCharsTable.ERROR, getOutputLines()[0]);
    }

    @Test
    public void givenMoreThanThree_whenRun_thenPrintErrorMessage() {
        setInput("1 2 odd 12");
        new RandomCharsTable().run();
        removeFromOutput(RandomCharsTable.GREETING);
        assertEquals(RandomCharsTable.ERROR, getOutputLines()[0]);
    }

    @Test
    public void givenWrongStrategy_whenRun_thenPrintErrorMessage() {
        setInput("1 2 all");
        new RandomCharsTable().run();
        removeFromOutput(RandomCharsTable.GREETING);
        assertEquals(RandomCharsTable.ERROR, getOutputLines()[0]);
    }

    @Test
    public void givenNegativeInt_whenRun_thenPrintErrorMessage() {
        setInput("-5 2 even");
        new RandomCharsTable().run();
        removeFromOutput(RandomCharsTable.GREETING);
        assertEquals(RandomCharsTable.ERROR, getOutputLines()[0]);
    }

    @Test
    public void givenEven11_whenRun_thenPrintResultIfNoEvenLetters() {
        final String noLetters = "There are no even letters in the table";
        String[] lastLines = new String[30];
        for (int i = 0; i < lastLines.length; i++) {
            ByteArrayOutputStream mockedOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(mockedOut));
            String input = "1 1 even";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            new RandomCharsTable().run();
            lastLines[i] = mockedOut.toString().trim().split("\r?\n")[2];
        }
        Arrays.sort(lastLines);
        assertEquals(noLetters, lastLines[lastLines.length - 1]);
    }
}
