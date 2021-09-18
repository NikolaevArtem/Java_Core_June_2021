package course_project.ship_placers;

import course_project.SeaBattle;
import course_project.enums.CellState;
import course_project.field_components.Cell;
import course_project.field_components.Coordinate;
import course_project.players.Player;
import course_project.enums.ShipKind;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomShipPlacer extends ShipPlacer {

    public RandomShipPlacer(Player player) {
        super(player);
    }

    @Override
    public void placeShips() {
        for (ShipKind sk : ShipKind.values()) {
            int count = sk.getCount();
            while (count > 0) {
                place(sk);
                count--;
            }
        }
    }

    private void place(ShipKind kind) {
        if (kind.getLength() == 1) {
            while(true) {
                Coordinate point = randomCoordinate();
                if (isAvailable(point) && !tooClose(point)) {
                    List<Cell> cells = Collections.singletonList(field.getCell(point));
                    playerShips.add(new Ship(kind, cells));
                    break;
                }
            }
        }
    }

    private boolean isAvailable(Coordinate point) {
        return field.getCell(point).checkState(CellState.EMPTY);
    }

    private Coordinate randomCoordinate() {
        Random random = new Random(System.nanoTime());
        int row = random.nextInt(SeaBattle.FIELD_SIZE);
        int column = random.nextInt(SeaBattle.FIELD_SIZE);
        return Coordinate.get(row, column);
    }

    private boolean tooClose(Coordinate coordinate) {
        return field
                .getNeighbourCells(coordinate)
                .stream()
                .anyMatch(c -> c.getState().equals(CellState.DECK));
    }

}
