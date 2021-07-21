package homework_2.random_chars_table;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class RandomCharsTableTest extends UnitBase {
    @Test
    void InputZeroAsArgument() {
        setInput("0");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]", getOutputLines()[0]);
    }

    @Test
    void InputEmptyArgument() {
        setInput("");
        assertThrows(NoSuchElementException.class, () -> new RandomCharsTable().run());
    }

    /*
        for this test use new RandomCharsTable().setDebug(true).run();
        3 3 odd
        | K | N | W |
        | N | E | E |
        | J | G | D |
        Even letters - N, N, J, D
     */
    @Test
    void InputValidEvenArguments() {
        setInput("3 3 even");

        new RandomCharsTable().setDebug(true).run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("| K | N | W |", getOutputLines()[0]);
        assertEquals("| N | E | E |", getOutputLines()[1]);
        assertEquals("| J | G | D |", getOutputLines()[2]);
        assertEquals("Even letters - N, N, J, D", getOutputLines()[3]);
    }

    /*
        for this test use new RandomCharsTable().setDebug(true).run();
        3 3 odd
        | K | N | W |
        | N | E | E |
        | J | G | D |
        odd letters - K, W, E, E, G
     */
    @Test
    void InputValidOddArguments() {
        setInput("3 3 odd");

        new RandomCharsTable().setDebug(true).run();
        printOut();
        removeFromOutput("Введите данные:");
        assertEquals("| K | N | W |", getOutputLines()[0]);
        assertEquals("| N | E | E |", getOutputLines()[1]);
        assertEquals("| J | G | D |", getOutputLines()[2]);
        assertEquals("Odd letters - K, W, E, E, G", getOutputLines()[3]);
    }

    @Test
    void InputFourRowsThreeColumnsAsArgument() {
        setInput("4 3 odd");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput("Введите данные:");
        assertTrue(getOutputLines()[0].matches("(\\|\\s[A-Z]\\s){3}\\|"));
        assertTrue(getOutputLines()[1].matches("(\\|\\s[A-Z]\\s){3}\\|"));
        assertTrue(getOutputLines()[2].matches("(\\|\\s[A-Z]\\s){3}\\|"));
        assertTrue(getOutputLines()[3].matches("(\\|\\s[A-Z]\\s){3}\\|"));
    }


    // дальше тесты уродливы, но как иначе распарсить эти строки и сравнить все я не знаю
    @Test
    void InputCheckStrategyEven() {
        final int ROWS = 3;
        final int COLUMNS = 4;
        final String STRATEGY = "even";
        final String input = "" + ROWS + " " + COLUMNS + " " + STRATEGY;

        setInput(input);

        new RandomCharsTable().run();
        printOut();
        removeFromOutput("Введите данные:");

        final String[] strategyRow = getOutputLines()[ROWS].trim().split(" - ");
        final char[] evenCharsInAnswerRow = strategyRow[1].trim().replaceAll(", ","").toCharArray();
        StringBuffer charsInTable = new StringBuffer();
        for (int i = 0; i < ROWS; i++){
            charsInTable.append(getOutputLines()[i].trim().replaceAll("\\|", "").replace(" ", ""));
        }

        for (char c : evenCharsInAnswerRow) {
            assertEquals(0, c % 2);
            assertNotEquals(-1, charsInTable.indexOf("" + c));
        }
        assertEquals("Even letters", strategyRow[0]);
    }


    // дальше тесты уродливы, но как иначе распарсить эти строки и сравнить все я не знаю
    @Test
    void InputCheckStrategyOdd() {
        final int ROWS = 5;
        final int COLUMNS = 4;
        final String STRATEGY = "odd";
        final String input = "" + ROWS + " " + COLUMNS + " " + STRATEGY;

        setInput(input);

        new RandomCharsTable().run();
        printOut();
        removeFromOutput("Введите данные:");

        final String[] strategyRow = getOutputLines()[ROWS].trim().split(" - ");
        final char[] oddCharsInAnswerRow = strategyRow[1].trim().replaceAll(", ","").toCharArray();

        StringBuffer charsInTable = new StringBuffer();
        for (int i = 0; i < ROWS; i++){
            charsInTable.append(getOutputLines()[i].trim().replaceAll("\\|", "").replace(" ", ""));
        }

        for (char c : oddCharsInAnswerRow) {
            assertEquals(1, c % 2);
            assertNotEquals(-1, charsInTable.indexOf("" + c));
        }
        assertEquals("Odd letters", strategyRow[0]);
    }
}