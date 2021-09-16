package course_project.sea_battle.playground;

import lombok.Getter;

@Getter
public class Playground {
    static final int FIELD_SIZE = 10;
    final private PlaygroundCell[][] cells;

    public Playground () {
        cells = new PlaygroundCell[FIELD_SIZE][FIELD_SIZE];

        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                cells[i][j] = new PlaygroundCell();
            }
        }
    }

    public PlaygroundCell getCell(CellData data) {
        return cells[data.getRow()][data.getCol() - 1];
    }

    public static int getFieldSize() {
        return FIELD_SIZE;
    }

    public String toStringMine() {
        return toStringBoth(true);
    }

    public String toStringOthers() {
        return toStringBoth(false);
    }

    public String toStringBoth(boolean isMine) {
        final String INIT_SYMBOL = "-";
        final String MISSED_SYMBOL = "_";
        final String HIT_SYMBOL = "x";
        final String KILLED_SYMBOL = "X";

        final String OCCUPIED_SYMBOL = isMine ? "#" : INIT_SYMBOL;

        StringBuilder stringBuilder = new StringBuilder("\n  ");
        for (int i = 0; i < FIELD_SIZE; i++) {
            stringBuilder.append(i + 1).append(" ");
        }
        stringBuilder.append("\n");

        for (int i = 0; i < FIELD_SIZE; i++) {
            stringBuilder.append((char) (i + 'A')).append(" ");
            for (int j = 0; j < FIELD_SIZE; j++) {
                PlaygroundCell currentCell = cells[i][j];
                if (currentCell.isHit()) {
                    if (currentCell.getShip().isKilled()) {
                        stringBuilder.append(KILLED_SYMBOL).append(" ");
                    } else {
                        stringBuilder.append(HIT_SYMBOL).append(" ");
                    }
                } else {
                    if (currentCell.isMissed()) {
                        stringBuilder.append(MISSED_SYMBOL).append(" ");
                    } else {
                        if (currentCell.isOccupied()) {
                            stringBuilder.append(OCCUPIED_SYMBOL).append(" ");
                        } else {
                            stringBuilder.append(INIT_SYMBOL).append(" ");
                        }
                    }
                }
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
