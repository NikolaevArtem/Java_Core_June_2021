package homework_2_test.random_chars_table;

import base.UnitBase;

import homework_2.random_chars_table.RandomCharsTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomCharsTableTest extends UnitBase {

    private final String errorMsg = "Passed parameters should match the format " +
                                    "[positive integer] [positive integer] [even|odd]";

    @Test
    void givenTwoTwoOdd_whenRun_thenPrintTableAndLetters() {
        setInput("2 2 odd");
        new RandomCharsTable().run();

        removeFromOutput("Enter length, width of the table and choose even or odd letters: ");

        for (int i = 0; i < 2; i++) {
            String[] letters = getOutputLines()[i].split("\\|");
            for (int j = 1; j < 3; j++) {
                char ch = letters[j].trim().charAt(0);
                assertTrue(ch >= 65 && ch <= 90);
            }
        }

        String lineOfLetters = getOutputLines()[2];
        lineOfLetters = lineOfLetters.replace("odd letters - ", "");
        String[] oddLetters = lineOfLetters.split(", ");
        for (String oddLetter : oddLetters) {
            char ch = oddLetter.charAt(0);
            assertTrue(ch >= 65 && ch <= 90);
            assertEquals(1, ch % 2);
        }
    }

    @Test
    void givenTwoTwoEven_whenRun_thenPrintTableAndLetters() {
        setInput("2 2 even");
        new RandomCharsTable().run();

        removeFromOutput("Enter length, width of the table and choose even or odd letters: ");

        for (int i = 0; i < 2; i++) {
            String[] letters = getOutputLines()[i].split("\\|");
            for (int j = 1; j < 3; j++) {
                char ch = letters[j].trim().charAt(0);
                assertTrue(ch >= 65 && ch <= 90);
            }
        }

        String lineOfLetters = getOutputLines()[2];
        lineOfLetters = lineOfLetters.replace("even letters - ", "");
        String[] evenLetters = lineOfLetters.split(", ");
        for (String evenLetter : evenLetters) {
            char ch = evenLetter.charAt(0);
            assertTrue(ch >= 65 && ch <= 90);
            assertEquals(0, ch % 2);
        }
    }

    @Test
    void givenValidInputWithExtraSpaces_whenRun_thenPrintTableAndLetters() {
        setInput(" 2  2  even ");
        new RandomCharsTable().run();

        removeFromOutput("Enter length, width of the table and choose even or odd letters: ");

        for (int i = 0; i < 2; i++) {
            String[] letters = getOutputLines()[i].split("\\|");
            for (int j = 1; j < 3; j++) {
                char ch = letters[j].trim().charAt(0);
                assertTrue(ch >= 65 && ch <= 90);
            }
        }

        String lineOfLetters = getOutputLines()[2];
        lineOfLetters = lineOfLetters.replace("even letters - ", "");
        String[] evenLetters = lineOfLetters.split(", ");
        for (String evenLetter : evenLetters) {
            char ch = evenLetter.charAt(0);
            assertTrue(ch >= 65 && ch <= 90);
            assertEquals(0, ch % 2);
        }
    }

    @Test
    void givenZeroTwoOdd_whenRun_thenErrorMessage() {
        setInput("0 2 odd");
        new RandomCharsTable().run();

        removeFromOutput("Enter length, width of the table and choose even or odd letters: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenTwoZeroOdd_whenRun_thenErrorMessage() {
        setInput("2 0 odd");
        new RandomCharsTable().run();

        removeFromOutput("Enter length, width of the table and choose even or odd letters: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenMinusOneTwoOdd_whenRun_thenErrorMessage() {
        setInput("-1 2 odd");
        new RandomCharsTable().run();

        removeFromOutput("Enter length, width of the table and choose even or odd letters: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenTwoMinusOneOdd_whenRun_thenErrorMessage() {
        setInput("2 -1 odd");
        new RandomCharsTable().run();

        removeFromOutput("Enter length, width of the table and choose even or odd letters: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenThreeInts_whenRun_thenErrorMessage() {
        setInput("2 2 2");
        new RandomCharsTable().run();

        removeFromOutput("Enter length, width of the table and choose even or odd letters: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenTwoTwoInvalidWord_whenRun_thenErrorMessage() {
        setInput("2 2 cat");
        new RandomCharsTable().run();

        removeFromOutput("Enter length, width of the table and choose even or odd letters: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenFloatingPointTwoOdd_whenRun_thenErrorMessage() {
        setInput("2.0 2 odd");
        new RandomCharsTable().run();

        removeFromOutput("Enter length, width of the table and choose even or odd letters: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenTwoOdd_whenRun_thenErrorMessage() {
        setInput("2 odd");
        new RandomCharsTable().run();

        removeFromOutput("Enter length, width of the table and choose even or odd letters: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenNoIntsOdd_whenRun_thenErrorMessage() {
        setInput("odd");
        new RandomCharsTable().run();

        removeFromOutput("Enter length, width of the table and choose even or odd letters: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenTwoTwoNoWord_whenRun_thenErrorMessage() {
        setInput("2 2");
        new RandomCharsTable().run();

        removeFromOutput("Enter length, width of the table and choose even or odd letters: ");

        assertEquals(errorMsg, getOutput());
    }

    @Test
    void givenTwoTwoOddExtraWord_whenRun_thenErrorMessage() {
        setInput("2 2 odd cat");
        new RandomCharsTable().run();

        removeFromOutput("Enter length, width of the table and choose even or odd letters: ");

        assertEquals(errorMsg, getOutput());
    }
}