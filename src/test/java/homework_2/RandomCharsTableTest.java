package homework_2;

import base.UnitBase;
import homework_2.random_chars_table.RandomCharsTable;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomCharsTableTest extends UnitBase {
    private final String ERROR_MSG = "Passed parameters should match the format " +
            "[positive integer] [positive integer] [even|odd]";

    @Test
    void given3_3_even_whenRunRandomCharsTable_thenPrinting3rowTable() {
        final int row = 3;
        final int column = 3;
        final String strategy = "even";

        setInput(row + " " + column + " " + strategy);

        new RandomCharsTable().run();
        printOut();

        final String[] actual = getOutputLines();

        assertEquals(row, actual.length - 1);
    }

    @Test
    void given4_8_even_whenRunRandomCharsTable_thenPrinting8columnTable() {
        final int row = 4;
        final int column = 8;
        final String strategy = "even";

        setInput(row + " " + column + " " + strategy);

        new RandomCharsTable().run();
        printOut();

        final String[] actual = getOutputLines();

        assertEquals(column, charsInRow(0, actual).size());
    }

    @Test
    void given5_2_even_whenRunRandomCharsTable_thenPrintingTableWith10Chars() {
        final int row = 5;
        final int column = 2;
        final String strategy = "even";

        setInput(row + " " + column + " " + strategy);

        new RandomCharsTable().run();
        printOut();

        final String[] actual = getOutputLines();

        assertEquals(row * column, charsInTable(actual, row).size());
    }

    @Test
    void given4_7_even_whenRunRandomCharsTable_thenPrintingEvenCharsCorrectly() {
        final int row = 4;
        final int column = 7;
        final String strategy = "even";

        setInput(row + " " + column + " " + strategy);

        new RandomCharsTable().run();
        printOut();

        final String[] table = getOutputLines();

        final Set<String> actualEvens = parseToSet(table[table.length - 1].substring(14).replace(" ", "").replace(",", ""));
        final Set<String> expectedEvens = getEvens(charsInTable(table, row));

        assertEquals(expectedEvens, actualEvens);
    }

    @Test
    void given12_1_odd_whenRunRandomCharsTable_thenPrintingOddCharsCorrectly() {
        final int row = 12;
        final int column = 1;
        final String strategy = "odd";

        setInput(row + " " + column + " " + strategy);

        new RandomCharsTable().run();
        printOut();

        final String[] table = getOutputLines();

        final Set<String> actualOdds = parseToSet(table[table.length - 1].substring(13).replace(" ", "").replace(",", ""));
        final Set<String> expectedOdds = getOdds(charsInTable(table, row));

        assertEquals(expectedOdds, actualOdds);
    }

    @Test
    void given1_0_odd_whenRunRandomCharsTable_thenPrintingErrorMsg() {
        final int row = 1;
        final int column = 0;
        final String strategy = "odd";

        setInput(row + " " + column + " " + strategy);

        new RandomCharsTable().run();
        printOut();

        final String actual = getOutputLines()[0];

        assertEquals(ERROR_MSG, actual);
    }

    @Test
    void givenNegative_1_odd_whenRunRandomCharsTable_thenPrintingErrorMsg() {
        final int row = -10;
        final int column = 1;
        final String strategy = "odd";

        setInput(row + " " + column + " " + strategy);

        new RandomCharsTable().run();
        printOut();

        final String actual = getOutputLines()[0];

        assertEquals(ERROR_MSG, actual);
    }

    @Test
    void given6_1_hi_whenRunRandomCharsTable_thenPrintingErrorMsg() {
        final int row = 6;
        final int column = 1;
        final String strategy = "hi";

        setInput(row + " " + column + " " + strategy);

        new RandomCharsTable().run();
        printOut();

        final String actual = getOutputLines()[0];

        assertEquals(ERROR_MSG, actual);
    }

    @Test
    void givenHello_whenRunRandomCharsTable_thenPrintingErrorMsg() {
        setInput("Hello");

        new RandomCharsTable().run();
        printOut();

        final String actual = getOutputLines()[0];

        assertEquals(ERROR_MSG, actual);
    }

    @Test
    void givenEmptyString_whenRunRandomCharsTable_thenPrintingErrorMsg() {
        setInput("");

        new RandomCharsTable().run();
        printOut();

        final String actual = getOutputLines()[0];

        assertEquals(ERROR_MSG, actual);
    }

    private List<Character> charsInRow(int row, String[] table) {
        List<Character> chars = new ArrayList<>();

        for (char c : table[row].toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                chars.add(c);
            }
        }
        return chars;
    }

    private List<Character> charsInTable(String[] table, int rows) {
        List<Character> chars = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            chars.addAll(charsInRow(i, table));
        }

        return chars;
    }

    private Set<String> getEvens(List<Character> chars) {
        Set<String> evens = new HashSet<>();

        for (char c : chars) {
            if (isEven(c)) {
                evens.add(c + "");
            }
        }
        return evens;
    }

    private Set<String> getOdds(List<Character> chars) {
        Set<String> odds = new HashSet<>();

        for (char c : chars) {
            if (!isEven(c)) {
                odds.add(c + "");
            }
        }
        return odds;
    }

    private boolean isEven(char c) {
        return c % 2 == 0;
    }

    private Set<String> parseToSet(String str) {
        Set<String> chars = new HashSet<>();

        for (char c: str.toCharArray()) {
            chars.add(c + "");
        }
        return chars;
    }
}
