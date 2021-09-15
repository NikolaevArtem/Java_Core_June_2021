package course_project.battleship_game.model;

import java.util.Objects;

public class Cell {
    private final int x;
    private final int y;
    private CellStatus status;

    public Cell(int x, int y, CellStatus status) { //change in controller
        this.x = x;
        this.y = y;
        this.status = status;
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CellStatus getCellStatus() {
        return status;
    }

    public void setCellStatus(CellStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return getX() == cell.getX() &&
                getY() == cell.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public String toString() {
        return String.valueOf((char) (y + 65)) + (x + 1);
    }
}
