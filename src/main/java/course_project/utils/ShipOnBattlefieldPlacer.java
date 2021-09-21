package course_project.utils;

import course_project.gamestuff.field.Battlefield;
import course_project.gamestuff.field.Cell;
import course_project.gamestuff.ships.Ship;

import static course_project.gamestuff.field.Field.FIELD_SIZE;

/**
 * Ship placing on owner battlefield
 * checkers for availability of addition ship.
 */
public final class ShipOnBattlefieldPlacer {

    private ShipOnBattlefieldPlacer() {}

    public static boolean isEnoughSpaceToPlaceShip(Cell fromCell, int shipSize, boolean isHorizontal) {
        return isHorizontal ?
                fromCell.getY() >= 0 && fromCell.getY() + shipSize <= FIELD_SIZE :
                fromCell.getX() >= 0 && fromCell.getX() + shipSize <= FIELD_SIZE;
    }

    public static boolean addColumnOfCells(Battlefield battlefield, Cell firstCell, Ship ship) {
        if (isAbleToAddColumnOfCells(battlefield, firstCell, ship.getSize())) {
            int y = firstCell.getY();
            ship.setStartCell(firstCell);
            ship.setVertical();
            for (int i = firstCell.getX(); i < firstCell.getX() + ship.getSize(); i++) {
                battlefield.getCellByPosition(i, y).placeShipOnCell(ship);
            }
            return true;
        }
        return false;
    }

    public static boolean addRowOfCells(Battlefield battlefield, Cell firstCell, Ship ship) {
        if (isAbleToAddRowOfCells(battlefield, firstCell, ship.getSize())) {
            int x = firstCell.getX();
            ship.setStartCell(firstCell);
            for (int j = firstCell.getY(); j < firstCell.getY() + ship.getSize(); j++) {
                battlefield.getCellByPosition(x, j).placeShipOnCell(ship);
            }
            return true;
        }
        return false;
    }

    private static boolean isAbleToAddColumnOfCells(Battlefield battlefield, Cell firstCell, int shipSize) {
        if (!(isCellAboveFromCurrentIsEmpty(battlefield, firstCell) &&
                isCellDiagonalLeftAboveFromCurrentIsEmpty(battlefield, firstCell) &&
                isCellDiagonalRightAboveFromCurrentIsEmpty(battlefield, firstCell))) {
            return false;
        }
        int y = firstCell.getY();
        for (int i = firstCell.getX(); i < firstCell.getX() + shipSize; i++) {
            Cell currentCell = battlefield.getCellByPosition(i, y);
            if (!(battlefield.isCellEmpty(currentCell) &&
                    isCellBelowFromCurrentIsEmpty(battlefield, currentCell) &&
                    isCellLeftFromCurrentIsEmpty(battlefield, currentCell) &&
                    isCellRightFromCurrentIsEmpty(battlefield, currentCell))) {
                return false;
            }
            if (i == firstCell.getX() + shipSize - 1 &&
                    !(isCellDiagonalLeftBelowFromCurrentIsEmpty(battlefield, currentCell) &&
                            isCellDiagonalRightBelowFromCurrentIsEmpty(battlefield, currentCell))
            ) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAbleToAddRowOfCells(Battlefield battlefield, Cell firstCell, int shipSize) {
        if (!(isCellLeftFromCurrentIsEmpty(battlefield, firstCell) &&
                isCellDiagonalLeftAboveFromCurrentIsEmpty(battlefield, firstCell) &&
                isCellDiagonalLeftBelowFromCurrentIsEmpty(battlefield, firstCell) &&
                isCellDiagonalRightAboveFromCurrentIsEmpty(battlefield, firstCell))
        ) {
            return false;
        }
        int x = firstCell.getX();
        for (int j = firstCell.getY(); j < firstCell.getY() + shipSize; j++) {
            Cell currentCell = battlefield.getCellByPosition(x, j);
            if (!(battlefield.isCellEmpty(currentCell) &&
                    isCellRightFromCurrentIsEmpty(battlefield, currentCell) &&
                    isCellAboveFromCurrentIsEmpty(battlefield, currentCell) &&
                    isCellBelowFromCurrentIsEmpty(battlefield, currentCell))
            ) {
                return false;
            }
            if (j == firstCell.getY() + shipSize - 1 &&
                    !(isCellDiagonalRightAboveFromCurrentIsEmpty(battlefield, currentCell) &&
                            isCellDiagonalRightBelowFromCurrentIsEmpty(battlefield, currentCell))
            ) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCellRightFromCurrentIsEmpty(Battlefield battlefield, Cell currentCell) {
        return currentCell.getY() == FIELD_SIZE - 1 ||
                battlefield.isCellEmpty(battlefield.getCellByPosition(currentCell.getX(), currentCell.getY() + 1));
    }

    private static boolean isCellLeftFromCurrentIsEmpty(Battlefield battlefield, Cell currentCell) {
        return currentCell.getY() == 0 ||
                battlefield.isCellEmpty(battlefield.getCellByPosition(currentCell.getX(), currentCell.getY() - 1));
    }

    private static boolean isCellAboveFromCurrentIsEmpty(Battlefield battlefield, Cell currentCell) {
        return currentCell.getX() == 0 ||
                battlefield.isCellEmpty(battlefield.getCellByPosition(currentCell.getX() - 1, currentCell.getY()));
    }

    private static boolean isCellBelowFromCurrentIsEmpty(Battlefield battlefield, Cell currentCell) {
        return currentCell.getX() == FIELD_SIZE - 1 ||
                battlefield.isCellEmpty(battlefield.getCellByPosition(currentCell.getX() + 1, currentCell.getY()));
    }

    private static boolean isCellDiagonalLeftAboveFromCurrentIsEmpty(Battlefield battlefield, Cell currentCell) {
        return currentCell.getX() == 0 || currentCell.getY() == 0 ||
                battlefield.isCellEmpty(battlefield.getCellByPosition(currentCell.getX() - 1, currentCell.getY() - 1));
    }

    private static boolean isCellDiagonalRightAboveFromCurrentIsEmpty(Battlefield battlefield, Cell currentCell) {
        return currentCell.getX() == 0 || currentCell.getY() == FIELD_SIZE - 1 ||
                battlefield.isCellEmpty(battlefield.getCellByPosition(currentCell.getX() - 1, currentCell.getY() + 1));
    }

    private static boolean isCellDiagonalLeftBelowFromCurrentIsEmpty(Battlefield battlefield, Cell currentCell) {
        return currentCell.getX() == FIELD_SIZE - 1 || currentCell.getY() == 0 ||
                battlefield.isCellEmpty(battlefield.getCellByPosition(currentCell.getX() + 1, currentCell.getY() - 1));
    }

    private static boolean isCellDiagonalRightBelowFromCurrentIsEmpty(Battlefield battlefield, Cell currentCell) {
        return currentCell.getX() == FIELD_SIZE - 1 || currentCell.getY() == FIELD_SIZE - 1 ||
                battlefield.isCellEmpty(battlefield.getCellByPosition(currentCell.getX() + 1, currentCell.getY() + 1));
    }

}
