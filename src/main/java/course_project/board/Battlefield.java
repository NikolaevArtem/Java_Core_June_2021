package course_project.board;

import course_project.player.Player;
import course_project.ships.*;

import java.util.*;

import static course_project.dialogue.Menu.*;
import static course_project.utils.RandomPositionGenerator.generateRandomForCell;
import static course_project.utils.RandomDirectionGenerator.generateRandomDirection;

public class Battlefield extends Board {

    private final List<Ship> availableShips = new ArrayList<>();

    public Battlefield() {
        super.cells = new Cell[FIELD_SIZE][FIELD_SIZE];
        fillCells();
        addShipsToList();
    }

    public List<Ship> getAvailableShips() {
        return this.availableShips;
    }

    public void addShipsToList() {
        availableShips.add(new Battleship());
        availableShips.add(new Destroyer());
        availableShips.add(new Destroyer());
        availableShips.add(new Cruiser());
        availableShips.add(new Cruiser());
        availableShips.add(new Cruiser());
        availableShips.add(new PatrolBoat());
        availableShips.add(new PatrolBoat());
        availableShips.add(new PatrolBoat());
        availableShips.add(new PatrolBoat());
    }

    public boolean addShipOnBattlefield(Ship ship, Cell cell, boolean isHorizontal) {
        if (checkSpaceForPlaceShip(cell, ship.getSize(), isHorizontal)) {
            if (isHorizontal) {
                return !addRowOfCells(cell, ship);
            } else {
                return !addColumnOfCells(cell, ship);
            }
        }
        return true;
    }

    public void availableShipsDecrease(Ship ship) {
        this.availableShips.remove(ship);
    }

    private boolean addColumnOfCells(Cell entryCell, Ship ship) {
        if (checkPossibilityForAddColumn(entryCell, ship.getSize())) {
            int y = entryCell.getY();
            for (int i = entryCell.getX(); i < entryCell.getX() + ship.getSize(); i++) {
                getCellByPosition(i, y).setShipAtCell(ship);
            }
            return true;
        }
        return false;
    }

    private boolean addRowOfCells(Cell entryCell, Ship ship) {
        if (checkPossibilityForAddRow(entryCell, ship.getSize())) {
            int x = entryCell.getX();
            for (int j = entryCell.getY(); j < entryCell.getY() + ship.getSize(); j++) {
                getCellByPosition(x, j).setShipAtCell(ship);
            }
            return true;
        }
        return false;
    }

    private boolean checkPossibilityForAddColumn(Cell entryCell, int shipSize) {
        if (!(checkCellAbove(entryCell) &&
                checkCellAboveLeftDiagonal(entryCell) &&
                checkCellAboveRightDiagonal(entryCell))) {
            return false;
        }
        int y = entryCell.getY();
        for (int i = entryCell.getX(); i < entryCell.getX() + shipSize; i++) {
            Cell currentCell = cells[i][y];
            if (!(isCellEmpty(currentCell) &&
                    checkCellBelow(currentCell) &&
                    checkCellOnTheLeft(currentCell) &&
                    checkCellOnTheRight(currentCell))) {
                return false;
            }
            if (i == entryCell.getX() + shipSize - 1 &&
                    !(checkCellBelowLeftDiagonal(currentCell) &&
                            checkCellBelowRightDiagonal(currentCell))
            ) {
                return false;
            }
        }
        return true;
    }

    private boolean checkPossibilityForAddRow(Cell entryCell, int shipSize) {
        if (!(checkCellOnTheLeft(entryCell) &&
                checkCellAboveLeftDiagonal(entryCell) &&
                checkCellBelowLeftDiagonal(entryCell) &&
                checkCellAboveRightDiagonal(entryCell))
        ) {
            return false;
        }
        int x = entryCell.getX();
        for (int j = entryCell.getY(); j < entryCell.getY() + shipSize; j++) {
            Cell currentCell = cells[x][j];
            if (!(isCellEmpty(currentCell) &&
                    checkCellOnTheRight(currentCell) &&
                    checkCellAbove(currentCell) &&
                    checkCellBelow(currentCell))
            ) {
                System.out.println("Cannot set the ship to coordinates " + Character.toUpperCase((char) (entryCell.getY() + 97)) + "" + (entryCell.getX() + 1) + ", check if the ship is in contact with another.\n");
                return false;
            }
            if (j == entryCell.getY() + shipSize - 1 &&
                    !(checkCellAboveRightDiagonal(currentCell) &&
                            checkCellBelowRightDiagonal(currentCell))
            ) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSpaceForPlaceShip(Cell fromCell, int shipSize, boolean isHorizontal) {
        return isHorizontal ?
                fromCell.getY() >= 0 && fromCell.getY() + shipSize <= FIELD_SIZE :
                fromCell.getX() >= 0 && fromCell.getX() + shipSize <= FIELD_SIZE;
    }

    private boolean checkCellAbove(Cell currentCell) {
        return currentCell.getX() == 0 || isCellEmpty(cells[currentCell.getX() - 1][currentCell.getY()]);
    }

    private boolean checkCellBelow(Cell currentCell) {
        return currentCell.getX() == 9 || isCellEmpty(cells[currentCell.getX() + 1][currentCell.getY()]);
    }

    private boolean checkCellOnTheRight(Cell currentCell) {
        return currentCell.getY() == 9 || isCellEmpty(cells[currentCell.getX()][currentCell.getY() + 1]);
    }

    private boolean checkCellOnTheLeft(Cell currentCell) {
        return currentCell.getY() == 0 || isCellEmpty(cells[currentCell.getX()][currentCell.getY() - 1]);
    }

    private boolean checkCellAboveLeftDiagonal(Cell currentCell) {
        return currentCell.getX() == 0 || currentCell.getY() == 0 ||
                isCellEmpty(cells[currentCell.getX() - 1][currentCell.getY() - 1]);
    }

    private boolean checkCellBelowLeftDiagonal(Cell currentCell) {
        return currentCell.getX() == 9 || currentCell.getY() == 0 ||
                isCellEmpty(cells[currentCell.getX() + 1][currentCell.getY() - 1]);
    }

    private boolean checkCellAboveRightDiagonal(Cell currentCell) {
        return currentCell.getX() == 0 || currentCell.getY() == 9 ||
                isCellEmpty(cells[currentCell.getX() - 1][currentCell.getY() + 1]);
    }

    private boolean checkCellBelowRightDiagonal(Cell currentCell) {
        return currentCell.getX() == 9 || currentCell.getY() == 9 ||
                isCellEmpty(cells[currentCell.getX() + 1][currentCell.getY() + 1]);
    }


    public boolean hasAvailableShips() {
        return !this.availableShips.isEmpty();
    }

    public static void addShipsOneByOne(Player currentPlayer) {
        showHelp();
        for (Ship ship : currentPlayer.getField().getAvailableShips()) {
            currentPlayer.getField().printField();
            Cell position;
            boolean isHorizontal = true;
            do {
                System.out.print("Ship's type: " + ship.getName() + ". Size: " + ship.getSize() + ". Specify coordinates: ");
                String[] cellPossition = getInputPosition().split(" ");
                int x = Integer.parseInt(cellPossition[0].substring(1)) - 1;
                int y = Integer.parseInt(String.valueOf(cellPossition[0].charAt(0) - 97));
                position = currentPlayer.getField().getCellByPosition(x, y);
                if (cellPossition.length == 2) {
                    isHorizontal = !"v".equals(cellPossition[1]);
                }
            } while (currentPlayer.getField().addShipOnBattlefield(ship, position, isHorizontal));
        }
    }

    public static void generateRandomPlacesForShips(Player currentPlayer) {
        for (Ship ship : currentPlayer.getField().getAvailableShips()) {
            Cell toPos;
            boolean isHorizontal;
            do {
                toPos = currentPlayer.getField().getCellByPosition(generateRandomForCell(),
                        generateRandomForCell());
                isHorizontal = generateRandomDirection();
            } while (currentPlayer.getField().addShipOnBattlefield(ship, toPos, isHorizontal));
        }
    }
}
