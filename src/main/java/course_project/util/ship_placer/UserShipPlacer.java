package course_project.util.ship_placer;

import course_project.components.Coordinate;
import course_project.components.PlayingField;
import course_project.components.Ship;
import course_project.util.PlayingFieldPrinter;
import course_project.util.UserInputReader;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class UserShipPlacer implements ShipPlacer {

    private final UserInputReader inputReader;
    private PlayingField playingField;
    private int sizeOfShip;

    public UserShipPlacer(Scanner scanner) {
        inputReader = new UserInputReader(scanner);
    }

    public void placeShips(PlayingField playingField) {
        try {
            new PlayingFieldPrinter().printField(playingField);
            this.playingField = playingField;
            placeShipsOfAllSizes();
        } catch (InputMismatchException e) {
            throw new RuntimeException("Invalid input format", e);
        }
    }

    private void placeShipsOfAllSizes() {
        System.out.println("Enter top left coordinates and orientation of the ship\n" +
                "in A-J 1-10 ver/hor format (e.g. A 1 ver)");
        for (sizeOfShip = 4; sizeOfShip >= 1; sizeOfShip--) {
            System.out.println("Placing " + sizeOfShip + "-deck ships");
            placeShipsOfCurrentSize();
        }
    }

    private void placeShipsOfCurrentSize() {
        for (int shipNumber = 0; shipNumber <= 4 - sizeOfShip; shipNumber++) {
            ArrayList<Coordinate> coordinatesList = getCoordinatesFromInput(shipNumber);
            Ship ship = new Ship(sizeOfShip, coordinatesList);
            playingField.placeShip(ship);
        }
    }

    private ArrayList<Coordinate> getCoordinatesFromInput(int shipNumber) {
        ArrayList<Coordinate> shipCoordinates;
        Set<Coordinate> occupiedCells = playingField.getCoordinateMapping().keySet();

        System.out.println(shipNumber + 1 + " ship: ");
        do {
            Coordinate topLeftPoint = getTopLeftPoint();
            String orientation = inputReader.getOrientation();
            shipCoordinates = createAllOtherCoordinates(topLeftPoint, orientation);
        } while (isShipCollidesOrAdjacent(shipCoordinates, occupiedCells));

        return shipCoordinates;
    }

    private Coordinate getTopLeftPoint() {
        int x;
        int y;
        boolean vertOrientation;
        Coordinate topLeft;
        do {
            inputReader.getInput();
            x = inputReader.getX();
            y = inputReader.getY();
            vertOrientation = inputReader.getOrientation().equals("ver");
            topLeft = new Coordinate(x, y);
        } while (!isValidForCurrentSizeOfShip(topLeft, vertOrientation, sizeOfShip));

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
