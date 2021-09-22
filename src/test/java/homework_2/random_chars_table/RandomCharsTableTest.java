package homework_2.random_chars_table;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomCharsTableTest extends UnitBase {

    final String ERROR = "Passed parameters should match the" +
            " format [positive integer] [positive integer] [even|odd]";

    void removeOutputDifference() {
        removeFromOutput("RandomCharTable App.");
        removeFromOutput("Enter table length, width and strategy separated by a space:");
    }

    @Test
    void given23even_whenRun_thenReturnTableAndStrategy() {
        setInput("2 3 even");
        new RandomCharsTable().run();
        printOut();
        removeOutputDifference();
        assertTrue(getOutputLines()[0].matches("[|A-Z ]{7}"));
        assertTrue(getOutputLines()[1].matches("[|A-Z ]{7}"));
        assertTrue(getOutputLines()[2].startsWith("Even letters - "));
    }

    @Test
    void given45even_whenRun_thenReturnTableAndStrategy() {
        setInput("4 5 odd");
        new RandomCharsTable().run();
        printOut();
        removeOutputDifference();
        assertTrue(getOutputLines()[0].matches("[A-Z| ]{11}"));
        assertTrue(getOutputLines()[1].matches("[A-Z| ]{11}"));
        assertTrue(getOutputLines()[2].matches("[A-Z| ]{11}"));
        assertTrue(getOutputLines()[3].matches("[A-Z| ]{11}"));
        assertTrue(getOutputLines()[4].startsWith("Odd letters - "));
    }

    @Test
    void givenZero_whenRun_thenReturnError() {
        setInput("0 1 even");
        new RandomCharsTable().run();
        printOut();
        removeOutputDifference();
        assertEquals(ERROR, getOutput());
    }

    @Test
    void givenString_whenRun_thenReturnError() {
        setInput("23odd");
        new RandomCharsTable().run();
        printOut();
        removeOutputDifference();
        assertEquals(ERROR, getOutput());
    }

    @Test
    void givenNonFormat_whenRun_thenReturnOver() {
        setInput("2 3 all");
        new RandomCharsTable().run();
        printOut();
        removeOutputDifference();
        assertEquals(ERROR, getOutput());
    }

    @Test
    void givenNegative_whenRun_thenReturnError() {
        setInput("-1 2 odd");
        new RandomCharsTable().run();
        printOut();
        removeOutputDifference();
        assertEquals(ERROR, getOutput());
    }

    @Test
    void given2parameters_whenRun_thenReturnError() {
        setInput("2 4");
        new RandomCharsTable().run();
        printOut();
        removeOutputDifference();
        assertEquals(ERROR, getOutput());
    }

    @Test
    void given4parameters_whenRun_thenReturnError() {
        setInput("2 4 even 3");
        new RandomCharsTable().run();
        printOut();
        removeOutputDifference();
        assertEquals(ERROR, getOutput());
    }

    @Test
    void givenEmpty_whenRun_thenReturnError() {
        setInput("");
        new RandomCharsTable().run();
        printOut();
        removeOutputDifference();
        assertEquals(ERROR, getOutput());
    }
}