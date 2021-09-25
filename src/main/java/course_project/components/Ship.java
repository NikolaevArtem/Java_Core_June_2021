package course_project.components;

import course_project.enums.ShipType;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private final List<Coordinates> coordinates;
    public ShipType type;
    private int health;
    private boolean alive = true;


    public Ship(ShipType type, List<Coordinates> coordinates){
        this.type = type;
        this.coordinates = new ArrayList<>(coordinates);

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


    public boolean isAlive() {
        return alive;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }
}
