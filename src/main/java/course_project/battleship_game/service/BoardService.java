package course_project.battleship_game.service;

import course_project.battleship_game.model.Board;
import course_project.battleship_game.model.Cell;
import course_project.battleship_game.model.CellStatus;
import course_project.battleship_game.model.Ship;
import course_project.battleship_game.model.ShipType;

import java.util.List;

import static course_project.battleship_game.utils.Constants.BOARD_SIZE;

public class BoardService {
    private final Board board;

    public BoardService(Board board) {
        this.board = board;
    }

    public boolean isHitCellOnBoard(Cell cell) {
        Ship shipResult = board.getShipList().stream()
                .filter(ship ->
                        ship.getCellsList().stream()
                                .anyMatch(cell1 -> cell1.equals(cell))).findFirst().orElse(null);
        boolean hit = false;
        if (shipResult != null) {
            hit = new ShipService(shipResult).isHit(cell);
        }
        if (!hit) {
            board.getBoardMatrix()[cell.getY()][cell.getX()].setCellStatus(CellStatus.MISSED);
        }
        return hit;
    }

    public boolean isCreatingShipSuccessful(Cell start, ShipType type, int direction) {
        if (isShipValidForBoard(start, type, direction)) {
            Ship ship = new Ship(start, type, direction);
            board.getShipList().add(ship);
            addShipToBoardMatrix(ship);
            markBoardCellsAroundShip(ship);
            return true;
        }
        return false;
    }

    private void addShipToBoardMatrix(Ship ship) {
        for (Cell cell : ship.getCellsList()) {
            int x = cell.getX();
            int y = cell.getY();
            board.getBoardMatrix()[y][x] = cell;
        }
    }

    private void markBoardCellsAroundShip(Ship ship) {
        List<Cell> cells = ship.getCellsList();
        for (Cell cell : cells) {
            int x = cell.getX();
            int y = cell.getY();
            if (x + 1 < BOARD_SIZE &&
                    board.getBoardMatrix()[y][x + 1].getCellStatus().equals(CellStatus.EMPTY)) {
                board.getBoardMatrix()[y][x + 1].setCellStatus(CellStatus.SHIP_BORDER);
            }
            if (x + 1 < BOARD_SIZE && y - 1 >= 0 &&
                    board.getBoardMatrix()[y - 1][x + 1].getCellStatus().equals(CellStatus.EMPTY)) {
                board.getBoardMatrix()[y - 1][x + 1].setCellStatus(CellStatus.SHIP_BORDER);
            }
            if (x + 1 < BOARD_SIZE && y + 1 < BOARD_SIZE &&
                    board.getBoardMatrix()[y + 1][x + 1].getCellStatus().equals(CellStatus.EMPTY)) {
                board.getBoardMatrix()[y + 1][x + 1].setCellStatus(CellStatus.SHIP_BORDER);
            }
            if (x - 1 >= 0 &&
                    board.getBoardMatrix()[y][x - 1].getCellStatus().equals(CellStatus.EMPTY)) {
                board.getBoardMatrix()[y][x - 1].setCellStatus(CellStatus.SHIP_BORDER);
            }
            if (x - 1 >= 0 && y - 1 >= 0 &&
                    board.getBoardMatrix()[y - 1][x - 1].getCellStatus().equals(CellStatus.EMPTY)) {
                board.getBoardMatrix()[y - 1][x - 1].setCellStatus(CellStatus.SHIP_BORDER);
            }
            if (x - 1 >= 0 && y + 1 < BOARD_SIZE &&
                    board.getBoardMatrix()[y + 1][x - 1].getCellStatus().equals(CellStatus.EMPTY)) {
                board.getBoardMatrix()[y + 1][x - 1].setCellStatus(CellStatus.SHIP_BORDER);
            }
            if (y + 1 < BOARD_SIZE &&
                    board.getBoardMatrix()[y + 1][x].getCellStatus().equals(CellStatus.EMPTY)) {
                board.getBoardMatrix()[y + 1][x].setCellStatus(CellStatus.SHIP_BORDER);
            }
            if (y - 1 >= 0 &&
                    board.getBoardMatrix()[y - 1][x].getCellStatus().equals(CellStatus.EMPTY)) {
                board.getBoardMatrix()[y - 1][x].setCellStatus(CellStatus.SHIP_BORDER);
            }
        }
    }

    private boolean isShipValidForBoard(Cell start, ShipType type, int direction) {
        if (isTypeNotEnoughInBoardShipList(type) && isShipCellsFitBoard(start, type, direction)) {
            Ship ship = new Ship(start, type, direction);
            return !board.getShipList().contains(ship);
        }
        return false;
    }

    private boolean isShipCellsFitBoard(Cell start, ShipType type, int direction) {
        Ship ship = new Ship(start, type, direction);
        List<Cell> cells = ship.getCellsList();
        for (Cell cell : cells) {
            if (cell.getX() < 0 || cell.getY() < 0 || cell.getX() >= board.getBoardMatrix().length ||
                    cell.getY() >= board.getBoardMatrix().length) {
                return false;
            }
            if (!(board.getBoardMatrix()[cell.getY()][cell.getX()]).getCellStatus().equals(CellStatus.EMPTY)) {
                return false;
            }
        }
        return true;
    }

    private boolean isTypeNotEnoughInBoardShipList(ShipType type) {
        int count = (int) board.getShipList().stream().filter(ship -> ship.getType().equals(type)).count();
        return count < type.getAmount();
    }

}
