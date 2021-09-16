package course_project.util.ship_placer;

import course_project.components.Coordinate;
import course_project.components.PlayingField;

import java.util.ArrayList;
import java.util.Set;

public interface ShipPlacer {

    void placeShips(PlayingField playingField);

    default boolean isShipCollidesOrAdjacent(ArrayList<Coordinate> shipCoordinates, Set<Coordinate> occupiedCells) {
        for (Coordinate c : shipCoordinates) {
            if (occupiedCells.contains(c) || isAdjacentToOccupiedCell(c, occupiedCells)) {
                return true;
            }
        }
        return false;
    }

    default boolean isAdjacentToOccupiedCell(Coordinate shipsCoordinate, Set<Coordinate> occupiedCells) {
        ArrayList<Coordinate> adjacentCoordinates = new ArrayList<>();

        if (shipsCoordinate.getX() > 0) {
            adjacentCoordinates.add(new Coordinate(shipsCoordinate.getX() - 1, shipsCoordinate.getY()));
        }
        if (shipsCoordinate.getX() < 9) {
            adjacentCoordinates.add(new Coordinate(shipsCoordinate.getX() + 1, shipsCoordinate.getY()));
        }
        if (shipsCoordinate.getY() > 0) {
            adjacentCoordinates.add(new Coordinate(shipsCoordinate.getX(), shipsCoordinate.getY() - 1));
        }
        if (shipsCoordinate.getY() < 9) {
            adjacentCoordinates.add(new Coordinate(shipsCoordinate.getX(), shipsCoordinate.getY() + 1));
        }
        for (Coordinate adjacentCoordinate : adjacentCoordinates) {
            if (occupiedCells.contains(adjacentCoordinate)) {
                return true;
            }
        }
        return false;
    }

    // Make sure there is enough room for ship
    default boolean isValidForCurrentSizeOfShip(Coordinate cell, boolean verticalOrientation, int sizeOfShip) {
        return ((cell.getX() <= (10 - sizeOfShip)) && verticalOrientation)
                || ((cell.getY() <= (10 - sizeOfShip)) && !verticalOrientation);
    }
}
