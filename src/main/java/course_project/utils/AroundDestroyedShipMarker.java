package course_project.utils;

import course_project.gamestuff.field.Battlefield;
import course_project.gamestuff.field.Cell;
import course_project.gamestuff.field.Field;
import course_project.gamestuff.player.Player;
import course_project.gamestuff.ships.Ship;

/**
 * Functions to fill cells around the destroyed ship.
 */
public final class AroundDestroyedShipMarker {

    private AroundDestroyedShipMarker() {}

    public static void fillAroundSmallShip(Player currentPlayer, Ship ship) {
        Cell shipCell = currentPlayer.getField().getCellByPosition(
                ship.getStartCell().getX(),
                ship.getStartCell().getY()
        );
        Battlefield battlefield = currentPlayer.getField();
        markAboveAsHitCell(battlefield, shipCell);
        markBelowAsHitCell(battlefield, shipCell);
        markRightAsHitCell(battlefield, shipCell);
        markLeftAsHitCell(battlefield, shipCell);
        markDiagonalRightBelowAsHitCell(battlefield, shipCell);
        markDiagonalLeftBelowAsHitCell(battlefield, shipCell);
        markDiagonalRightAboveAsHitCell(battlefield, shipCell);
        markDiagonalLeftAboveAsHitCell(battlefield, shipCell);
    }

    public static void fillAroundVerticalShip(Player currentPlayer, Ship ship) {
        int x = ship.getStartCell().getX();
        int y = ship.getStartCell().getY();
        Battlefield battlefield = currentPlayer.getField();
        for (int i = 0; i < ship.getSize(); i++) {
            Cell currentCell = battlefield.getCellByPosition(x + i, y);
            if (i == 0) {
                markAboveAsHitCell(battlefield, currentCell);
                markDiagonalLeftAboveAsHitCell(battlefield, currentCell);
                markDiagonalRightAboveAsHitCell(battlefield, currentCell);
            } else if (i == ship.getSize() - 1) {
                markDiagonalLeftBelowAsHitCell(battlefield, currentCell);
                markDiagonalRightBelowAsHitCell(battlefield, currentCell);
                markBelowAsHitCell(battlefield, currentCell);
            }
            markLeftAsHitCell(battlefield, currentCell);
            markRightAsHitCell(battlefield, currentCell);
        }
    }

    public static void fillAroundHorizontalShip(Player currentPlayer, Ship ship) {
        int x = ship.getStartCell().getX();
        int y = ship.getStartCell().getY();
        Battlefield battlefield = currentPlayer.getField();
        for (int i = 0; i < ship.getSize(); i++) {
            Cell currentCell = currentPlayer.getField().getCellByPosition(x, y + i);
            if (i == 0) {
                markDiagonalLeftAboveAsHitCell(battlefield, currentCell);
                markLeftAsHitCell(battlefield, currentCell);
                markDiagonalLeftBelowAsHitCell(battlefield, currentCell);
            } else if (i == ship.getSize() - 1) {
                markDiagonalRightAboveAsHitCell(battlefield, currentCell);
                markRightAsHitCell(battlefield, currentCell);
                markDiagonalRightBelowAsHitCell(battlefield, currentCell);
            }
            markAboveAsHitCell(battlefield, currentCell);
            markBelowAsHitCell(battlefield, currentCell);
        }
    }

    private static void markAboveAsHitCell(Battlefield battlefield, Cell currentCell) {
        if (currentCell.getX() != 0) {
            battlefield.getCellByPosition(currentCell.getX() - 1, currentCell.getY()).setHit(true);
        }
    }

    private static void markBelowAsHitCell(Battlefield battlefield, Cell currentCell) {
        if (currentCell.getX() != Field.FIELD_SIZE - 1) {
            battlefield.getCellByPosition(currentCell.getX() + 1, currentCell.getY()).setHit(true);
        }
    }

    private static void markRightAsHitCell(Battlefield battlefield, Cell currentCell) {
        if (currentCell.getY() != Field.FIELD_SIZE - 1) {
            battlefield.getCellByPosition(currentCell.getX(), currentCell.getY() + 1).setHit(true);
        }
    }

    private static void markLeftAsHitCell(Battlefield battlefield, Cell currentCell) {
        if (currentCell.getY() != 0) {
            battlefield.getCellByPosition(currentCell.getX(), currentCell.getY() - 1).setHit(true);
        }
    }

    private static void markDiagonalRightBelowAsHitCell(Battlefield battlefield, Cell currentCell) {
        if (currentCell.getX() != Field.FIELD_SIZE - 1 && currentCell.getY() != Field.FIELD_SIZE - 1) {
            battlefield.getCellByPosition(currentCell.getX() + 1, currentCell.getY() + 1).setHit(true);
        }
    }

    private static void markDiagonalRightAboveAsHitCell(Battlefield battlefield, Cell currentCell) {
        if (currentCell.getX() != 0 && currentCell.getY() != Field.FIELD_SIZE - 1) {
            battlefield.getCellByPosition(currentCell.getX() - 1, currentCell.getY() + 1).setHit(true);
        }
    }

    private static void markDiagonalLeftBelowAsHitCell(Battlefield battlefield, Cell currentCell) {
        if (currentCell.getX() != Field.FIELD_SIZE - 1 && currentCell.getY() != 0) {
            battlefield.getCellByPosition(currentCell.getX() + 1, currentCell.getY() - 1).setHit(true);
        }
    }

    private static void markDiagonalLeftAboveAsHitCell(Battlefield battlefield, Cell currentCell) {
        if (currentCell.getX() != 0 && currentCell.getY() != 0) {
            battlefield.getCellByPosition(currentCell.getX() - 1, currentCell.getY() - 1).setHit(true);
        }
    }

}
