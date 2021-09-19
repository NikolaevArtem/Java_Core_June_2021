package course_project;

import lombok.Data;

@Data
public class Ship {
    enum status {
        INTACT,
        HIT,
        SUNK
    }
    private int shipLength;
    private int[][] shipCells;
    private status shipStatus;

    public Ship(int shipLength, int[][] shipCells) {
        this.shipLength = shipLength;
        this.shipCells = shipCells;
        this.shipStatus = status.INTACT;
    }

    public static boolean shipIsInAStraightLine(int shipLength, int[] beginningCell, int[] endCell) {
        return beginningCell[0] == endCell[0] || beginningCell[1] == endCell[1];
    }

    public static boolean rightShipLength(int shipLength, int[] beginningCell, int[] endCell) {
        return Math.abs(beginningCell[0] - endCell[0]) + 1 == shipLength ||
                Math.abs(beginningCell[1] - endCell[1]) + 1 == shipLength;
    }

    public boolean cellBelongsToShip(int[] shipCell) {
        for (int[] cell : shipCells) {
            if (cell[0] == shipCell[0] && cell[1] == shipCell[1]) {
                return true;
            }
        }
        return false;
    }

    public void setCellHit(int[] shipCell) {
        for (int[] cell : shipCells) {
            if (cell[0] == shipCell[0] && cell[1] == shipCell[1]) {
                cell[2] = 1;
            }
        }

        if (shipSunk()) {
            shipStatus = status.SUNK;
        }
    }

    private boolean shipSunk() {
        for (int[] cell : shipCells) {
            if (cell[2] != 1) {
                return false;
            }
        }
        return true;
    }

}
