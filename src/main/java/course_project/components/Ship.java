package course_project.components;

import course_project.enums.ShipType;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private final List<Coordinates> coordinates;
    private final int count;
    private final ShipType type;
    private final int size;
    private int health;
    private boolean alive = true;


    public Ship(int count, ShipType type, int size, List<Coordinates> coordinates) {
        this.count = count;
        this.type = type;
        this.size = size;
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

    @Override
    public String toString() {
        return "Ship{" +
                "coordinates=" + coordinates +
                ", count=" + count +
                ", type=" + type +
                ", size=" + size +
                ", health=" + health +
                ", alive=" + alive +
                '}';
    }

    public ShipType getType() {
        return type;
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
