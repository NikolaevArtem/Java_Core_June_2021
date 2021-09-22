package course_project.sea_battle.service;

import course_project.sea_battle.boards.MyBoard;
import course_project.sea_battle.model.Player;
import course_project.sea_battle.model.Point;
import course_project.sea_battle.model.Ship;
import course_project.sea_battle.service.inputs.InputShipReader;
import lombok.SneakyThrows;

import java.util.List;

import static course_project.sea_battle.view.BoardPrinter.showBoards;

public class ShipPlacer {
    private final InputShipReader inputShipReader;
    private static final String PLACED = "Ship is placed!";
    private static final String CHOOSESHIPPLACEMENTMODE = ", please, choose ship placement mode:\n1: manual\n2: automatic";
    private static final String NEXTMOVE = "Press ENTER to finish your move";
    private static final String DONE = "\nAll ships are placed!";
    private int shipPlacementMode;

    public ShipPlacer(InputShipReader inputShipReader) {
        this.inputShipReader = inputShipReader;
    }

    @SneakyThrows
    public void placeShip(Player player1, Player player2) {

        defineShipPlacementMode(player1);

        MyBoard board = player1.getMyBoard();
        if (!player1.isComputer()) {
            showBoards(player1);
        }

        for (int shipSize = 4; shipSize >= 1; shipSize--) {
            for (int shipNumber = 0; shipNumber <= 4 - shipSize; shipNumber++) {
                if (shipPlacementMode == 1) {
                    System.out.println(player1.getName() + ", please, input top left coordinate for the ship (" + shipSize + " points) and orientation. Example: [A5 h] or [A8 v]");
                }

                inputShipReader.getAndValidateInput(shipSize, board, shipPlacementMode);
                List<Point> coordinates = inputShipReader.getValidCoordinates();

                Ship ship = new Ship(coordinates);
                board.placeShip(ship);
                player1.getMyShips().add(ship);

                if (shipPlacementMode == 1) {
                    System.out.println(PLACED);
                    showBoards(player1);
                }
            }
        }

        if (shipPlacementMode == 2 && !player1.isComputer()) {
            System.out.println(DONE);
            showBoards(player1);
            Thread.sleep(200);
        }
        if (!player1.isComputer() && !player2.isComputer()) {printBigSpace();}
    }

    public void defineShipPlacementMode(Player player) {
        if (player.isComputer()) {
            shipPlacementMode = 2;
        } else {
            while (true) {
                System.out.println(player.getName() + CHOOSESHIPPLACEMENTMODE);
                String gameModeInput = inputShipReader.readLine();
                if (gameModeInput.matches("[1]|[2]")) {
                    shipPlacementMode = Integer.parseInt(gameModeInput);
                    break;
                }
            }
        }
    }

    public void printBigSpace() {
        System.out.println(NEXTMOVE);
        inputShipReader.readLine();
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }

}
