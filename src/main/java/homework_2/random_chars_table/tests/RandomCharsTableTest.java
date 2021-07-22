package homework_2.random_chars_table.tests;

import homework_2.UnitBase;
import homework_2.random_chars_table.sources.RandomCharsTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomCharsTableTest extends UnitBase {

    @Test
    void testFormatCount() {
        setInput("1 2 even 12even");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput("Input table length, table width, table strategy (even/odd): ");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]",
                getOutputLines()[0]);
    }

    @Test
    void testNegative() {
        setInput("-1 -2 odd");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput("Input table length, table width, table strategy (even/odd): ");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]",
                getOutputLines()[0]);
    }

    @Test
    void testZero() {
        setInput("0 0 odd");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput("Input table length, table width, table strategy (even/odd): ");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]",
                getOutputLines()[0]);
    }

    @Test
    void testWrongStrategy() {
        setInput("1 3 omg");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput("Input table length, table width, table strategy (even/odd): ");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]",
                getOutputLines()[0]);
    }

    @Test
    void testEmpty() {
        setInput("");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput("Input table length, table width, table strategy (even/odd): ");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]",
                getOutputLines()[0]);
    }

}
