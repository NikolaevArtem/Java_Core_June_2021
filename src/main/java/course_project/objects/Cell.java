package course_project.objects;

import course_project.enums.CellStatus;

import static course_project.enums.CellStatus.FREE;
import static course_project.enums.CellStatus.HAS_SHIP;

public class Cell {

    private final CellStatus status;
    private final boolean gotShip;

    public Cell(CellStatus status, boolean gotShip) {
        this.status = status;
        this.gotShip = gotShip;
    }

    public CellStatus getStatus() {
        return status;
    }

    public boolean hadShip() {
        return gotShip;
    }

    @Override
    public String toString() {
        if (status == FREE) {
            return " ";
        }
        if (status == HAS_SHIP) {
            return "X";
        }
        return ".";
    }
}
