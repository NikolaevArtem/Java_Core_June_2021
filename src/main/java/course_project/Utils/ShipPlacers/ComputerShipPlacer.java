package course_project.Utils.ShipPlacers;

import course_project.Utils.ConsoleHandling.InReader;
import course_project.components.Coordinates;
import course_project.components.Field;
import course_project.components.Ship;
import course_project.enums.ShipType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerShipPlacer implements Placer {
    private final Random random = new Random();
    private Field computerField = new Field();
    private final List<Coordinates> allShipsCoordinates = new ArrayList<>();
    private final List<Coordinates> notAllowed = new ArrayList<>();
    private List<Ship> allShips = new ArrayList<>(10);

    public List<Coordinates> getAllShipsCoordinates() {
        return allShipsCoordinates;
    }

    public List<Ship> getAllShips() {
        return allShips;
    }

    private List<Ship> createAllShips() {

        for (ShipType type : ShipType.values()
        ) {
            for (int i = 1; i <= type.getCount(); i++) {
                List<Coordinates> coordinates;
                int size = type.getSize();
                do {
                    coordinates = new ArrayList<>(generateShipCoordinates(size));
                } while (!isValidCoordinatesOfList(allShipsCoordinates, notAllowed, coordinates));

                Ship ship = new Ship(i, type, type.getSize(), coordinates);

                allShips.add(ship);
                allShipsCoordinates.addAll(coordinates);
                fillForbiddenCoordinates(coordinates, notAllowed);
            }
        }
        return allShips;
    }

    @Override
    public Field placeShips() {
        allShips = createAllShips();
        for (Ship ship : allShips
        ) {
            computerField.placeShip(ship);
        }

        return computerField;
    }

    @Override
    public Field placeShips(InReader reader) {
        throw new UnsupportedOperationException("Not supported for ComputerShipPlacer!");
    }


    private ArrayList<Coordinates> generateShipCoordinates(int size) {
        ArrayList<Coordinates> shipCoordinates = new ArrayList<>();
        Coordinates start = getFirstDeck();
        if (size == 1) {
            shipCoordinates.add(start);
            return shipCoordinates;
        } else {
            shipCoordinates = createRest(start, size);
        }
        return shipCoordinates;

    }

    private Coordinates getFirstDeck() {
        Coordinates firstDeck;
        do {
            int x = random.nextInt(10);
            int y = random.nextInt(10);

            firstDeck = new Coordinates(x, y);
        }
        while (!isValidCoordinatesOfPoint(allShipsCoordinates, notAllowed, firstDeck));
        return firstDeck;
    }


    private ArrayList<Coordinates> createRest(Coordinates start, int size) {
        ArrayList<Coordinates> coordinatesList = new ArrayList<>();
        coordinatesList.add(start);

        if (random.nextBoolean()) {
            for (int i = 1; i < size; i++) {
                coordinatesList.add(new Coordinates(start.getX() + i, start.getY()));
            }
        } else for (int i = 1; i < size; i++) {
            coordinatesList.add(new Coordinates(start.getX(), start.getY() + i));
        }
        return coordinatesList;
    }

    public Field cleanField() {
        allShips.clear();
        allShipsCoordinates.clear();
        notAllowed.clear();
        computerField = new Field();
        return computerField;
    }

}

