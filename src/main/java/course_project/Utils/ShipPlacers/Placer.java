package course_project.Utils.ShipPlacers;

import course_project.Utils.ConsoleHandling.InReader;
import course_project.components.Coordinates;
import course_project.components.Field;

import java.util.ArrayList;
import java.util.List;

public interface Placer {
    Field placeShips();

    Field placeShips(InReader reader);

    default boolean isValidCoordinatesOfPoint(List<Coordinates> listShips, List<Coordinates> listAdjusted, Coordinates point) {
        return !listShips.contains(point) && !listAdjusted.contains(point) &&
                (point.getY() >= 0 && point.getY() <= 9) && (point.getX() >= 0 && point.getX() <= 9);
    }

    default boolean isValidCoordinatesOfList(List<Coordinates> listShips, List<Coordinates> listAdjusted, List<Coordinates> coordinates) {
        for (Coordinates point : coordinates
        ) {
            if (!isValidCoordinatesOfPoint(listShips, listAdjusted, point)) {
                return false;
            }
        }
        return true;
    }

    default List<Coordinates> fillForbiddenCoordinates(List<Coordinates> shipCoordinates, List<Coordinates> notAllowed) {
        for (Coordinates coord : shipCoordinates
        ) {
            int x = coord.getX();
            int y = coord.getY();
            List<Coordinates> rawNotAdd = new ArrayList<>();
            Coordinates c1 = new Coordinates(x + 1, y + 1);
            rawNotAdd.add(c1);
            Coordinates c2 = new Coordinates(x + 1, y);
            rawNotAdd.add(c2);
            Coordinates c3 = new Coordinates(x + 1, y - 1);
            rawNotAdd.add(c3);
            Coordinates c4 = new Coordinates(x, y + 1);
            rawNotAdd.add(c4);
            Coordinates c5 = new Coordinates(x, y - 1);
            rawNotAdd.add(c5);
            Coordinates c6 = new Coordinates(x - 1, y + 1);
            rawNotAdd.add(c6);
            Coordinates c7 = new Coordinates(x - 1, y);
            rawNotAdd.add(c7);
            Coordinates c8 = new Coordinates(x - 1, y - 1);
            rawNotAdd.add(c8);

            for (Coordinates c : rawNotAdd
            ) {
                if (!notAllowed.contains(c)) {
                    notAllowed.add(c);
                }
            }
        }
        return notAllowed;
    }


}
