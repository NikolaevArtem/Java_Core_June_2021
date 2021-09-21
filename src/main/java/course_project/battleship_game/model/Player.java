package course_project.battleship_game.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final Board board;
    private final int modeToCreateFleet;
    private final List<Cell> logOfMoves;

    public Player(String name, int modeToCreateFleet) {
        this.name = name;
        this.modeToCreateFleet = modeToCreateFleet;
        this.board = new Board();
        this.logOfMoves = new ArrayList<>();
    }

    public Board getBoard() {
        return board;
    }

    public String getName() {
        return name;
    }

    public List<Cell> getLogOfMoves() {
        return logOfMoves;
    }

    public int getModeToCreateFleet() {
        return modeToCreateFleet;
    }

}
