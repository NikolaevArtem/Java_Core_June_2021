package course_project.Utils.ShipPlacers;


import course_project.Utils.ConsoleHandling.InReader;
import course_project.Utils.ConsoleHandling.Printer;
import course_project.components.Coordinates;
import course_project.components.Field;
import course_project.components.Ship;
import course_project.enums.ShipType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerShipPlacer implements Placer {

    private final Printer printer = new Printer();
    private Field playerField = new Field();
    private final List<Coordinates> allShipsCoordinates = new ArrayList<>();
    private final List<Coordinates> notAllowed = new ArrayList<>();

    private List<Ship> allShips = new ArrayList<>(10);

    @Override
    public Field placeShips() {
        return new ComputerShipPlacer().placeShips();
    }

    @Override
    public Field placeShips(InReader reader) {
        return placeShipsManually(reader);
    }
    private Field placeShipsManually(InReader reader) {

        allShips = createAllShips(reader);

        for (Ship ship : allShips
        ) {
            playerField.place(ship);
        }

        return playerField;
    }

    private List<Ship> createAllShips(InReader reader) {

        for (ShipType type : ShipType.values()
        ) {

            for (int i = 1; i <= type.getCount(); i++) {
                List<Coordinates> coordinates;
                printer.printPlacing(type);

                coordinates = new ArrayList<>(getShipCoordinates(i, reader));
                Ship ship = new Ship(type, coordinates);

                allShips.add(ship);

                printer.printPlaced(type);

                allShipsCoordinates.addAll(coordinates);
                fillForbiddenCoordinates(coordinates, notAllowed);
            }
        }
        return allShips;
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
        printer.askShipHead();
        printer.printYouField(playerField);
        Coordinates firstDeck;
        do {
            firstDeck = reader.readCoordinates();
            if (!isValidCoordinatesOfPoint(allShipsCoordinates, notAllowed, firstDeck)){
                printer.printInputError();
            }
        }
        while (!isValidCoordinatesOfPoint(allShipsCoordinates, notAllowed, firstDeck));
        return firstDeck;
    }

    private List<Coordinates> createRest(Coordinates start, int size, InReader reader) {
        printer.printAskDestination();
        List<Coordinates> coordinatesList = new ArrayList<>();
        coordinatesList.add(start);
        coordinatesList = reader.getCoordinatesByDestination(start, size);
        if(!isValidCoordinatesOfList(allShipsCoordinates, notAllowed, coordinatesList)){
            printer.printInputError();
        }

        return coordinatesList;
    }
}
