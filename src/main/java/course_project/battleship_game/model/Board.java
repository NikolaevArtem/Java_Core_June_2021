package course_project.battleship_game.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int BOARD_SIZE = 10;
    private final Cell[][] boardMatrix;
    private final List<Ship> shipList;

    public Board() {
        this.boardMatrix = createBoard();
        this.shipList = new ArrayList<>();
    }

    public Cell[][] getBoardMatrix() {
        return boardMatrix;
    }

    public boolean isNoMoreAliveShipsForBoard() {
        return shipList.stream().allMatch(Ship::isNotAlive);
    }

    public long countRemainedShips() {
        return shipList.stream().filter(ship -> !ship.isNotAlive()).count();
    }

    public boolean isCreatingShipSuccessful(Cell start, ShipType type, int direction) {
        if (isShipValidForBoard(start, type, direction)) {
            Ship ship = new Ship(start, type, direction);
            shipList.add(ship);
            addShipToBoardMatrix(ship);
            markAreaAroundShip(ship);
            return true;
        }
        return false;
    }

    public boolean isMoveSuccessful(Cell cell) {
        Ship shipResult = shipList.stream()
                .filter(ship ->
                        ship.getCellsList().stream()
                                .anyMatch(cell1 -> cell1.equals(cell))).findFirst().orElse(null);
        boolean hit = shipResult != null && shipResult.isHit(cell);
        if (!hit) {
            boardMatrix[cell.getY()][cell.getX()].setCellStatus(CellStatus.MISSED);
        }
        return hit;
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

    private void addShipToBoardMatrix(Ship ship) {
        for (Cell cell : ship.getCellsList()) {
            int x = cell.getX();
            int y = cell.getY();
            boardMatrix[y][x] = cell;
        }
    }

    private void markAreaAroundShip(Ship ship) {
        List<Cell> cells = ship.getCellsList();
        for (Cell cell : cells) {
            int x = cell.getX();
            int y = cell.getY();
            if (x + 1 < BOARD_SIZE &&
                    boardMatrix[y][x + 1].getCellStatus().equals(CellStatus.EMPTY)) {
                boardMatrix[y][x + 1].setCellStatus(CellStatus.SHIP_BORDER);
            }
            if (x + 1 < BOARD_SIZE && y - 1 >= 0 &&
                    boardMatrix[y - 1][x + 1].getCellStatus().equals(CellStatus.EMPTY)) {
                boardMatrix[y - 1][x + 1].setCellStatus(CellStatus.SHIP_BORDER);
            }
            if (x + 1 < BOARD_SIZE && y + 1 < BOARD_SIZE &&
                    boardMatrix[y + 1][x + 1].getCellStatus().equals(CellStatus.EMPTY)) {
                boardMatrix[y + 1][x + 1].setCellStatus(CellStatus.SHIP_BORDER);
            }
            if (x - 1 >= 0 &&
                    boardMatrix[y][x - 1].getCellStatus().equals(CellStatus.EMPTY)) {
                boardMatrix[y][x - 1].setCellStatus(CellStatus.SHIP_BORDER);
            }
            if (x - 1 >= 0 && y - 1 >= 0 &&
                    boardMatrix[y - 1][x - 1].getCellStatus().equals(CellStatus.EMPTY)) {
                boardMatrix[y - 1][x - 1].setCellStatus(CellStatus.SHIP_BORDER);
            }
            if (x - 1 >= 0 && y + 1 < BOARD_SIZE &&
                    boardMatrix[y + 1][x - 1].getCellStatus().equals(CellStatus.EMPTY)) {
                boardMatrix[y + 1][x - 1].setCellStatus(CellStatus.SHIP_BORDER);
            }
            if (y + 1 < BOARD_SIZE &&
                    boardMatrix[y + 1][x].getCellStatus().equals(CellStatus.EMPTY)) {
                boardMatrix[y + 1][x].setCellStatus(CellStatus.SHIP_BORDER);
            }
            if (y - 1 >= 0 &&
                    boardMatrix[y - 1][x].getCellStatus().equals(CellStatus.EMPTY)) {
                boardMatrix[y - 1][x].setCellStatus(CellStatus.SHIP_BORDER);
            }
        }
    }

    private boolean isShipValidForBoard(Cell start, ShipType type, int direction) {
        if (isTypeNotEnoughInShipList(type) && isShipCellsFitBoard(start, type, direction)) {
            Ship ship = new Ship(start, type, direction);
            return !shipList.contains(ship);
        }
        return false;
    }

    private boolean isShipCellsFitBoard(Cell start, ShipType type, int direction) {
        Ship ship = new Ship(start, type, direction);
        List<Cell> cells = ship.getCellsList();
        for (Cell cell : cells) {
            if (cell.getX() < 0 || cell.getY() < 0 || cell.getX() >= boardMatrix.length ||
                    cell.getY() >= boardMatrix.length) {
                return false;
            }
            if (!(boardMatrix[cell.getY()][cell.getX()]).getCellStatus().equals(CellStatus.EMPTY)) {
                return false;
            }
        }
        return true;
    }

    private boolean isTypeNotEnoughInShipList(ShipType type) {
        int count = (int) shipList.stream().filter(ship -> ship.getType().equals(type)).count();
        return count < type.getAmount();
    }
}
