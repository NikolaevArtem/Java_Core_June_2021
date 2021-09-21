package course_project.battleship_game.model;

import java.util.ArrayList;
import java.util.List;

import static course_project.battleship_game.utils.Constants.BOARD_SIZE;

public class Board {
    private final Cell[][] boardMatrix;
    private final List<Ship> shipList;

    public Board() {
        this.boardMatrix = createBoard();
        this.shipList = new ArrayList<>();
    }

    public Cell[][] getBoardMatrix() {
        return boardMatrix;
    }

    public List<Ship> getShipList() {
        return shipList;
    }

    private Cell[][] createBoard() {
        Cell[][] boardMatrix = new Cell[BOARD_SIZE][BOARD_SIZE];
        for (int y = 0; y < BOARD_SIZE; y++) {
            for (int x = 0; x < BOARD_SIZE; x++) {
                boardMatrix[y][x] = new Cell(x, y, CellStatus.EMPTY);
            }
        }
        return boardMatrix;
    }

}
