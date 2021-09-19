package course_project;

import lombok.Data;
import java.util.*;

@Data
public class Field {
    enum cellStatus {
        CLEAN,
        TOUCHING,
        SHIP,
        WOUNDED,
        SUNK,
        MISS
    }
    private final static int fieldLength = 10;
    private static final HashMap<cellStatus, Character> cellStatusSign = new HashMap<cellStatus, Character>(){{
        put(cellStatus.CLEAN, '~');
        put(cellStatus.TOUCHING, '~');
        put(cellStatus.SHIP, 'U');
        put(cellStatus.WOUNDED, 'x');
        put(cellStatus.SUNK, 'x');
        put(cellStatus.MISS, 'o');
    }};
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    private cellStatus[][] cells = new cellStatus[fieldLength][fieldLength];
    private List<Ship> listOfShips = new ArrayList<>();

    public static int[] stringToCell(String str) {
        char columnNumberChar = str.substring(0, 1).charAt(0);
        int columnNumber;

        if ((int) columnNumberChar > 74) {
            return null;
        } else {
            columnNumber = (int) columnNumberChar - 64;
        }
        String lineNumberStr = str.substring(1);

        try {
            int lineNumber = Integer.parseInt(lineNumberStr);
            if (lineNumber > 10) {
                return null;
            }
            return new int[]{lineNumber - 1, columnNumber - 1};
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Field() {
        for (int i = 0; i < fieldLength; i++) {
            for (int j = 0; j < fieldLength; j++) {
                cells[j][i] = cellStatus.CLEAN;
            }
        }
    }

    public boolean createShip(int shipLength, String[] shipCoordinates) {
        int[] beginningCell;
        int[] endCell;

        if ((shipLength == 1 && shipCoordinates.length != 1)
                || (shipLength > 1 && shipCoordinates.length != 2)) {
            System.out.println("Error! Wrong length of the ship! Try again.\n");
            return false;
        }

        beginningCell = stringToCell(shipCoordinates[0]);
        endCell = shipLength == 1 ? beginningCell : stringToCell(shipCoordinates[1]);

        if (beginningCell == null || endCell == null) {
            System.out.println("Error! Wrong enter! Try again.\n");
            return false;
        }

        if (checkShip(shipLength, beginningCell, endCell)) {
            drawShip(shipLength, beginningCell, endCell);
            return true;
        }
        return false;
    }

    private boolean checkShip(int shipLength, int[] beginningCell, int[] endCell) {
        if (!cellWithinFieldBoundaries(beginningCell) || !cellWithinFieldBoundaries(endCell)) {
            System.out.println("Error! Out of field bounds! Try again.\n");
            return false;
        } else if (!Ship.shipIsInAStraightLine(shipLength, beginningCell, endCell)) {
            System.out.println("Error! The ship is not in a straight line! Try again.\n");
            return false;
        } else if (!Ship.rightShipLength(shipLength, beginningCell, endCell)) {
            System.out.println("Error! Wrong length of the ship! Try again.\n");
            return false;
        } else if (!cellsAbleToFill(beginningCell, endCell)) {
            System.out.println("Error! This cell is not able to be filled with a ship. Try again.\n");
            return false;
        }
        return true;
    }

    private boolean cellWithinFieldBoundaries(int[] cell) {
        return cell[0] <= 9 && cell[1] <= 9 && cell[0] >= 0 && cell[1] >= 0;
    }

    private boolean cellsAbleToFill(int[] beginningCell, int[] endCell) {
        int[][] shipCells = getShipCells(beginningCell, endCell);
        if (shipCells != null) {
            for (int[] cell : shipCells) {
                if (!cellCleanAndNotTouching(cell)) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] getShipCells(int[] beginningCell, int[] endCell) {
        int[][] shipCells;

        if (beginningCell[1] == endCell[1]) { //horizontal
            shipCells = new int[Math.abs(beginningCell[0] - endCell[0]) + 1][3];
            int lineMin = Math.min(beginningCell[0], endCell[0]);
            int lineMax = Math.max(beginningCell[0], endCell[0]);
            for (int i = 0; i <= lineMax - lineMin; i++) {
                shipCells[i][0] = lineMin + i;
                shipCells[i][1] = beginningCell[1];
                shipCells[i][2] = 0; //status
            }
            return shipCells;
        } else if (beginningCell[0] == endCell[0]) { //vertical
            shipCells = new int[Math.abs(beginningCell[1] - endCell[1]) + 1][3];
            int columnMin = Math.min(beginningCell[1], endCell[1]);
            int columnMax = Math.max(beginningCell[1], endCell[1]);
            for (int i = 0; i <= columnMax - columnMin; i++) {
                shipCells[i][0] = beginningCell[0];
                shipCells[i][1] = columnMin + i;
                shipCells[i][2] = 0; //status
            }
            return shipCells;
        }
        return null;
    }

    private boolean cellCleanAndNotTouching(int[] cell) {
        int line = cell[0];
        int column = cell[1];

        if (cells[line][column] != cellStatus.CLEAN) {
            return false;
        }

        ArrayList<int[]> adjacentCells = getAdjacentCells(cell);
        for (int[] adjacentCell : adjacentCells) {
            int adjacentLine = adjacentCell[0];
            int adjacentColumn = adjacentCell[1];

            if (cells[adjacentLine][adjacentColumn] == cellStatus.SHIP) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<int[]> getAdjacentCells(int[] cell) {
        int column = cell[0];
        int line = cell[1];

        ArrayList<int[]> adjacentCells = new ArrayList<>();
        for (int i = line - 1; i <= line + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                int[] checkingCell = new int[]{j, i};
                if (cellWithinFieldBoundaries(checkingCell) && !Arrays.equals(cell, checkingCell)) {
                    adjacentCells.add(checkingCell);
                }
            }
        }
        return adjacentCells;
    }

    private void drawShip(int shipLength, int[] beginningCell, int[] endCell) {
        int[][] shipCells = getShipCells(beginningCell, endCell);
        listOfShips.add(new Ship(shipLength, shipCells));

        if (shipCells != null) {
            for (int[] cell : shipCells) {
                int line = cell[0];
                int column = cell[1];
                cells[line][column] = cellStatus.SHIP;

                ArrayList<int[]> adjacentCells = getAdjacentCells(cell);
                for (int[] adjacentCell : adjacentCells) {
                    int adjacentColumn = adjacentCell[1];
                    int adjacentLine = adjacentCell[0];

                    if (cells[adjacentLine][adjacentColumn] != cellStatus.SHIP) {
                        cells[adjacentLine][adjacentColumn] = cellStatus.TOUCHING;
                    }
                }
            }
        }
    }

    boolean allShipsSunk() {
        for (Ship ship : listOfShips) {
            if (ship.getShipStatus() != Ship.status.SUNK) {
                return false;
            }
        }
        return true;
    }

    String shotResult(int[] shotCell) {
        int line = shotCell[0];
        int column = shotCell[1];
        cellStatus status = getCellStatus(line, column);

        if (status == cellStatus.SHIP) {
            cells[line][column] = cellStatus.WOUNDED;
            Ship hitShip = getHitShip(shotCell);
            if (hitShip != null && hitShip.getShipStatus() == Ship.status.SUNK) {
                setSunkStatusToCells(hitShip);
                return "sunk";
            }
            return "hit";
        } else if (status == cellStatus.MISS || status == cellStatus.WOUNDED || status == cellStatus.SUNK) {
            return "repeat";
        } else {
            cells[line][column] = cellStatus.MISS;
        }
        return "miss";
    }

    private cellStatus getCellStatus(int line, int column) {
        return cells[line][column];
    }

    private Ship getHitShip(int[] shotCell) {
        for (Ship ship : listOfShips) {
            if (ship.cellBelongsToShip(shotCell)) {
                ship.setShipStatus(Ship.status.HIT);
                ship.setCellHit(shotCell);
                return ship;
            }
        }
        return null;
    }

    private void setSunkStatusToCells(Ship ship) {
        int[][] shipCells = ship.getShipCells();

        for (int[] shipCell : shipCells) {
            int line = shipCell[0];
            int column = shipCell[1];
            cells[line][column] = cellStatus.SUNK;
        }
    }

    void printField(boolean showShips) {
        System.out.print("    ");
        char c = 0x0041;

        for (int i = 1; i <= fieldLength; i++) {
            System.out.print(c + " ");
            c += 1;
        }
        System.out.print("\n");

        for (int i = 0; i < fieldLength; i++) {
            System.out.print(i < 9 ? "  " + (i + 1) : " " + (i + 1));
            for (int j = 0; j < fieldLength; j++) {
                System.out.print(" ");
                if (!showShips && (cells[i][j] == cellStatus.SHIP || cells[i][j] == cellStatus.TOUCHING)) {
                    System.out.print(cellStatusSign.get(cellStatus.CLEAN));
                } else if (cells[i][j] == cellStatus.SUNK) {
                    System.out.print(ANSI_RED + cellStatusSign.get(cells[i][j]) + ANSI_RESET);
                } else {
                    System.out.print(cellStatusSign.get(cells[i][j]));
                }
            }
            System.out.println();
        }
        System.out.print("\n");
    }

}

