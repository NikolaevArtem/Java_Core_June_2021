package course_project.objects.fields;

import course_project.enums.CellStatus;
import course_project.objects.Cell;

import java.util.Arrays;

public abstract class Field {

    protected final Cell[][] table = new Cell[10][10];

    public CellStatus getCellStatus(int x, int y) {
        return table[x][y].getStatus();
    }

    public void setCellStatus(int x, int y, CellStatus newStatus) {
        if (newStatus == CellStatus.HAS_SHIP) {
            table[x][y] = new Cell(newStatus, true);
        } else {
            table[x][y] = new Cell(newStatus, false);
        }
    }

    public void printField() {
        for (Cell[] row : table) {
            System.out.println(Arrays.toString(row));
        }
    }
}
