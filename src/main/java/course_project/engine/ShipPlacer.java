package course_project.engine;

import course_project.models.Player;
import course_project.models.Board;
import course_project.models.Coordinate;
import course_project.models.Ship;

import java.io.IOException;
import java.util.ArrayList;

public class ShipPlacer {

    public static void placement(Ship ship, Player p) throws IOException {

        Board b = p.MainBoard();
        while (true) {
            BoardPrinter.printMainBoard(p);
            System.out.println("It`s time to place a ship.");
            Coordinate c = new Coordinate(Input.getRightCoordinate());
            String mode;
            int size = ship.getSize();

            if (PositionChecker.possibleToPlace(b, c, size, "v") && PositionChecker.possibleToPlace(b, c, size, "h")) {
                if (size == 1) { //scout does not need direction
                    placeShip(p,c,ship,"h");
                    break;
                }
                mode = Input.getRightMode();
                placeShip(p,c,ship,mode);
                break;

            } else if (PositionChecker.possibleToPlace(b, c, size, "v")) {
                placeShip(p,c,ship,"v");
                break;
            } else if (PositionChecker.possibleToPlace(b, c, size, "h")) {
                placeShip(p,c,ship,"h");
                break;
            } else {
                System.out.println("Impossible to place it here!");
            }
        }
    }

    private static void placeShip(Player p, Coordinate c, Ship ship, String mode ) {
        Board b = p.MainBoard();
        int size = ship.getSize();
        int cCol = c.Col(); // current col & row
        int cRow = c.Row();
        ArrayList<Coordinate> shipCoords = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (mode.equalsIgnoreCase("h")) {
                shipCoords.add(new Coordinate(cRow, cCol + i));
            } else if (mode.equalsIgnoreCase("v")) {
                shipCoords.add(new Coordinate(cRow + i, cCol));
            }
        }
        for (Coordinate coordinate : shipCoords) {
            b.changeCell(coordinate, "H");
        }
        ship.setCoords(shipCoords);
        p.Ships().add(ship);
        BoardPrinter.printMainBoard(p);
    }
}

