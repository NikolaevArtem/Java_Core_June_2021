package course_project.Utils.ShipPlacers;


import course_project.Utils.ConsoleHandling.InReader;
import course_project.Utils.ConsoleHandling.Printer;
import course_project.components.Coordinates;
import course_project.components.Field;
import course_project.components.Ship;
import course_project.enums.ShipType;

import java.util.ArrayList;
import java.util.List;

public class PlayerShipPlacer implements Placer {

    private final Printer printer = new Printer();
    private Field playerField = new Field();
    private List<Coordinates> allShipsCoordinates = new ArrayList<>();
    private final List<Coordinates> notAllowed = new ArrayList<>();
    private List<Ship> playerShips = new ArrayList<>(10);
    private ComputerShipPlacer computerShipPlacer = new ComputerShipPlacer();

    public List<Coordinates> getAllShipsCoordinates() {
        return allShipsCoordinates;
    }

    public List<Ship> getAllShips() {
        return playerShips;
    }

    // field auto creating in the auto case, no reader send in method
    @Override
    public Field placeShips() {
        playerField = computerShipPlacer.placeShips();
        playerShips = computerShipPlacer.getAllShips();
        allShipsCoordinates = computerShipPlacer.getAllShipsCoordinates();
        return playerField;
    }

    @Override
    public Field placeShips(InReader reader) {
        return placeShipsManually(reader);
    }


    private Field placeShipsManually(InReader reader) {
        Ship ship;

        for (ShipType type : ShipType.values()
        ) {
            for (int i = 1; i <= type.getCount(); i++) {
                ship = createShip(type, reader);
                playerShips.add(ship);
                ship.setHealth(type.getSize());
                playerField.placeShip(ship);
                printer.printOpenField(playerField);
                printer.printSep();
            }
        }


        return playerField;
    }

    private Ship createShip(ShipType type, InReader reader) {
        Ship ship;
        int size = type.getSize();

        List<Coordinates> coordinates;
        printer.printPlacing(type);
        coordinates = new ArrayList<>(getShipCoordinates(size, reader));
        ship = new Ship(type.getCount(), type, type.getSize(), coordinates);
        printer.printPlaced(type);
        allShipsCoordinates.addAll(coordinates);
        fillForbiddenCoordinates(coordinates, notAllowed);

        return ship;
    }

    private List<Coordinates> getShipCoordinates(int size, InReader reader) {
        List<Coordinates> shipCoordinates = new ArrayList<>();

        Coordinates firstDeck = getFirstDeck(reader);
        if (size == 1) {
            shipCoordinates.add(firstDeck);
            return shipCoordinates;
        } else {
            shipCoordinates = createRest(firstDeck, size, reader);
        }
        return shipCoordinates;

    }

    private Coordinates getFirstDeck(InReader reader) {

        Coordinates firstDeck;
        do {
            printer.askShipHead();
            firstDeck = reader.readCoordinates();
            if (!isValidCoordinatesOfPoint(allShipsCoordinates, notAllowed, firstDeck)) {
                printer.printInputError();
                printer.printSep();
            }
        }
        while (!isValidCoordinatesOfPoint(allShipsCoordinates, notAllowed, firstDeck));
        return firstDeck;
    }

    private List<Coordinates> createRest(Coordinates start, int size, InReader reader) {
        printer.printAskDestination();
        String destination = reader.getDestination();
        List<Coordinates> coordinatesList = new ArrayList<>();
        coordinatesList.add(start);

        coordinatesList = reader.getCoordinatesByDestination(start, size, destination);

        if (isValidCoordinatesOfList(allShipsCoordinates, notAllowed, coordinatesList)) {
            return coordinatesList;
        }
        System.out.println("Can not fill the ship in there, try again!");
        return createRest(start, size, reader);
    }

    public Field cleanField() {
        playerShips.clear();
        allShipsCoordinates.clear();
        notAllowed.clear();
        playerField = new Field();
        return playerField;
    }
}
