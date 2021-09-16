package course_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ManualShipPlacer extends ShipPlacer {
    final static private String INVALID_INPUT = "Invalid format or count of coordinates." +
            " Try again. Examples: A7 A10 or B1";
    private final Scanner scanner;

    public ManualShipPlacer(Field field, List<Ship> playerShips, Scanner scanner) {
        super(field, playerShips);
        this.scanner = scanner;

    }

    @Override
    public void place(ShipKind kind) {
        int lengthOfShip = kind.getLength();
        String inputLength = lengthOfShip == 1 ? "one coordinate" : "two coordinates";
        while(true) {
            System.out.printf("Input %s for %s: ", inputLength, kind.getType());
            String[] coordinates = scanner.nextLine().trim().split("\\s+");
            if (lengthOfShip == 1) {
                if (coordinates.length == 1 && Coordinate.check(coordinates[0])) {
                    if (placeOneDeckShip(coordinates)) {
                        return;
                    }
                } else {
                    System.out.println(INVALID_INPUT);
                }
            } else {
                if (cellHandler.isLine(coordinates) &&
                        cellHandler.cellCount(coordinates) == lengthOfShip) {
                    if (placeSeveralDecksShip(coordinates, kind)) {
                        return;
                    }
                } else {
                    System.out.println(INVALID_INPUT);
                }
            }
        }
    }

    private List<Cell> lineToCells(String[] coordinates) {
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < cellHandler.cellCount(coordinates); i++) {
            Coordinate temp = new Coordinate(coordinates[0]);
            if (cellHandler.sameLine(coordinates, true)) {
                cells.add(field.getCell(temp.row, temp.column + i));
            } else {
                cells.add(field.getCell(temp.row + 1, temp.column));
            }
        }
        return cells;
    }

    private boolean placeOneDeckShip(String[] coordinates) {
        Cell cell = field.getCell(coordinates[0]);
        if (cell.getState().equals(CellState.EMPTY)) {
            cell.setState(CellState.DECK);
            playerShips.add(new Ship(ShipKind.ONE_DECK_SHIP, Collections.singletonList(cell)));
            return true;
        } else {
            System.out.println("The cell is unavailable. Please, choose another.");
            return false;
        }
    }

    private boolean placeSeveralDecksShip(String[] coordinates, ShipKind kind) {
        List<Cell> cells = lineToCells(coordinates);
        boolean free = cells
                .stream()
                .allMatch(c -> c.getState().equals(CellState.EMPTY));
        if (free) {
            cells.forEach(c -> c.setState(CellState.DECK));
            playerShips.add(new Ship(kind, cells));
            return true;
        } else {
            System.out.println("Chosen cells are unavailable. Please, choose another.");
            return false;
        }
    }
}
