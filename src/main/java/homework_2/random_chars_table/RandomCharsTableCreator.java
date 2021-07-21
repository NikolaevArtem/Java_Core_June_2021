package homework_2.random_chars_table;

import java.util.Random;

/**
 * todo Document type RandomCharsTableCreator
 */
public class RandomCharsTableCreator {

    private RandomCharsTableCreator() {
        throw new IllegalStateException("Utility class");
    }

    public static char[][] initTable(int height, int width) {
        char[][] chars = new char[height][width];
        Random random = new Random();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                chars[i][j] = (char) (random.nextInt(26) + 65);
            }
        }

        return chars;
    }

}
