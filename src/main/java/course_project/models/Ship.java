package course_project.models;

import java.util.ArrayList;

public class Ship {
    private String name;
    private int hp;
    private int size;
    private ArrayList<Coordinate> coords;

    public Ship(String name, int size) {
        this.name = name;
        this.size = size;
        this.hp = size;
        this.coords = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public int getSize() {
        return size;
    }


    public ArrayList<Coordinate> getCoords() {
        return coords;
    }

    public void setCoords(ArrayList<Coordinate> coords) {
        this.coords = coords;
    }

    public void decreaseHp() {
        hp--;
    }

    @Override
    public String toString() {
        return name;
    }
}
