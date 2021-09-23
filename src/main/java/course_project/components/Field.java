package course_project.components;


import course_project.enums.State;

import java.util.Arrays;

public class Field {
    final private int SIZE = 10;
    private String state;
    private final int[][] field = new int[SIZE][SIZE];

    public void place(Ship ship) {
        for (Coordinates point : ship.getCoordinates()
        ) {
            field[point.getX()][point.getY()] = State.DECK.getState();
        }
    }

    public String getState() {
        return state;
    }

    public int[][] getField() {
        return field;
    }
}
