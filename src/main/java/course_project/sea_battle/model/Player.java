package course_project.sea_battle.model;

import course_project.sea_battle.model.boards.MyBoard;
import course_project.sea_battle.model.boards.MyShots;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private MyBoard myBoard;
    private MyShots myShots;
    private final List<Ship> myShips = new ArrayList<>();

    public Player(MyBoard myBoard, MyShots enemyBoard) {
        this.myBoard = myBoard;
        this.myShots = enemyBoard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ship> getMyShips() {
        return myShips;
    }

    public MyBoard getMyBoard() {
        return myBoard;
    }

    public MyShots getMyShots() {
        return myShots;
    }

}
