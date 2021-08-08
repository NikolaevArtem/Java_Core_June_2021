package homework_2.random_chars_table;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomCharsTableTest extends UnitBase {

    @Test
    void EmptyInputTest() {
        setInput("");

        new RandomCharsTable().run();
        removeFromOutput("Please type size of a table: 2 numbers and strategy - even or odd:");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]",
                getOutputLines()[0]);
    }

    @Test
    void NullSizeInputTest() {
        setInput("0 0 odd");

        new RandomCharsTable().run();
        removeFromOutput("Please type size of a table: 2 numbers and strategy - even or odd:");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]",
                getOutputLines()[0]);
    }

    @Test
    void NegativeInputTest() {
        setInput("-3 4 even");

        new RandomCharsTable().run();
        removeFromOutput("Please type size of a table: 2 numbers and strategy - even or odd:");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]",
                getOutputLines()[0]);
    }

    @Test
    void WrongStrategyInputTest() {
        setInput("3 4 fghgfhgfh");

        new RandomCharsTable().run();
        removeFromOutput("Please type size of a table: 2 numbers and strategy - even or odd:");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]",
                getOutputLines()[0]);
    }

    @Test
    void OnlyStringInputTest() {
        setInput("hello");

        new RandomCharsTable().run();
        removeFromOutput("Please type size of a table: 2 numbers and strategy - even or odd:");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]",
                getOutputLines()[0]);
    }

    @Test
    void WrongNumberOfParamsInputTest() {
        setInput("123");

        new RandomCharsTable().run();
        removeFromOutput("Please type size of a table: 2 numbers and strategy - even or odd:");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]",
                getOutputLines()[0]);
    }
}
