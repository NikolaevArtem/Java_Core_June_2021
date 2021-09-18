package course_project.components;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    private final int size;
    private final List<Coordinate> coordinates;
    private int health;
    private boolean sunk;

    public Ship(int size, List<Coordinate> coordinates) {
        health = size;
        this.size = size;
        this.coordinates = new ArrayList<>(coordinates);
    }

    public List<Coordinate> getCoordinates() {
        return new ArrayList<>(coordinates);
    }

    public void gotShot() {
        health--;
        if (health == 0) {
            sunk = true;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isSunk() {
        return sunk;
    }
}
