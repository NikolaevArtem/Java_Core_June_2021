package homework_2.random_chars_table;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RandomCharsTableTest extends UnitBase {

    @Test
    void given_first_bad() {
        setInput("-1 1 even");

        new RandomCharsTable().run();
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]", getOutputLines()[0]);
    }

    @Test
    void given_second_bad() {
        setInput("1 -31 odd");

        new RandomCharsTable().run();
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]", getOutputLines()[0]);
    }

    @Test
    void given_last_bad() {
        setInput("1 -3 dfsdf");

        new RandomCharsTable().run();
        assertEquals("Passed parameters should match the format [positive integer] [positive integer] [even|odd]", getOutputLines()[0]);
    }

    @Test
    void getResultCharTestEven() {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(66);
        array.add(86);
        array.add(77);
        array.add(88);

        assertEquals("Even letters - B, V, X", RandomCharsTable.getResultChar(array, true));
    }

    @Test
    void getResultCharTestOdd() {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(69);
        array.add(67);
        array.add(77);
        array.add(88);

        assertEquals("Odd letters - E, C, M", RandomCharsTable.getResultChar(array, false));
    }

    @Test
    void printTableTest() {
        char[][] table = {{'H', 'A'}, {'F', 'T'}};

        RandomCharsTable randomCharsTable = new RandomCharsTable();
        randomCharsTable.printTable(table, 2, 2);

        assertEquals("|H|A|", getOutputLines()[0]);
        assertEquals("|F|T|", getOutputLines()[1]);
    }
}