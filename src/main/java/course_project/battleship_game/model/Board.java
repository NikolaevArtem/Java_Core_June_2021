package course_project.battleship_game.model;

import course_project.battleship_game.service.CreateService;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final Cell[][] boardMatrix;
    private final List<Ship> shipList;

    public Board() {
        this.boardMatrix = new CreateService().createBoard();
        this.shipList = new ArrayList<>();
    }

    public Cell[][] getBoardMatrix() {
        return boardMatrix;
    }

    public List<Ship> getShipList() {
        return shipList;
    }

}
