package course_project;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    protected final Field field = new Field();
    protected final List<Ship> playerShips = new ArrayList<>();

    public abstract void placeShips(ShipPlacer shipPlacer);

    public abstract Coordinate move();

    public Ship takeAShot(Coordinate shot) {
        Cell cell = field.getCell(shot);
        Ship target = playerShips.stream().
                filter(s -> s.containsCell(cell)).
                findFirst().
                orElseThrow(() -> new RuntimeException("not a ship"));
        if (target.takeAShot(cell)) {
            field.getNeighbourCells(shot)
                    .stream()
                    .filter(c -> c.getState().equals(CellState.EMPTY))
                    .forEach(c -> c.setState(CellState.MISS));
            }
        return target;
    }

    public boolean isDefeated() {
        return playerShips.stream().allMatch(Ship::isDestroyed);
    }

    public void printField(boolean hideShips) {
        field.print(hideShips);
    }

}
