package homework_2.random_chars_table;

import java.util.Random;

public class RandomCharsTableCreator {
    private final Random random = new Random();

    char[][] create(int length, int width) {
        if (length < 1 || width < 1) {
            throw new IllegalArgumentException();
        }
        char[][] randomChars = new char[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                randomChars[i][j] = getRandomChar();
            }
        }
        return randomChars;
    }

    private char getRandomChar() {
        return (char) (random.nextInt(90 - 65 + 1) + 65);
    }
}
