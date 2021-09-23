package course_project;

import java.util.Random;

public class GameField {

    public CellStatus[][] cells;

    public GameField(boolean isMainField) {
        cells = new CellStatus[12][12];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                cells[i][j] = CellStatus.FREE;
            }
        }

        if (isMainField) {
            createShip(4);
            createShip(3);
            createShip(3);
            createShip(2);
            createShip(2);
            createShip(2);
            createShip(1);
            createShip(1);
            createShip(1);
            createShip(1);
        }
    }

    public enum CellStatus {
        FREE,
        FAULT,
        HIT,
        SHIP,
        FILLED
    }

    public void createShip(int deckNum) {
        boolean enoughSpaceAround = false;
        int[] coordinates = new int[]{0,0};
        boolean horizontal = new Random().nextBoolean();

        while (!enoughSpaceAround) {
            coordinates = setRandomCoordinates(deckNum, horizontal);
            enoughSpaceAround = checkSpaceAround(coordinates[0], coordinates[1], deckNum, horizontal);
        }

        setStatusShipInCell(deckNum, horizontal, coordinates);
    }

    public boolean checkSpaceAround(int x, int y, int num, boolean horizontal) {
        if (horizontal) {
            for (int i = x-1; i < x+num+1; i++) {
                for (int j = y-1; j < y+2; j++) {
                    if (cells[i][j] == CellStatus.SHIP) return false;
                }
            }
        } else {
            for (int i = x-1; i < x+2; i++) {
                for (int j = y-1; j < y+num+1; j++) {
                    if (cells[i][j] == CellStatus.SHIP) return false;
                }
            }
        }

        return true;
    }

    private int[] setRandomCoordinates(int deckNum, boolean horizontal) {
        int x = new Random().nextInt(10-deckNum)+1;
        int y = new Random().nextInt(9)+1;

        if (horizontal) return new int[]{x, y};
        else return new int[]{y, x};
    }

    public void setStatusShipInCell(int deckNum, boolean horizontal, int[] coordinates) {
        if (horizontal) {
            for (int i = 0; i < deckNum; i++) {
                cells[coordinates[0]+i][coordinates[1]] = CellStatus.SHIP;
            }
        } else {
            for (int i = 0; i < deckNum; i++) {
                cells[coordinates[0]][coordinates[1]+i] = CellStatus.SHIP;
            }
        }
    }
}
