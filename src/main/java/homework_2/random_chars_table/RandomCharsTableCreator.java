package homework_2.random_chars_table;

import java.util.concurrent.ThreadLocalRandom;

public class RandomCharsTableCreator {


    char[][] createRandomCharsTable(int height, int width) {
        if (height < 1 || width < 1) {
            System.out.println(RandomCharsTable.ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
        char[][] randomCharsTable = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                randomCharsTable[i][j] = getRandomChar();
            }
        }
        return randomCharsTable;
    }

     char getRandomChar() {
        int randomNum = ThreadLocalRandom.current().nextInt(65, 90 + 1);
        return (char) randomNum;
    }
}
