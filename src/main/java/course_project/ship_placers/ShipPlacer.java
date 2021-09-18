package course_project.ship_placers;

import course_project.field_components.CellHandler;
import course_project.field_components.Field;
import course_project.players.Player;
import course_project.enums.ShipKind;

import java.util.List;

public abstract class ShipPlacer {
    final Field field;
    List<Ship> playerShips;
    protected final CellHandler cellHandler = new CellHandler();

    public ShipPlacer(Player player) {
        this.field = player.getField();
        this.playerShips = player.getPlayerShips();
    }

    public abstract void placeShips();


}
