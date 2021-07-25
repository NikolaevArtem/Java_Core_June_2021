package homework_2.random_chars_table;

import java.util.Arrays;
import java.util.Random;

public class RandomCharTableGenerator {

    static char[][] randomCharTable(int length, int width, char start, char end) {
        Random random = new Random(System.currentTimeMillis());
        char[][] randomTable = new char[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                randomTable[i][j] = (char) (random.nextInt(end - start) + start);
            }
        }
        return Arrays.copyOf(randomTable, randomTable.length);
    }
}
