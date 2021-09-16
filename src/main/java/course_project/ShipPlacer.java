package course_project;

import java.util.List;
import java.util.Scanner;

public abstract class ShipPlacer {
    final Field field;
    List<Ship> playerShips;
    protected final CellHandler cellHandler = new CellHandler();

    public ShipPlacer(Field field, List<Ship> playerShips) {
        this.field = field;
        this.playerShips = playerShips;
    }

    abstract void place(ShipKind kind);
}
