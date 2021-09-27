package course_project.components;

import course_project.enums.State;

public class Field {
    final private int SIZE = 10;
    private final int[][] field = new int[SIZE][SIZE];

    public void placeShip(Ship ship) {
        for (Coordinates point : ship.getCoordinates()
        ) {
            field[point.getX()][point.getY()] = State.DECK.getState();
        }
    }

    public void placeMiss(Coordinates missCoordinate) {
        field[missCoordinate.getX()][missCoordinate.getY()] = State.MISS.getState();
    }

    public void placeHit(Coordinates hitCoordinate) {
        field[hitCoordinate.getX()][hitCoordinate.getY()] = State.HIT.getState();
    }

    public int[][] getField() {
        return field;
    }
}
