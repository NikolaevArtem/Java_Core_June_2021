package course_project.sea_battle.model;

public class Field {
    public static final int FIELD_SIZE = 10;
    private final CellStatus[][] cells = new CellStatus[FIELD_SIZE][FIELD_SIZE];

    public CellStatus[][] getCells() {
        return cells;
    }

    public CellStatus getCell(int x, int y) {
        return cells[y][x];
    }

    public void setCell(int x, int y, CellStatus status) {
        cells[y][x] = status;
    }
}
