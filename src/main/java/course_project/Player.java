package course_project;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    protected final Field field = new Field();
    protected final List<Ship> playerShips = new ArrayList<>();

    public abstract void placeShips(ShipPlacer shipPlacer);

    public abstract Coordinate move();

    public boolean takeAShot(Coordinate shot) {
        Cell cell = field.getCell(shot);
        Ship target = playerShips.stream().
                filter(s -> s.containsCell(cell)).
                findFirst().
                orElseThrow(() -> new RuntimeException("not a ship"));
        return target.takeAShot(cell);
    }

    public boolean isDefeated() {
        return playerShips.stream().allMatch(Ship::isDestroyed);
    }

    public Field getField() {
        return field;
    }

    public void printField(boolean hideShips) {
        field.print(hideShips);
    }

}
