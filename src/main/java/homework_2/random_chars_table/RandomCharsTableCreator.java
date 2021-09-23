package homework_2.random_chars_table;

import java.util.Random;

public final class RandomCharsTableCreator {

    private static final Random random = new Random();

    private RandomCharsTableCreator() {
        throw new IllegalStateException("Utility class");
    }

    public static char[][] initAndFillTable(int height, int width) {
        char[][] table = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                table[i][j] = (char) (random.nextInt(26) + 65);
            }
        }
        return table;
    }

}
