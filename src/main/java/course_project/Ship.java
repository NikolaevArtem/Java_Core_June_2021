package course_project;

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

    boolean isDestroyed() {
        return decks == 0;
    }
}
