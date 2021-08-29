package Homework2.Random_Chars_Table;

import base.UnitBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomCharsTableTest extends UnitBase {
    static RandomCharsTable randomCharsTable;
    static char[][] charTable;

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
        String evenResult = randomCharsTable.getResult("even", charTable);

        assertEquals(expectedEven, evenResult);
    }

    @Test
    void getOddResultTest() {
        String expectedOdd = "odd letters - A C E G I";
        String oddResult = randomCharsTable.getResult("odd", charTable);

        assertEquals(expectedOdd, oddResult);
    }

    @Test
    void runWithValidOddInputTest() {
        setInput("3 3 odd");
        randomCharsTable.run();
        printOut();

    }

    @Test
    void runWithValidEvenInputTest() {
        setInput("3 3 even");
        randomCharsTable.run();
        printOut();
    }

    @Test
    void runWithInvalidInputTest() {
        setInput("sfr");

        assertThrows(IllegalArgumentException.class, () -> randomCharsTable.run());
    }

}