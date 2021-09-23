package SeaBattle;

import java.util.Random;

public class GenerateShips {

    static int FIELD_SIZE = 10;

    public char[][] createBoardWithShips() {
        GenerateShips generateShips = new GenerateShips();
        int[][] field = new int[FIELD_SIZE][FIELD_SIZE];
        generateShips.fillField(field, 4);
        generateShips.fillField(field, 3);
        generateShips.fillField(field, 3);
        generateShips.fillField(field, 2);
        generateShips.fillField(field, 2);
        generateShips.fillField(field, 2);
        generateShips.fillField(field, 1);
        generateShips.fillField(field, 1);
        generateShips.fillField(field, 1);
        generateShips.fillField(field, 1);

        char map[][] = new char[FIELD_SIZE][FIELD_SIZE];
        for(int i = 0; i < FIELD_SIZE; i++) {
            for(int j = 0; j < FIELD_SIZE; j++) {
                map[i][j] = field[i][j] == 0 || field[i][j] == 9 ? '_' : '0';
            }
        }
        return map;
    }

    void fillField(int [][] fields, int shipLength) {

        Random random = new Random();
        int[][] field = fields;
        while(true) {
            int x = random.nextInt(field.length);
            int y = random.nextInt(field.length);
            boolean vertical = random.nextBoolean();

            if(vertical) {
                if(y + shipLength > FIELD_SIZE) {
                    y -= shipLength;
                }
            } else if(x + shipLength > FIELD_SIZE) {
                x -= shipLength;
            }
            boolean isFree = true;
            if(vertical) {
                for(int m = y; m < y + shipLength; m++) {
                    if(field[m][x] != 0) {
                        isFree = false;
                        break;
                    }
                }
            } else {
                for(int n = x; n < x + shipLength; n++) {
                    if(field[y][n] != 0) {
                        isFree = false;
                        break;
                    }
                }
            }
            if(!isFree) {
                continue;
            }

            if(vertical) {
                for(int m = Math.max(0, x - 1); m < Math.min(FIELD_SIZE, x + 2); m++) {
                    for(int n = Math.max(0, y - 1); n < Math.min(FIELD_SIZE, y + shipLength + 1); n++) {
                        field[n][m] = 9;
                    }
                }
            } else {
                for(int m = Math.max(0, y - 1); m < Math.min(FIELD_SIZE, y + 2); m++) {
                    for(int n = Math.max(0, x - 1); n < Math.min(FIELD_SIZE, x + shipLength + 1); n++) {
                        field[m][n] = 9;
                    }
                }
            }
            for(int j = 0; j < shipLength; j++) {
                field[y][x] = shipLength;
                if(vertical) {
                    y++;
                } else {
                    x++;
                }
            }
            break;
        }
    }
}
