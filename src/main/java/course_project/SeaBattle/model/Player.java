package course_project.SeaBattle.model;

import java.util.List;

public class Player {
    private String name;
    private Grid grid;
    private List<Ship> shipList;
    private Player enemy;
    private int remainingAliveSquares;
    private boolean isComputer;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ship> getShipList() {
        return shipList;
    }

    public void setShipList(List<Ship> shipList) {
        this.shipList = shipList;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public Player getEnemy() {
        return enemy;
    }

    public void setEnemy(Player enemy) {
        this.enemy = enemy;
    }

    public int getRemainingAliveSquares() {
        return remainingAliveSquares;
    }

    public void setRemainingAliveSquares(int remainingAliveSquares) {
        this.remainingAliveSquares = remainingAliveSquares;
    }

    public boolean isComputer() {
        return isComputer;
    }

    public void setComputer(boolean computer) {
        isComputer = computer;
    }
}
