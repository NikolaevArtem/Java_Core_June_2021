package course_project.util.ship_placer;

import course_project.components.Coordinate;
import course_project.components.PlayingField;
import course_project.components.Ship;
import course_project.util.PlayingFieldPrinter;
import course_project.util.user_input_reader.UserShipInputReader;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class UserShipPlacer implements ShipPlacer {

    private final UserShipInputReader inputReader;
    private PlayingField playingField;
    private int sizeOfShip;

    public UserShipPlacer(Scanner scanner) {
        inputReader = new UserShipInputReader(scanner);
    }

    public void placeShips(PlayingField playingField) {
        new PlayingFieldPrinter().printField(playingField);
        this.playingField = playingField;
        placeShipsOfAllSizes();
    }

    private void placeShipsOfAllSizes() {
        System.out.println("Enter top left coordinates and orientation of the ship\n" +
                "in A-J 1-10 ver/hor format (e.g. A1 ver)\n");
        for (sizeOfShip = 4; sizeOfShip >= 1; sizeOfShip--) {
            System.out.println("Placing " + sizeOfShip + "-deck ships");
            placeShipsOfCurrentSize();
        }
    }

    private void placeShipsOfCurrentSize() {
        for (int shipNumber = 1; shipNumber <= 5 - sizeOfShip; shipNumber++) {
            ArrayList<Coordinate> coordinatesList = getCoordinatesFromInput(shipNumber);
            Ship ship = new Ship(sizeOfShip, coordinatesList);
            playingField.placeShip(ship);
        }
    }

    private ArrayList<Coordinate> getCoordinatesFromInput(int shipNumber) {
        Set<Coordinate> occupiedCells = playingField.getCoordinateMapping().keySet();
        System.out.println(shipNumber + " ship:");

        ArrayList<Coordinate> shipCoordinates = tryToGetCoordinates();
        while (isShipCollidesOrAdjacent(shipCoordinates, occupiedCells)) {
            System.out.println("Ship collides with or adjacent to another. Please repeat input");
            shipCoordinates = tryToGetCoordinates();
        }

        return shipCoordinates;
    }

    private ArrayList<Coordinate> tryToGetCoordinates() {
        Coordinate topLeftPoint = getTopLeftPoint();
        String orientation = inputReader.getOrientation();
        return createAllOtherCoordinates(topLeftPoint, orientation);
    }

    private Coordinate getTopLeftPoint() {
        boolean vertOrientation;
        Coordinate topLeft;

        topLeft = inputReader.getPointFromInput();
        vertOrientation = inputReader.getOrientation().equals("ver");
        while (isNotValidForCurrentSizeOfShip(topLeft, vertOrientation, sizeOfShip)) {
            System.out.println("Coordinate is invalid (ship doesn't fit into field). Please repeat input");
            topLeft = inputReader.getPointFromInput();
            vertOrientation = inputReader.getOrientation().equals("ver");
        }

        return topLeft;
    }

    private ArrayList<Coordinate> createAllOtherCoordinates(Coordinate topLeft, String orientation) {
        ArrayList<Coordinate> coordinatesList = new ArrayList<>();
        coordinatesList.add(topLeft);

        if (orientation.equalsIgnoreCase("ver")) {
            for (int i = 1; i < sizeOfShip; i++) {
                coordinatesList.add(new Coordinate(topLeft.getX() + i, topLeft.getY()));
            }
        } else {
            for (int i = 1; i < sizeOfShip; i++) {
                coordinatesList.add(new Coordinate(topLeft.getX(), topLeft.getY() + i));
            }
        }
        return coordinatesList;
    }

}
