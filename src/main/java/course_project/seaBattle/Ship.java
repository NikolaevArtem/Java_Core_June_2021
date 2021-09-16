package course_project.seaBattle;


import java.util.Random;

import static course_project.seaBattle.Field.SIZE;

public class Ship {
    int positionY;
    int positionX;
    int size;
    boolean isVertical;
    int health;
    public static Ship[] ships = new Ship[10];

    public Ship(int positionX, int positionY, int size, boolean isVertical) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.size = size;
        this.isVertical = isVertical;
        this.health = size;
    }

    public static void randomGenerateShip(char[][] field, Random rand) {
        for (int i = 0; i < 10; i++) {
            boolean isShipPlaced = false;
            do {
                if (i == 0) ships[i] = new Ship(rand.nextInt(10), rand.nextInt(10), 4, rand.nextBoolean());
                if (i > 0 && i <= 2)
                    ships[i] = new Ship(rand.nextInt(10), rand.nextInt(10), 3, rand.nextBoolean());
                if (i > 2 && i <= 5)
                    ships[i] = new Ship(rand.nextInt(10), rand.nextInt(10), 2, rand.nextBoolean());
                if (i > 5) ships[i] = new Ship(rand.nextInt(10), rand.nextInt(10), 1, rand.nextBoolean());
                if (canSetShip(ships[i], field)) {
                    setShipOnField(ships[i], field);
                    isShipPlaced = true;
                }
            } while (!isShipPlaced);
        }
    }
    private static void setShipOnField(Ship ship, char[][] field) {
        if (ship.isVertical) {
            for (int i = 0; i < ship.size; i++) {
                field[ship.positionX][ship.positionY + i] = 'X';
            }
        } else {
            for (int i = 0; i < ship.size; i++) {
                field[ship.positionX + i][ship.positionY] = 'X';
            }
        }
    }

    private static boolean canSetShip(Ship ship, char[][] field) {
        if (ship.positionX < 0 || ship.positionY < 0 || SIZE <= ship.positionX || SIZE <= ship.positionY)
            return false;
        if (ship.isVertical && SIZE <= ship.positionY + ship.size) return false;
        if (!ship.isVertical && SIZE <= ship.positionX + ship.size) return false;
        int minX = Math.max(0, ship.positionX - 1);
        int minY = Math.max(0, ship.positionY - 1);
        int maxX = Math.min(SIZE - 1, ship.positionX + 1 + (ship.isVertical ? 0 : ship.size));
        int maxY = Math.min(SIZE - 1, ship.positionY + 1 + (ship.isVertical ? ship.size : 0));
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                if (isShipPresent(x, y, field)) return false;
            }
        }
        return true;
    }

    private static boolean isShipPresent(int x, int y, char[][] field) {
        return field[x][y] == 'X';
    }
}