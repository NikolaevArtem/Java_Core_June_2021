package homework_2.random_chars_printer;

import base.UnitBase;
import homework_2.random_chars_table.RandomCharsTable;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomCharsPrinter extends UnitBase {

    @Test
    public void testInput2x2Odd() throws IOException {
        setInput("2 2 odd");

        RandomCharsTable randomCharsTable = new RandomCharsTable();
        randomCharsTable.run();
        printOut();
        removeFromOutput("Please input number");

        assertTrue(getOutputLines()[3].contains("odd letters - "));
    }

    @Test
    public void testInput2x2Even() throws IOException {
        setInput("2 2 even");

        RandomCharsTable randomCharsTable = new RandomCharsTable();
        randomCharsTable.run();
        printOut();
        removeFromOutput("Please input number");

        assertEquals(6, getOutputLines()[0].length());
        assertEquals(6, getOutputLines()[1].length());
        assertEquals(0, getOutputLines()[2].length());
        assertTrue(getOutputLines()[3].contains("even letters - "));
    }

    @Test
    public void testInputNegativeRow() throws IOException {
        setInput("-2 2 even");

        RandomCharsTable randomCharsTable = new RandomCharsTable();
        randomCharsTable.run();
        printOut();
        removeFromOutput("Please input number");

        assertEquals("negative isn't allowed", getOutputLines()[0]);
    }

    @Test
    public void testInputNegativeColumn() throws IOException {
        setInput("2 -2 odd");

        RandomCharsTable randomCharsTable = new RandomCharsTable();
        randomCharsTable.run();
        printOut();
        removeFromOutput("Please input number");

        assertEquals("negative isn't allowed", getOutputLines()[0]);
    }

    @Test
    public void testInputWrongOperator() throws IOException {
        setInput("2 2 asd");

        RandomCharsTable randomCharsTable = new RandomCharsTable();
        randomCharsTable.run();
        printOut();
        removeFromOutput("Please input number");

        assertEquals("Wrong type parameter", getOutputLines()[0]);
    }
}
