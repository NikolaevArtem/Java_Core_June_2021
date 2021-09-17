package course_project.players;

import course_project.ship_placers.Ship;
import course_project.enums.CellState;
import course_project.field_components.Cell;
import course_project.field_components.Coordinate;
import course_project.field_components.Field;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public abstract class Player {
    protected final Field field = new Field();
    protected final List<Ship> playerShips = new ArrayList<>();

    public abstract void placeShips(String mode);

    public abstract Coordinate move();

    public Ship takeAShot(Coordinate shot) {
        Cell cell = field.getCell(shot);
        Ship target = playerShips.stream().
                filter(s -> s.containsCell(cell)).
                findFirst().
                orElseThrow(() -> new RuntimeException("not a ship"));
        if (target.takeAShot(cell)) {
            target
                    .getCells()
                    .stream()
                    .flatMap(c -> new HashSet<>(field.getNeighbourCells(c.getCoordinate())).stream())
                    .filter(c -> c.getState().equals(CellState.EMPTY))
                    .forEach(c -> c.setState(CellState.MISS));
            }
        return target;
    }

    public Field getField() {
        return field;
    }

    public List<Ship> getPlayerShips() {
        return playerShips;
    }

    public boolean isDefeated() {
        return playerShips.stream().allMatch(Ship::isDestroyed);
    }

    public void printField(boolean hideShips) {
        field.print(hideShips);
    }

}
