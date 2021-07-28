package homework_2;

import homework_2.random_chars_table.RandomCharsTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomCharsTableTest extends base.UnitBase {

    private final String ERROR_MESSAGE = "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";
    private final String START_MESSAGE = "Please, enter array length, array width and strategy (odd or even):";

    @Test
    void findOddTest() {
        setInput("2 3 odd");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        String oddChar = getOutputLines()[getOutputLines().length - 1];
        removeFromOutput(oddChar);
        oddChar = oddChar.replaceFirst("Odd letters - ", "");
        oddChar = oddChar.replaceAll(", ", "");
        for (char ch : oddChar.toCharArray()) {
            assertEquals((int) ch % 2, 1);
        }

        assertEquals(getOutputLines().length, 2);
        int oddCount = 0;
        for (String row : getOutputLines()) {
            row = row.replaceAll("\\|", "");
            for (char ch : row.toCharArray()) {
                assertTrue((65 <= (int) ch) && ((int) ch <= 91));
                if ((int) ch % 2 == 1) {
                    oddCount++;
                }
            }
        }
        assertEquals(oddCount, oddChar.toCharArray().length);
    }

    @Test
    void findEvenTest() {
        setInput("5 4 even");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        String evenChar = getOutputLines()[getOutputLines().length - 1];
        removeFromOutput(evenChar);
        evenChar = evenChar.replaceFirst("Even letters - ", "");
        evenChar = evenChar.replaceAll(", ", "");
        for (char ch : evenChar.toCharArray()) {
            assertEquals((int) ch % 2, 0);
        }

        assertEquals(getOutputLines().length, 5);
        int evenCount = 0;
        for (String row : getOutputLines()) {
            row = row.replaceAll("\\|", "");
            for (char ch : row.toCharArray()) {
                assertTrue((65 <= (int) ch) && ((int) ch <= 91));
                if ((int) ch % 2 == 0) {
                    evenCount++;
                }
            }
        }
        assertEquals(evenCount, evenChar.toCharArray().length);
    }

    @Test
    void biggerAmountOfArgumentsInputTest() {
        setInput("3 4 8 odd");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void smallerAmountOfArgumentsInputTest() {
        setInput("3 4");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void nullAndNegativeInputTest() {
        setInput("-3 0 even");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void unrecognizedStrategyTest() {
        setInput("3 8 hello");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void wrongNumberInputTest() {
        setInput("u and odd");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void tooBigNumberInputTest() {
        setInput("399372544437489926467 8 hello");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(ERROR_MESSAGE, getOutput());
    }
}
