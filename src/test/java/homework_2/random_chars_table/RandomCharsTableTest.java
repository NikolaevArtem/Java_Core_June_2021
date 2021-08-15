package homework_2.random_chars_table;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class RandomCharsTableTest extends UnitBase {

    public final String WELCOME_MESSAGE_TEST = "Welcome to the Random Chars Table Application";
    public final String ENTER_PARAM_MESSAGE_TEST = "Enter in one line 2 numbers and a line - " +
            "the length and width of the table / two-dimensional array," +
            " and the strategy (even or odd)";
    public final String ERROR_MESSAGE_TEST = "Passed parameters should match the format " +
            "[positive integer] [positive integer] [even|odd]";

    @Test
    void givenZeroAsArgument_whenRun_thenErrorMessage() {
        setInput("0 0 odd");
        new RandomCharsTable().run();
        printOut();
        removeFromOutput(WELCOME_MESSAGE_TEST);
        removeFromOutput(ENTER_PARAM_MESSAGE_TEST);
        assertEquals(ERROR_MESSAGE_TEST, getOutputLines()[0]);
    }

    @Test
    void givenEmptyArgument_whenRun_thenNoSuchElementException() {
        setInput("");
        assertThrows(NoSuchElementException.class, () -> new RandomCharsTable().run());
    }

    @Test
    void givenNegativeIntegerAsFirstArgument_whenRun_thenPrintErrorMessage() {
        setInput("-2 2 even");
        new RandomCharsTable().run();
        assertTrue(getOutput().contains(ERROR_MESSAGE_TEST));
    }

    @Test
    void givenNnegativeIntegerAsSecondArgument_whenRun_thenPrintErrorMessage() {
        setInput("2 -2 even");
        new RandomCharsTable().run();
        assertTrue(getOutput().contains(ERROR_MESSAGE_TEST));
    }

    @Test
    void givenWrongStrategy_whenRun_thenPrintErrorMessage() {
        setInput("2 2 wrongStrategy");
        new RandomCharsTable().run();
        assertTrue(getOutput().contains(ERROR_MESSAGE_TEST));
    }

    @Test
    void givenLetterAsFirstArgument_whenRun_thenPrintErrorMessage() {
        setInput("w 2 even");
        new RandomCharsTable().run();
        assertTrue(getOutput().contains(ERROR_MESSAGE_TEST));
    }

    @Test
    void givenLetterAsSecondrgument_whenRun_thenPrintErrorMessage() {
        setInput("2 W even");
        new RandomCharsTable().run();
        assertTrue(getOutput().contains(ERROR_MESSAGE_TEST));
    }

    @Test
    void givenDoubleAsFirstArgument_whenRun_thenPrintErrorMessage() {
        setInput("0.12345 2 even");
        new RandomCharsTable().run();
        assertTrue(getOutput().contains(ERROR_MESSAGE_TEST));
    }

    @Test
    void givenDoubleAsSecondArgument_whenRun_thenPrintErrorMessage() {
        setInput("2 0.12345 even");
        new RandomCharsTable().run();
        assertTrue(getOutput().contains(ERROR_MESSAGE_TEST));
    }

    @Test
    void givenMoreThanThreeArguments_whenRun_thenPrintErrorMessage() {
        setInput("1 2 3 odd");
        new RandomCharsTable().run();
        assertTrue(getOutput().contains(ERROR_MESSAGE_TEST));
    }

    @Test
    void givenLengthWidthEvenStrategy_whenRun_thenPrintEvenChars() {
        setInput("8 8 even");
        new RandomCharsTable().run();
        removeFromOutput("Even letters - ");
        removeFromOutput(",");
        removeFromOutput(" ");
        String str = getOutputLines()[getOutputLines().length - 1];
        for (int i = 0; i < str.length(); i++) {
            assertEquals(0, str.charAt(i) % 2);
        }
    }


    @Test
    void givenLengthWidthOddStrategy_whenRun_thenPrintOddChars() {
        setInput("8 8 odd");
        new RandomCharsTable().run();
        removeFromOutput("Odd letters - ");
        removeFromOutput(",");
        removeFromOutput(" ");
        String str = getOutputLines()[getOutputLines().length - 1];
        for (int i = 0; i < str.length(); i++) {
            assertEquals(1, str.charAt(i) % 2);
        }
    }


}