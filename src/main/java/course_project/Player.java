package course_project;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Player {
    private final Field field = new Field();
    private List<Ship> playerShips;
    boolean defeated = false;

    public abstract void placeShips();
    public abstract Coordinate move();

    public boolean takeAShot(Coordinate shot) {
        Ship target = playerShips.stream().filter(s -> s.containsCell(field.getCell(shot))).collect(Collectors.toList()).iterator().next();
    }

    public Field getField() {
        return field;
    }

    public void printField(boolean hideShips) {
        field.print(hideShips);
    }

}
