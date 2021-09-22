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
    private static final String GAMEMODE = ", please, choose ship placement mode: 1 - manual, 2 - automatic";
    private static final String NEXTMOVE = "Press ENTER to finish your move";
    private static final String DONE = "\nAll ships are placed!";
    private int gameMode;

    public ShipPlacer(InputShipReader inputShipReader) {
        this.inputShipReader = inputShipReader;
    }

    @SneakyThrows
    public void placeShip(Player player) {

        defineGameMode(player.getName());

        MyBoard board = player.getMyBoard();
        showBoards(player);

        for (int shipSize = 4; shipSize >= 1; shipSize--) {
            for (int shipNumber = 0; shipNumber <= 4 - shipSize; shipNumber++) {
                if (gameMode == 1) {
                    System.out.println(player.getName() + ", please, input top left coordinate for the ship (" + shipSize + " points) and orientation. Example: [A5 h] or [A8 v]");
                }

                inputShipReader.getAndValidateInput(shipSize, board, gameMode);
                List<Point> coordinates = inputShipReader.getValidCoordinates();

                Ship ship = new Ship(coordinates);
                board.placeShip(ship);
                player.getMyShips().add(ship);

                if (gameMode == 1) {
                    System.out.println(PLACED);
                    showBoards(player);
                }
            }
        }

        if (gameMode == 2) {
            System.out.println(DONE);
            showBoards(player);
            Thread.sleep(200);
        }
        printBigSpace();
    }

    public void defineGameMode(String name) {
        while (true) {
            System.out.println(name + GAMEMODE);
            String gameModeInput = inputShipReader.readLine();
            if (gameModeInput.matches("[1]|[2]")) {
                gameMode = Integer.parseInt(gameModeInput);
                break;
            }
        }
    }

    public void printBigSpace() {
        System.out.println(NEXTMOVE);
        inputShipReader.readLine();
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }

}
