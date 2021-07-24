package homework_2.random_chars_table.sources;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomCharsTableTest extends UnitBase {

    @Test
    void testFormatCount() {
        setInput("1 2 even 12even");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput("Input table length, table width, table strategy(even/odd): ");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]",
                getOutputLines()[0]);
    }

    @Test
    void testNegative() {
        setInput("-1 -2 odd");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput("Input table length, table width, table strategy(even/odd): ");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]",
                getOutputLines()[0]);
    }

    @Test
    void testZero() {
        setInput("0 0 odd");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput("Input table length, table width, table strategy(even/odd): ");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]",
                getOutputLines()[0]);
    }

    @Test
    void testWrongStrategy() {
        setInput("1 3 omg");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput("Input table length, table width, table strategy(even/odd): ");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]",
                getOutputLines()[0]);
    }

    @Test
    void testEmpty() {
        setInput("");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput("Input table length, table width, table strategy(even/odd): ");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]",
                getOutputLines()[0]);
    }

    @Test
    void testValidEven() {
        setInput("5 5 even");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput("Input table length, table width, table strategy(even/odd): ");
        for (int i = 0; i < 5; i++) {
            String[] row = getOutputLines()[i].split(" ");
            for (String el : row) {
                assert (el.charAt(0) >= 65 && el.charAt(0) <= 90);
            }
        }
        String[] result = getOutputLines()[5].split(" ");
        for (int i = 3; i < result.length; i++) {
            assert (result[i].charAt(0) % 2 == 0);
        }
    }

    @Test
    void testValidOdd() {
        setInput("7 5 odd");

        new RandomCharsTable().run();
        printOut();
        removeFromOutput("Input table length, table width, table strategy(even/odd): ");
        for (int i = 0; i < 7; i++) {
            String[] row = getOutputLines()[i].split(" ");
            for (String el : row) {
                assert (el.charAt(0) >= 65 && el.charAt(0) <= 90);
            }
        }
        String[] result = getOutputLines()[7].split(" ");
        for (int i = 3; i < result.length; i++) {
            assert (result[i].charAt(0) % 2 == 1);
        }
    }

}
