package homework_2.random_chars_table;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static homework_2.random_chars_table.utils.MessageType.INFO_MESSAGE_FOR_COLUMNS;
import static homework_2.random_chars_table.utils.MessageType.INFO_MESSAGE_FOR_ROWS;
import static homework_2.random_chars_table.utils.MessageType.INFO_MESSAGE_FOR_STRATEGY;
import static homework_2.random_chars_table.utils.MessageType.INTEGER_ERROR_MESSAGE;
import static homework_2.random_chars_table.utils.MessageType.STRATEGY_ERROR_MESSAGE;
import static java.lang.System.lineSeparator;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RandomCharsTableTest extends UnitBase {

    void setInput(String[] args) {
        StringBuilder input = new StringBuilder();
        for(String s: args) {
            input.append(s).append(lineSeparator());
        }
        super.setInput(input.substring(0, input.length()-1));
    }

    void run() {
        new RandomCharsTable().start();
        removeFromOutput(INFO_MESSAGE_FOR_COLUMNS.getMessage());
        removeFromOutput(INFO_MESSAGE_FOR_ROWS.getMessage());
        removeFromOutput(INFO_MESSAGE_FOR_STRATEGY.getMessage());
        printOut();
    }

    @Test
    void given1Row2Columns_whenRun_thenPrintRandomCharsTable() {
        String[] lines = {"2", "1", "odd"};
        setInput(lines);
        run();
        assertEquals(5, getOutputLines()[0].length());
    }

    @Test
    void given1stNaN_whenRun_thenPrintNotIntegerMessage() {
        String[] lines = {"word", "1", "even"};
        setInput(lines);
        run();
        assertEquals(INTEGER_ERROR_MESSAGE.getMessage(), getOutput());
    }

    @Test
    void given2ndNaN_whenRun_thenPrintNotIntegerMessage() {
        String[] lines = {"1", "word", "odd"};
        setInput(lines);
        run();
        assertEquals(INTEGER_ERROR_MESSAGE.getMessage(), getOutput());
    }

    @Test
    void givenWrongStrategy_whenRun_thenPrintNotIntegerMessage() {
        String[] lines = {"1", "3", "5"};
        setInput(lines);
        run();
        assertEquals(STRATEGY_ERROR_MESSAGE.getMessage(), getOutput());
    }
}
