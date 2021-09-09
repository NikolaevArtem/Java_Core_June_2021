package Homework2.Random_Chars_Table;

import base.UnitBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomCharsTableTest extends UnitBase {
    static RandomCharsTable randomCharsTable;
    static char[][] charTable;
    final String checkTableLines = "\\|(\\s\\w\\s\\|){2}\\s";

    @BeforeAll
    public static void init() {
        randomCharsTable = new RandomCharsTable();
        randomCharsTable.length = 3;
        randomCharsTable.height = 3;
        charTable = new char[][]{
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'}
        };
    }

    @Test
    void getEvenResultTest() {
        String expectedEven = "even letters - B D F H";
        init();
        String evenResult = randomCharsTable.getResult("even", charTable);

        assertEquals(expectedEven, evenResult);
    }

    @Test
    void getOddResultTest() {
        String expectedOdd = "odd letters - A C E G I";
        init();
        String oddResult = randomCharsTable.getResult("odd", charTable);

        assertEquals(expectedOdd, oddResult);
    }

    @Test
    void runWithValidOddInputTest() {
        setInput("2 2 odd");
        randomCharsTable.run();
        printOut();
        String actualTableRow1 = getOutputLines()[0];
        String actualTableRow2 = getOutputLines()[1];
        String actual = getOutputLines()[3];

        assertTrue(actualTableRow1.matches(checkTableLines));
        assertTrue(actualTableRow2.matches(checkTableLines));
        assertEquals("odd letters - ", actual.substring(0, 14));
    }

    @Test
    void runWithValidEvenInputTest() {
        setInput("2 2 even");
        randomCharsTable.run();
        printOut();
        String actualTableRow1 = getOutputLines()[0];
        String actualTableRow2 = getOutputLines()[1];
        String actual = getOutputLines()[3];

        assertTrue(actualTableRow1.matches(checkTableLines));
        assertTrue(actualTableRow2.matches(checkTableLines));
        assertEquals("even letters - ", actual.substring(0, 15));
    }

    @Test
    void runWithInvalidInputTest() {
        setInput("sfr");

        assertThrows(IllegalArgumentException.class, () -> randomCharsTable.run());
    }

}