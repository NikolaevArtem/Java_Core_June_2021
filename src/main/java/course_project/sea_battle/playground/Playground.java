package course_project.sea_battle.playground;

import lombok.Getter;

@Getter
public class Playground {
    static final int FIELD_SIZE = 10;
    static final int SHIP_AMOUNT = 5;

    final private PlaygroundCell[][] cells;
    private int killedShips;

    public Playground () {
        cells = new PlaygroundCell[FIELD_SIZE][FIELD_SIZE];

        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                cells[i][j] = new PlaygroundCell();
            }
        }

        killedShips = 0;
    }

    public PlaygroundCell getCell(CellData data) {
        return cells[data.getRow()][data.getCol() - 1];
    }

    public static int getFieldSize() {
        return FIELD_SIZE;
    }

    public static int getShipAmount() {
        return SHIP_AMOUNT;
    }

    public void killShip() {
        killedShips++;
    }

    public String toStringMine() {
        return toStringBoth(true);
    }

    public String toStringOthers() {
        return toStringBoth(false);
    }

    public String toStringBoth(boolean isMine) {
        final String INIT_SYMBOL = "-";
        final String MISSED_SYMBOL = " ";
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

                switch(currentCell.getStatus()) {
                    case HIT:
                        stringBuilder.append(HIT_SYMBOL).append(" ");
                        break;
                    case KILLED:
                        stringBuilder.append(KILLED_SYMBOL).append(" ");
                        break;
                    case MISSED:
                        stringBuilder.append(MISSED_SYMBOL).append(" ");
                        break;
                    case OCCUPIED:
                        stringBuilder.append(OCCUPIED_SYMBOL).append(" ");
                        break;
                    default:
                        stringBuilder.append(INIT_SYMBOL).append(" ");

                }
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
