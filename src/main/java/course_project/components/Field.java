package course_project.components;


import course_project.Utils.ShipPlacers.Placer;
import course_project.enums.State;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Field {
    final private int SIZE = 10;
    private String state;
    private final int[][] field = new int[SIZE][SIZE];

    public void placeShip(Ship ship) {
        for (Coordinates point : ship.getCoordinates()
        ) {
            field[point.getX()][point.getY()] = State.DECK.getState();
        }
    }

    public void placeMiss(Coordinates missCoordinate){
        field[missCoordinate.getX()][missCoordinate.getY()] = State.MISS.getState();
    }

    public void placeHit(Coordinates hitCoordinate){
        field[hitCoordinate.getX()][hitCoordinate.getY()] = State.HIT.getState();
    }

    public void placeEmpty(Coordinates empty){
        field[empty.getX()][empty.getY()] = State.EMPTY.getState();
    }



    public String getState() {
        return state;
    }

    public int[][] getField() {
        return field;
    }
}
