package course_project.ship_placers;

import course_project.enums.CellState;
import course_project.enums.ShipKind;
import course_project.field_components.Cell;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private final List<Cell> cells;
    private int decks;

    public Ship(ShipKind kind, List<Cell> cells) {
        this.decks = kind.ordinal() + 1;
        this.cells = new ArrayList<>(cells);
        cells.forEach(c -> c.setState(CellState.DECK));
    }

    public boolean containsCell(Cell cell) {
        return cells.contains(cell);
    }

    public boolean takeAShot(Cell cell) {
        if (!isDestroyed()) {
            cell.setState(CellState.HIT);
            decks--;
        }
        return isDestroyed();
    }

    public boolean isDestroyed() {
        return decks == 0;
    }

    public List<Cell> getCells() {
        return cells;
    }
}
