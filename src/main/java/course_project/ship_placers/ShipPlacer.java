package course_project.ship_placers;

import course_project.enums.CellState;
import course_project.field_components.*;
import course_project.players.Player;
import course_project.enums.ShipKind;

import java.util.ArrayList;
import java.util.Arrays;
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

    List<Cell> lineToCells(Coordinate[] coordinates) {
        Arrays.sort(coordinates);
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i <= cellHandler.cellCount(coordinates); i++) {
            Coordinate temp = coordinates[0];
            if (cellHandler.sameLine(coordinates, true)) {
                cells.add(field.getCell(temp.row, temp.column + i));
            } else {
                cells.add(field.getCell(temp.row + i, temp.column));
            }
        }
        return cells;
    }

    boolean isFit(Coordinate[] coordinates, ShipKind kind) {
        List<Cell> cells = lineToCells(coordinates);
        boolean free = cells
                .stream()
                .allMatch(c -> c.checkState(CellState.EMPTY));
        if (free) {
            cells.forEach(c -> c.setState(CellState.DECK));
            playerShips.add(new Ship(kind, cells));
            return true;
        } else {
            return false;
        }
    }

    boolean tooClose(Coordinate[] coordinates) {
        return Arrays.stream(coordinates)
                .flatMap(coordinate -> field.getNeighbourCells(coordinate).stream())
                .anyMatch(cell -> cell.checkState(CellState.DECK));
    }
}
