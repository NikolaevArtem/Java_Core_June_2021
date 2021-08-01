package homework_2.random_chars_table;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * todo Document type RandomCharsTableCreatorTest
 */
class RandomCharsTableCreatorTest {

    private List<Character> evenLettersArrayList;
    private List<Character> oddLettersArrayList;

    @BeforeEach
    void setUp() {
        evenLettersArrayList = Arrays.asList(new Character[]{66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88, 90});
        oddLettersArrayList = Arrays.asList(new Character[]{65, 67, 69, 71, 73, 75, 77, 79, 81, 83, 85, 87, 89});
    }

    @Test
    void initTableTest1() {
        char[][] charsTable = RandomCharsTableCreator.initAndFillTable(10, 20);

        assertEquals(10, charsTable.length);
        for (char[] chars : charsTable) {
            assertEquals(20, chars.length);
            for (char ch : chars) {
                assertTrue(evenLettersArrayList.contains(ch) || oddLettersArrayList.contains(ch));
            }
        }
    }

    @Test
    void initTableTest2() {
        char[][] charsTable = RandomCharsTableCreator.initAndFillTable(14, 124);

        assertEquals(14, charsTable.length);
        for (char[] chars : charsTable) {
            assertEquals(124, chars.length);
            for (char ch : chars) {
                assertTrue(evenLettersArrayList.contains(ch) || oddLettersArrayList.contains(ch));
            }
        }
    }
}