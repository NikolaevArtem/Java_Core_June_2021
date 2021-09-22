package course_project.models;

import java.util.ArrayList;
import java.util.HashSet;

public class Player {
    private static int count = 1;
    private String name;
    private ArrayList<Ship> ships;
    private Board mainBoard;
    private Board scanBoard;
    private HashSet<Coordinate> checkedCells;
    private int hp = 20; //default hp for whose set of ships

    public Player(String name) {
        this.name = name;
        ships = new ArrayList<>(10);
        mainBoard = new Board();
        scanBoard = new Board();
        checkedCells = new HashSet<>(40);
        count++;
    }

    public Player() {
        this.name = "Player " + count;
        ships = new ArrayList<>(10);
        mainBoard = new Board();
        scanBoard = new Board();
        checkedCells = new HashSet<>(40);
        count++;
    }

    public void reduceHp() {
        hp--;
    }

    public void setHp(int n) {
        this.hp = n;
    }

    public int hp() {
        return hp;
    }

    public String name() {
        return name;
    }

    public ArrayList<Ship> ships() {
        return ships;
    }

    public Board mainBoard() {
        return mainBoard;
    }

    public Board scanBoard() {
        return scanBoard;
    }

    public HashSet<Coordinate> checkedCells() {
        return checkedCells;
    }

}
