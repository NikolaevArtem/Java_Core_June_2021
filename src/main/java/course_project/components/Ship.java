package course_project.components;

import course_project.enums.ShipType;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private final List<Coordinates> coordinates;
    public ShipType type;
    private int health;
    private final int size;
    private boolean alive = true;


    public Ship(ShipType type, List<Coordinates> coordinates){
        this.size = type.getSize();
        this.health = size;
        this.coordinates = new ArrayList<>(coordinates);
        this.type = type;

    }

    public List<Coordinates> getCoordinates() {
        return new ArrayList<>(coordinates);
    }
    public void gotShot() {
        health--;
        if (health == 0) {
            alive = false;
        }
    }

    public ShipType getType() {
        return this.type;
    }

    public int getSize() {
        return size;
    }

    public boolean isAlive() {
        return alive;
    }



}
