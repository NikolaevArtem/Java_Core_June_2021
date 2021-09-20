package course_project.sea_battle.service;

import course_project.sea_battle.model.Player;
import course_project.sea_battle.model.Point;
import course_project.sea_battle.model.Ship;
import course_project.sea_battle.model.boards.MyBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static course_project.sea_battle.view.BigSpace.bigSpace;
import static course_project.sea_battle.view.BoardPrinter.showBoards;

public class ShipPlacer {
    private final InputReader inputReader;
    private static final String PLACED = "Ship is placed!";

    public ShipPlacer(Scanner scanner) {
        inputReader = new InputReader(scanner);
    }

    public void placeShip(Player player) {

        MyBoard board = player.getMyBoard();
        showBoards(player);

        for (int shipSize = 4; shipSize >= 1; shipSize--) {
            for (int shipNumber = 0; shipNumber <= 4 - shipSize; shipNumber++) {
                System.out.println(player.getName() + ", please, input top left coordinate for the ship (" + shipSize + " points) and orientation. Example: [A5 h] or [A8 v]");

                inputReader.getAndValidateInput(shipSize, board);
                List<Point> coordinates = inputReader.getValidCoordinates();

                Ship ship = new Ship(coordinates);
                board.placeShip(ship);

                System.out.println(PLACED);
                player.getMyShips().add(ship);
                showBoards(player);
            }
        }

//        You can uncomment this block of code instead above for() (lines: 28-42) to place only 2 ships for every player.

//        for (int shipSize = 3; shipSize > 1; shipSize--) {
//            for (int shipNumber = 0; shipNumber < 1; shipNumber++) {
//                System.out.println(player.getName() + ", please, input top left coordinate for the ship (" + shipSize + " points) and orientation. Example: [A5 H] or [a8 v]");
//
//                inputReader.getAndValidateInput(shipSize, board);
//                List<Point> coordinates = inputReader.getValidCoordinates();
//
//                Ship ship = new Ship(coordinates);
//                board.placeShip(ship);
//
//                System.out.println(PLACED);
//                player.getMyShips().add(ship);
//                showBoards(player);
//            }
//        }

        bigSpace();
    }

}
