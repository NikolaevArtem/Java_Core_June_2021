package course_project;

import java.util.List;

public abstract class ShipPlacer {
    final Field field;
    List<Ship> playerShips;
    protected final CellHandler cellHandler = new CellHandler();

    public ShipPlacer(Player player) {
        this.field = player.field;
        this.playerShips = player.playerShips;
    }

    abstract void place(ShipKind kind);
}
