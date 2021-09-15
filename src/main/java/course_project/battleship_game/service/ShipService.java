package course_project.battleship_game.service;

import course_project.battleship_game.model.Cell;
import course_project.battleship_game.model.CellStatus;
import course_project.battleship_game.model.Ship;

public class ShipService {
    private final Ship ship;

    public ShipService(Ship ship) {
        this.ship = ship;
    }

    public boolean isHit(Cell cell) {
        if (ship.getCellsList().contains(cell)) {
            ship.getCellsList().get(ship.getCellsList().indexOf(cell)).setCellStatus(CellStatus.HIT);
            return true;
        }
        return false;
    }

    public boolean isNotAlive() {
        return ship.getCellsList().stream().allMatch(c -> c.getCellStatus().equals(CellStatus.HIT));
    }

}
