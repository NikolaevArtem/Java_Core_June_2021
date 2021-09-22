package course_project.board;

import course_project.player.Player;

import static course_project.utils.Colors.*;

public class Board {

    public static final int FIELD_SIZE = 10;
    private static final String SHIP = ANSI_GREEN + "■" + ANSI_RESET;
    private static final String WATER = "~";
    private static final String MISS = ANSI_MAGENTA + "▓" + ANSI_RESET;
    private static final String HIT = ANSI_YELLOW + "×" + ANSI_RESET;
    private static final String DESTROY = ANSI_RED + "*" + ANSI_RESET;

    Cell[][] cells;

    protected Board() {
        this.cells = new Cell[FIELD_SIZE][FIELD_SIZE];
        fillCells();
    }

    public void fillCells() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public void printField() {
        StringBuilder field = new StringBuilder();
        field.append("\t" + "A   B   C   D   E   F   G   H   I   J").append("\n");

        for (int i = 0; i < FIELD_SIZE; i++) {
            field.append(String.format("|%-2d|", i + 1));
            for (int j = 0; j < FIELD_SIZE; j++) {
                Cell currentCell = getCellByPosition(i, j);
                String symbol = WATER;
                if (!isCellEmpty(currentCell)) {
                    symbol = SHIP;
                }
                field.append(String.format("%s   ", symbol));
            }
            field.append("\n");
        }
        System.out.println(field);
    }

    public void showTwoFields(Player currentPlayer, Player enemy) {

        StringBuilder twoFields = new StringBuilder();

        twoFields.append("\t" + "A   B   C   D   E   F   G   H   I   J").append("\t\t\t    " + "A   B   C   D   E   F   G   H   I   J").append("\n");

        for (int i = 0; i < FIELD_SIZE; i++) {
            twoFields.append(String.format("|%-2d|", i + 1));
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (currentPlayer.getField().getCellByPosition(i, j).isHit()) {
                    checkCellStateAndMarkIt(currentPlayer, twoFields, i, j);
                } else {
                    if (currentPlayer.getField().isCellEmpty(currentPlayer.getField().getCellByPosition(i, j))) {
                        twoFields.append(String.format("%s   ", WATER));
                    } else {
                        twoFields.append(String.format("%s   ", SHIP));
                    }
                }
            }
            twoFields.append("\t\t").append(String.format("|%-2d|", i + 1));
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (enemy.getField().getCellByPosition(i, j).isHit()) {
                    checkCellStateAndMarkIt(enemy, twoFields, i, j);
                } else {
                    twoFields.append(String.format("%s   ", WATER));
                }
            }
            twoFields.append("\n");
        }
        System.out.println(twoFields);
    }

    private void checkCellStateAndMarkIt(Player currentPlayer, StringBuilder bothFields, int i, int j) {
        if (currentPlayer.getField().isHit(currentPlayer.getField().getCellByPosition(i, j))) {
            if (currentPlayer.getField().getCellByPosition(i, j).getReference().isDestroyed()) {
                bothFields.append(String.format("%s   ", DESTROY));
            } else {
                bothFields.append(String.format("%s   ", HIT));
            }
        } else {
            bothFields.append(String.format("%s   ", MISS));
        }
    }

    public Cell getCellByPosition(int x, int y) {
        for (Cell[] cellRow : this.cells) {
            for (Cell cellColumn : cellRow) {
                if (cellColumn.getX() == x && cellColumn.getY() == y) {
                    return cellColumn;
                }
            }
        }
        return null;
    }

    public boolean isCellEmpty(Cell currentCell) {
        return currentCell.getShipReference() == null;
    }

    public boolean isHit(Cell toCell) {
        return !isCellEmpty(cells[toCell.getX()][toCell.getY()]);
    }

}
