package course_project.battleship_game.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ship {
    private final ShipType type;
    private final List<Cell> cellsList;

    public Ship(Cell start, ShipType type, int direction) {
        this.type = type;
        this.cellsList = generateShipCells(start, type, direction);
    }

    public ShipType getType() {
        return type;
    }

    public List<Cell> getCellsList() {
        return cellsList;
    }

    public boolean isHit(Cell cell) {
        if (cellsList.contains(cell)) {
            cellsList.get(cellsList.indexOf(cell)).setCellStatus(CellStatus.HIT);
            return true;
        }
        return false;
    }

    public boolean isNotAlive() {
        return cellsList.stream().allMatch(c -> c.getCellStatus().equals(CellStatus.HIT));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return getType() == ship.getType() &&
                getCellsList().equals(ship.getCellsList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getCellsList());
    }

    private List<Cell> generateShipCells(Cell start, ShipType type, int direction) {
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < type.getLength(); i++) {
            int x = direction == 1 ? start.getX() : start.getX() + i;
            int y = direction == 1 ? start.getY() + i : start.getY();
            cells.add(new Cell(x, y, CellStatus.SHIP));
        }
        return cells;
    }
}
