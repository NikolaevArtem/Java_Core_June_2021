package course_project.ship_placers;

import course_project.SeaBattle;
import course_project.field_components.Coordinate;
import course_project.players.Player;
import course_project.enums.ShipKind;

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
        while(true) {
            Coordinate[] coordinates = randomCoordinate(kind);
            if (!tooClose(coordinates) && isFit(coordinates, kind)) {
                break;
            }
        }
    }


    private Coordinate[] randomCoordinate(ShipKind kind) {
        Random random = new Random(System.nanoTime());
        int row = random.nextInt(SeaBattle.FIELD_SIZE);
        int column = random.nextInt(SeaBattle.FIELD_SIZE);
        if (kind.getLength() == 1) {
            return new Coordinate[] {Coordinate.get(row, column)};
        } else {
            Coordinate start = Coordinate.get(row, column);
            Coordinate end = generateNext(start, kind.getLength() - 1, random.nextBoolean());
            return new Coordinate[] {start, end};
        }
    }

    private Coordinate generateNext(Coordinate previous, int length, boolean sameRow) {
        if (sameRow) {
            int column = previous.column;
            if (column + length >= SeaBattle.FIELD_SIZE) {
                length = -length;
            }
            return Coordinate.get(previous.row, column + length);
        } else {
            int row = previous.row;
            if (row + length >= SeaBattle.FIELD_SIZE) {
                length = -length;
            }
            return Coordinate.get(row + length, previous.column);
        }
    }
}
