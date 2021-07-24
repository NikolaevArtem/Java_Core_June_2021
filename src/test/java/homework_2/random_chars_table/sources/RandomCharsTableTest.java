package homework_2.random_chars_table.sources;

import base.UnitBase;
import homework_2.random_chars_table.RandomCharsTable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomCharsTableTest extends UnitBase {

    RandomCharsTable rct = new RandomCharsTable();

    @Test
    void testFormatCount() {
        setInput("1 2 even 12even");

        rct.run();
        printOut();
        removeFromOutput("Input table length, table width, table strategy(even/odd): ");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]",
                getOutputLines()[0]);
    }

    @Test
    void testNegative() {
        setInput("-1 -2 odd");

        rct.run();
        printOut();
        removeFromOutput("Input table length, table width, table strategy(even/odd): ");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]",
                getOutputLines()[0]);
    }

    @Test
    void testZero() {
        setInput("0 0 odd");

        rct.run();
        printOut();
        removeFromOutput("Input table length, table width, table strategy(even/odd): ");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]",
                getOutputLines()[0]);
    }

    @Test
    void testWrongStrategy() {
        setInput("1 3 omg");

        rct.run();
        printOut();
        removeFromOutput("Input table length, table width, table strategy(even/odd): ");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]",
                getOutputLines()[0]);
    }

    @Test
    void testEmpty() {
        setInput("");

        rct.run();
        printOut();
        removeFromOutput("Input table length, table width, table strategy(even/odd): ");
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]",
                getOutputLines()[0]);
    }


    // robots will replace human beings !
    private void testInts(int length, int width) {
        if (length <= 0 || width <= 0) {
            throw new AssertionError();
        }
    }

    private int testStr(String strategy) {
        if (strategy.equalsIgnoreCase("odd")) {
            return 1;
        } else if (strategy.equalsIgnoreCase("even")) {
            return 0;
        } else {
            throw new AssertionError();
        }
    }

    // free for adding new valid values
    private static Stream<Arguments> validCases() {
        return Stream.of(
                Arguments.of(5, 5, "odd"),
                Arguments.of(7, 5, "even"),
                Arguments.of(13, 15, "even"),
                Arguments.of(2, 3, "odd"),
                Arguments.of(1, 8, "odd"),
                Arguments.of(1, 1, "even")
        );
    }

    @ParameterizedTest
    @MethodSource("validCases")
    void testValid(int rows, int columns, String strategy) {
        testInts(rows, columns);
        int remainder = testStr(strategy);

        setInput(
                String.format(
                        "%d %d %s",
                        rows, columns, strategy
                ));

        rct.run();
        printOut();
        removeFromOutput("Input table length, table width, table strategy(even/odd): ");
        for (int i = 0; i < rows; i++) {
            String[] row = getOutputLines()[i].split(" ");
            for (String el : row) {
                if (el.charAt(0) != '|') {
                    assert (el.charAt(0) >= 65 && el.charAt(0) <= 90);
                }
            }
        }

        // check result could be empty
        try {
            if (getOutputLines()[rows] != "") {
                String[] result = getOutputLines()[rows].split(" ");
                for (int i = 3; i < result.length; i++) {
                    assert (result[i].charAt(0) % 2 == remainder);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return;
        }

    }


}
