package course_project.battleship_game.service;

import course_project.battleship_game.model.Cell;
import course_project.battleship_game.model.CellStatus;
import course_project.battleship_game.model.GameMode;
import course_project.battleship_game.model.Player;
import course_project.battleship_game.model.ShipType;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static course_project.battleship_game.utils.Constants.BOARD_SIZE;
import static course_project.battleship_game.utils.Constants.CREATING_FLEET_MESSAGE_FORMAT;
import static course_project.battleship_game.utils.Constants.CREATING_SHIP_MESSAGE_FORMAT;
import static course_project.battleship_game.utils.Constants.DEFAULT_COMPUTER_NAME;
import static course_project.battleship_game.utils.Constants.ERROR_INPUT_MESSAGE;
import static course_project.battleship_game.utils.Constants.FLEET_CREATED_MESSAGE_FORMAT;
import static course_project.battleship_game.utils.Constants.REMAINING_AMOUNT_OF_TYPE_TO_CREATE;
import static course_project.battleship_game.utils.Constants.SHIP_CREATED_MESSAGE_FORMAT;
import static course_project.battleship_game.utils.InputUtils.getCell;
import static course_project.battleship_game.utils.InputUtils.getDirection;
import static course_project.battleship_game.utils.InputUtils.getModeToCreateFleet;
import static course_project.battleship_game.utils.InputUtils.getPlayerName;
import static course_project.battleship_game.utils.PrintUtils.printBoardForPlayer;
import static course_project.battleship_game.utils.PrintUtils.printMessage;

public class CreateService {

    public Cell[][] createBoard() {
        Cell[][] boardMatrix = new Cell[BOARD_SIZE][BOARD_SIZE];
        for (int y = 0; y < BOARD_SIZE; y++) {
            for (int x = 0; x < BOARD_SIZE; x++) {
                boardMatrix[y][x] = new Cell(x, y, CellStatus.EMPTY);
            }
        }
        return boardMatrix;
    }

    public Player[] createPlayers(GameMode mode) {
        Player[] players = new Player[2];
        players[0] = mode.equals(GameMode.CVC) ? new Player(DEFAULT_COMPUTER_NAME + " Mimi", 0) :
                new Player(getPlayerName(), getModeToCreateFleet());
        players[1] = !mode.equals(GameMode.PVP) ? new Player(DEFAULT_COMPUTER_NAME + " Navi", 0) :
                new Player(getPlayerName(), getModeToCreateFleet());
        return players;
    }

    public void createFleet(Player player) {
        printMessage(String.format(CREATING_FLEET_MESSAGE_FORMAT, player.getName()));
        if (player.getModeToCreateFleet() == 0) {
            createRightAmountOfTypeRandomly(player, ShipType.BATTLESHIP);
            createRightAmountOfTypeRandomly(player, ShipType.CRUISER);
            createRightAmountOfTypeRandomly(player, ShipType.DESTROYER);
            createRightAmountOfTypeRandomly(player, ShipType.TORPEDO_BOAT);
        } else {
            createRightAmountOfTypeManually(player, ShipType.BATTLESHIP);
            createRightAmountOfTypeManually(player, ShipType.CRUISER);
            createRightAmountOfTypeManually(player, ShipType.DESTROYER);
            createRightAmountOfTypeManually(player, ShipType.TORPEDO_BOAT);
        }
        printMessage(String.format(FLEET_CREATED_MESSAGE_FORMAT, player.getName()));
    }

    public Cell createRandomCell() {
        int x = ThreadLocalRandom.current().nextInt(0, 10);
        int y = ThreadLocalRandom.current().nextInt(0, 10);
        return new Cell(x, y);
    }

    public List<Cell> createShipCells(Cell start, ShipType type, int direction) {
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < type.getLength(); i++) {
            int x = direction == 1 ? start.getX() : start.getX() + i;
            int y = direction == 1 ? start.getY() + i : start.getY();
            cells.add(new Cell(x, y, CellStatus.SHIP));
        }
        return cells;
    }

    private void createRightAmountOfTypeManually(Player player, ShipType type) {
        printMessage(String.format(CREATING_SHIP_MESSAGE_FORMAT, type.toString()));
        int count = 0;
        while (count != type.getAmount()) {
            Cell start = getCell();
            int direction = getDirection();
            start.setCellStatus(CellStatus.SHIP);
            boolean created = new BoardService(player.getBoard()).isCreatingShipSuccessful(start, type, direction);
            if (created) {
                count++;
                if (type.getAmount() - count != 0) {
                    printMessage(String.format(REMAINING_AMOUNT_OF_TYPE_TO_CREATE,
                            type.name().replace("_", " ").toLowerCase(), type.getAmount() - count));
                }
                printBoardForPlayer(player, false);
            } else {
                printMessage(ERROR_INPUT_MESSAGE);
            }
        }
        printMessage(String.format(SHIP_CREATED_MESSAGE_FORMAT,
                "You", type.getAmount(), type.name().replace("_", " ").toLowerCase()));
    }

    private void createRightAmountOfTypeRandomly(Player player, ShipType type) {
        printMessage(String.format(CREATING_SHIP_MESSAGE_FORMAT, type.toString()));
        int count = 0;
        while (count != type.getAmount()) {
            Cell start = createRandomCell();
            int direction = ThreadLocalRandom.current().nextInt(0, 2);
            boolean created = new BoardService(player.getBoard()).isCreatingShipSuccessful(start, type, direction);
            if (created) {
                count++;
            }
        }
        printMessage(String.format(SHIP_CREATED_MESSAGE_FORMAT,
                player.getName(), type.getAmount(), type.name().replace("_", " ").toLowerCase()));
    }
}
