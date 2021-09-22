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

    @Override
    public String toString() {
        return name;
    }

    public void reduceHp() {
        hp--;
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


}
