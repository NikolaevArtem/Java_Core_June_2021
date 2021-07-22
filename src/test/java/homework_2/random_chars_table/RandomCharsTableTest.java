package homework_2.random_chars_table;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Random;

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
    void InputRandomRowsAndColumnsAsArgument() {
        final String STRATEGY = "even";
        final int ROWS = 1 + new Random().nextInt(20);
        final int COLUMNS = 1 + new Random().nextInt(20);
        final String input = "" + ROWS + " " + COLUMNS + " " + STRATEGY;

        setInput(input);

        new RandomCharsTable().run();
        printOut();
        removeFromOutput("Введите данные:");
        for (int i = 0; i < ROWS; i++)
        assertTrue(getOutputLines()[i].matches("(\\|\\s[A-Z]\\s){" + COLUMNS + "}\\|"));
    }

    // дальше тест уродлив, но как иначе распарсить эти строки и сравнить все я не знаю
    // за то покрывает все варианты.
    @Test
    void InputRandomCheckStrategy() {
        final boolean isOdd = new Random().nextBoolean();

        final int ROWS = 1 + new Random().nextInt(20);
        final int COLUMNS = 1 + new Random().nextInt(20);

        final String STRATEGY;
        final char testChar;  // добавим точно валидное значение, что бы быть уверенным в тесте

        if (isOdd) {
            STRATEGY = "Odd";
            testChar = 91;

        } else {
            STRATEGY = "Even";
            testChar = 92;
        }

        final String input = "" + ROWS + " " + COLUMNS + " " + STRATEGY.toLowerCase();

        setInput(input);

        new RandomCharsTable().run();
        printOut();
        removeFromOutput("Введите данные:");

        final String[] strategyRow = getOutputLines()[ROWS].trim().split(" - ");
        final char[] charsInAnswerRow =
                (strategyRow[1].replaceAll(",|\\s","") + testChar).toCharArray();

        StringBuilder charsInTable = new StringBuilder();
        for (int i = 0; i < ROWS; i++){
            charsInTable.append(getOutputLines()[i].replaceAll("\\||\\s" , ""));
        }

        charsInTable.append(testChar);

        for (char aChar : charsInAnswerRow) {
            assertEquals(testChar % 2, aChar % 2);
            assertNotEquals(-1, charsInTable.indexOf("" + aChar));
        }
        assertEquals(STRATEGY + " letters", strategyRow[0]);
    }
}