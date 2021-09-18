package course_project.util.ship_placer;

import course_project.components.Coordinate;
import course_project.components.PlayingField;
import course_project.components.Ship;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class ComputerShipPlacer implements ShipPlacer {

    private final Random randomGenerator = new Random();
    private PlayingField playingField;
    private int sizeOfShip;

    public void placeShips(PlayingField playingField) {
        this.playingField = playingField;
        placeShipsOfAllSizes();
    }

    private void placeShipsOfAllSizes() {
        for (sizeOfShip = 4; sizeOfShip >= 1; sizeOfShip--) {
            placeShipsOfCurrentSize();
        }
    }

    private void placeShipsOfCurrentSize() {
        for (int shipNumber = 0; shipNumber <= 4 - sizeOfShip; shipNumber++) {
            ArrayList<Coordinate> coordinatesList = generateCoordinates();
            Ship ship = new Ship(sizeOfShip, coordinatesList);
            playingField.placeShip(ship);
        }
    }

    private ArrayList<Coordinate> generateCoordinates() {
        ArrayList<Coordinate> shipCoordinates;
        Set<Coordinate> occupiedCells = playingField.getCoordinateMapping().keySet();

        do {
            boolean verticalOrientation = randomGenerator.nextInt(2) == 1;
            Coordinate topLeftPoint = createTopLeftPoint(verticalOrientation);
            shipCoordinates = createAllOtherCoordinates(topLeftPoint, verticalOrientation);
        } while (isShipCollidesOrAdjacent(shipCoordinates, occupiedCells));

        return shipCoordinates;
    }

    private Coordinate createTopLeftPoint(boolean vertOrientation) {
        Coordinate topLeft;
        do {
            int x = randomGenerator.nextInt(10);
            int y = randomGenerator.nextInt(10);
            topLeft = new Coordinate(x, y);
        } while (isNotValidForCurrentSizeOfShip(topLeft, vertOrientation, sizeOfShip));

        return topLeft;
    }

    private ArrayList<Coordinate> createAllOtherCoordinates(Coordinate topLeft, boolean verticalOrientation) {
        ArrayList<Coordinate> coordinatesList = new ArrayList<>();
        coordinatesList.add(topLeft);
        if (verticalOrientation) {
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
