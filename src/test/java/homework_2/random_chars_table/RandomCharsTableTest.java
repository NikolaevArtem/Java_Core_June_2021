package homework_2.random_chars_table;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.Constants.ERROR_MESSAGE_RANDOM_CHARS_TABLE;
import static utils.Constants.INFO_MESSAGE_RANDOM_CHARS_TABLE;


public class RandomCharsTableTest extends UnitBase {

    void run() {
        new RandomCharsTable().run();
        removeFromOutput(INFO_MESSAGE_RANDOM_CHARS_TABLE);
        printOut();
    }

    @Test
    void given2Columns1Row_whenRun_thenPrintRandomCharsTable() {
        setInput("2 1 odd");
        run();
        assertEquals(5, getOutputLines()[0].length());
    }

    @Test
    void given2Rows2ColumnsOdd_whenRun_thenPrintRandomCharsTable() {
        String input = "2 2 odd";
        setInput(input);
        char[] charArray = {'A', 'B', 'C', 'D'};
        new RandomCharsTable().debug(input, charArray);
        removeFromOutput("Odd letters - ");
        assertEquals("|A|B|\n|C|D|\nA, C", getOutput());
    }

    @Test
    void given3Rows2ColumnsEven_whenRun_thenPrintRandomCharsTable() {
        String input ="3 2 even";
        setInput(input);
        char[] charArray = {'A', 'B', 'C', 'D'};
        new RandomCharsTable().debug(input, charArray);
        removeFromOutput("Even letters - ");
        assertEquals("|A|B|\n|C|D|\n|A|B|\nB, D", getOutput());
    }

    @Test
    void given1stNaN_whenRun_thenPrintNotIntegerMessage() {
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
