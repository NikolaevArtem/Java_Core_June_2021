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
    private int hp = 20;

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


    public static void setCount(int count) {
        Player.count = count;
    }

    public String Name() {
        return name;
    }

    public ArrayList<Ship> Ships() {
        return ships;
    }

    public Board MainBoard() {
        return mainBoard;
    }

    public Board ScanBoard() {
        return scanBoard;
    }

    public HashSet<Coordinate> CheckedCells() {
        return checkedCells;
    }

    public void reduceHp() {
        hp--;
    }

    public int Hp() {
        return hp;
    }
}
