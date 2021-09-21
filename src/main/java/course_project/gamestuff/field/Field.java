package course_project.gamestuff.field;

import course_project.gamestuff.player.Player;

import static homework_2.Colors.*;

public abstract class Field {

    public static final int FIELD_SIZE = 12;
    public static final int LOWERCASE_A = 'a';
    private static final String WATER = BLUE_BG + " " + ANSI_RESET;
    private static final String DESTROYED = ANSI_RED + "†" + ANSI_RESET;
    private static final String HIT = ANSI_RED + "X" + ANSI_RESET;
    private static final String MISS = ANSI_YELLOW + "O" + ANSI_RESET;
    private static final String SHIP = ANSI_GREEN + "¤" + ANSI_RESET;
    private static final char FIRST_SYMBOL_TOP_LINE = 'A';
    private static final String TOP_LINE;
    private static final String CELL_FORMAT = "%s   ";
    private static final String ROW_NUMBER_FORMAT = "[%-2d]";

    private final Cell[][] cells;

    protected Field() {
        this.cells = new Cell[FIELD_SIZE][FIELD_SIZE];
        fillCellsWithIndexes();
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = FIRST_SYMBOL_TOP_LINE; i < FIRST_SYMBOL_TOP_LINE + FIELD_SIZE; i++) {
            stringBuilder
                    .append((char) i)
                    .append("   ");
        }
        TOP_LINE = stringBuilder.toString().trim();
    }

    private void fillCellsWithIndexes() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public void printField() {
        StringBuilder oneField = new StringBuilder();
        oneField
                .append("\t")
                .append(TOP_LINE)
                .append("\n");
        for (int i = 0; i < FIELD_SIZE; i++) {
            oneField.append(String.format(ROW_NUMBER_FORMAT, i + 1));
            for (int j = 0; j < FIELD_SIZE; j++) {
                Cell currentCell = getCellByPosition(i, j);
                String toPrint = WATER;
                if (!isCellEmpty(currentCell)) {
                    toPrint = SHIP;
                }
                oneField.append(String.format(CELL_FORMAT, toPrint));
            }
            oneField.append("\n");
        }
        System.out.println(oneField);
    }

    public void printBothFields(Player currentPlayer, Player enemy) {
        StringBuilder bothFields = new StringBuilder();
        bothFields
                .append("\t")
                .append(TOP_LINE)
                .append("\t\t\t    ")
                .append(TOP_LINE)
                .append("\n");
        for (int i = 0; i < FIELD_SIZE; i++) {
            bothFields.append(String.format(ROW_NUMBER_FORMAT, i + 1));
            for (int j = 0; j < FIELD_SIZE; j++) {
                Cell currentPlayerCell = currentPlayer.getField().getCellByPosition(i, j);
                if (currentPlayerCell.isHit()) {
                        bothFields
                                .append(getCellStateAsString(currentPlayer, currentPlayerCell));
                } else {
                    if (currentPlayer.getField().isCellEmpty(currentPlayerCell)) {
                        bothFields
                                .append(String.format(CELL_FORMAT, WATER));
                    } else {
                        bothFields
                                .append(String.format(CELL_FORMAT, SHIP));
                    }
                }
            }
            bothFields
                    .append("\t\t")
                    .append(String.format(ROW_NUMBER_FORMAT, i + 1));
            for (int j = 0; j < FIELD_SIZE; j++) {
                Cell currentEnemyCell = enemy.getField().getCellByPosition(i, j);
                if (currentEnemyCell.isHit()) {
                    bothFields
                            .append(getCellStateAsString(enemy, currentEnemyCell));
                } else {
                    bothFields
                            .append(String.format(CELL_FORMAT, WATER));
                }
            }
            bothFields.append("\n");
        }
        System.out.println(bothFields);
    }

    private String getCellStateAsString(Player currentPlayer, Cell playersCell) {
        if (currentPlayer.getField().getHit(playersCell)) {
            if (playersCell.getRef().isShipDestroyed()) {
                return String.format(CELL_FORMAT, DESTROYED);
            } else {
                return String.format(CELL_FORMAT, HIT);
            }
        }
        return String.format(CELL_FORMAT, MISS);
    }

    public Cell getCellByPosition(int x, int y) {
        for (Cell[] cellRow : this.cells) {
            for (Cell cellCol : cellRow) {
                if (cellCol.getX() == x && cellCol.getY() == y) {
                    return cellCol;
                }
            }
        }
        return null;
    }

    public boolean isCellEmpty(Cell currentCell) {
        return currentCell.isShipPlacedAtCell() == null;
    }

    public boolean getHit(Cell toCell) {
        return !isCellEmpty(cells[toCell.getX()][toCell.getY()]);
    }

}
