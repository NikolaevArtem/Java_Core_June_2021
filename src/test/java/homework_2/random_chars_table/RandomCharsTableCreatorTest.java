package homework_2.random_chars_table;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomCharsTableCreatorTest {

    private List<Character> evenLettersArrayList;
    private List<Character> oddLettersArrayList;

    @BeforeEach
    void setUp() {
        evenLettersArrayList = Arrays.asList(new Character[]{60, 62, 64, 66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88, 90});
        oddLettersArrayList = Arrays.asList(new Character[]{61, 63, 65, 67, 69, 71, 73, 75, 77, 79, 81, 83, 85, 87, 89});
    }

    @Test
    void createRandomCharsTableTest1() {
        RandomCharsTableCreator randomCharsTableCreator = new RandomCharsTableCreator();
        char[][] charsTable = randomCharsTableCreator.createRandomCharsTable(20, 40);

        assertEquals(20, charsTable.length);
        for (char[] chars : charsTable) {
            assertEquals(40, chars.length);
            for (char ch : chars) {
                assertTrue(evenLettersArrayList.contains(ch) || oddLettersArrayList.contains(ch));
            }
        }
    }

    @Test
    void createRandomCharsTableTest2() {
        RandomCharsTableCreator randomCharsTableCreator = new RandomCharsTableCreator();
        char[][] charsTable = randomCharsTableCreator.createRandomCharsTable(12, 122);

        assertEquals(12, charsTable.length);
        for (char[] chars : charsTable) {
            assertEquals(122, chars.length);
            for (char ch : chars) {
                assertTrue(evenLettersArrayList.contains(ch) || oddLettersArrayList.contains(ch));
            }
        }
    }
}