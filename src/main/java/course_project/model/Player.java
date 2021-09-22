package course_project.model;

import java.io.IOException;
import java.util.Scanner;

public class Player {

    private Battlefield myField;
    private Battlefield enemyField;
    private String name;
    private int shipsAmount;

    public Player() {
        myField = new Battlefield();
        enemyField = new Battlefield();
        shipsAmount = 10;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }



    public Designation[][] getGrid() {
        return myField.getGrid();
    }

    public Battlefield getField() {
        return this.myField;
    }

    public Battlefield getEnemyField() {
        return this.enemyField;
    }

    public void setMyField(Battlefield myField) {
        this.myField = myField;
    }

    public void setEnemyField(Battlefield enemyField) {
        this.enemyField = enemyField;
    }

    public int getShipsAmount() {
        return shipsAmount;
    }

    public void setShipsAmount(int shipsAmount) {
        this.shipsAmount = shipsAmount;
    }
}
