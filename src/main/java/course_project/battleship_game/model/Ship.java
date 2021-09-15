package course_project.battleship_game.model;

import course_project.battleship_game.service.CreateService;

import java.util.List;
import java.util.Objects;

public class Ship {
    private final ShipType type;
    private final List<Cell> cellsList;

    public Ship(Cell start, ShipType type, int direction) {
        this.type = type;
        this.cellsList = new CreateService().createShipCells(start, type, direction);
    }

    public ShipType getType() {
        return type;
    }

    public List<Cell> getCellsList() {
        return cellsList;
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
}
