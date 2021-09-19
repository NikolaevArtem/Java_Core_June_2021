package course_project.battleship_game.service;

import course_project.battleship_game.controller.InputController;
import course_project.battleship_game.controller.PrintController;
import course_project.battleship_game.model.Cell;
import course_project.battleship_game.model.CellStatus;
import course_project.battleship_game.model.Player;
import course_project.battleship_game.model.ShipType;
import course_project.battleship_game.utils.RandomCellGenerator;

import java.util.concurrent.ThreadLocalRandom;

import static course_project.battleship_game.controller.PrintController.printMessage;
import static course_project.battleship_game.utils.Constants.CREATING_FLEET_MESSAGE_FORMAT;
import static course_project.battleship_game.utils.Constants.CREATING_SHIP_MESSAGE_FORMAT;
import static course_project.battleship_game.utils.Constants.DEFAULT_COMPUTER_NAME;
import static course_project.battleship_game.utils.Constants.ERROR_INPUT_MESSAGE;
import static course_project.battleship_game.utils.Constants.FLEET_CREATED_MESSAGE_FORMAT;
import static course_project.battleship_game.utils.Constants.HIT_MESSAGE_FORMAT;
import static course_project.battleship_game.utils.Constants.MISSED_MESSAGE_FORMAT;
import static course_project.battleship_game.utils.Constants.PLAYER_MOVE_MESSAGE_FORMAT;
import static course_project.battleship_game.utils.Constants.REMAINING_AMOUNT_OF_TYPE_TO_CREATE;
import static course_project.battleship_game.utils.Constants.SAME_COORDINATE_ERROR_MESSAGE;
import static course_project.battleship_game.utils.Constants.SHIP_CREATED_MESSAGE_FORMAT;

public class PlayerService {
    private final Player player;
    private final InputController inputController = new InputController();
    private final PrintController printController = new PrintController();

    public PlayerService(Player player) {
        this.player = player;
    }

    public boolean isMoveSuccessful(Player enemy) {
        Cell cell = null;
        while (cell == null || !player.getLogOfMoves().contains(cell)) {
            if (player.getName().contains(DEFAULT_COMPUTER_NAME)) {
                cell = RandomCellGenerator.generateRandomCell();
            } else {
                cell = inputController.getCell();
            }

            if (!player.getLogOfMoves().contains(cell)) {
                player.getLogOfMoves().add(cell);
            } else {
                if (!player.getName().contains(DEFAULT_COMPUTER_NAME)) {
                    printMessage(SAME_COORDINATE_ERROR_MESSAGE);
                }
                cell = null;
            }
        }
        printMessage(String.format(PLAYER_MOVE_MESSAGE_FORMAT, player.getName(), cell.toString()));
        boolean hit = new BoardService(enemy.getBoard()).isHitCellOnBoard(cell);
        if (hit) {
            printMessage(String.format(HIT_MESSAGE_FORMAT, player.getName(), enemy.getName(), cell.toString()));
        } else {
            printMessage(String.format(MISSED_MESSAGE_FORMAT, player.getName(), cell.toString()));
        }
        return hit;
    }

    public boolean isNoMoreAliveShips() {
        return player.getBoard().getShipList().stream().allMatch(ship -> new ShipService(ship).isNotAlive());
    }

    public void createFleetForPlayer() {
        printMessage(String.format(CREATING_FLEET_MESSAGE_FORMAT, player.getName()));
        if (player.getModeToCreateFleet() == 0) {
            createRightAmountOfTypeRandomly(ShipType.BATTLESHIP);
            createRightAmountOfTypeRandomly(ShipType.CRUISER);
            createRightAmountOfTypeRandomly(ShipType.DESTROYER);
            createRightAmountOfTypeRandomly(ShipType.TORPEDO_BOAT);
        } else {
            createRightAmountOfTypeManually(ShipType.BATTLESHIP);
            createRightAmountOfTypeManually(ShipType.CRUISER);
            createRightAmountOfTypeManually(ShipType.DESTROYER);
            createRightAmountOfTypeManually(ShipType.TORPEDO_BOAT);
        }
        printMessage(String.format(FLEET_CREATED_MESSAGE_FORMAT, player.getName()));
    }

    public long countRemainedShips() {
        return player.getBoard().getShipList().stream().filter(ship -> !new ShipService(ship).isNotAlive()).count();
    }

    private void createRightAmountOfTypeManually(ShipType type) {
        printMessage(String.format(CREATING_SHIP_MESSAGE_FORMAT, type.toString()));
        int count = 0;
        while (count != type.getAmount()) {
            Cell start = inputController.getCell();
            int direction = inputController.getDirection();
            start.setCellStatus(CellStatus.SHIP);
            boolean created = new BoardService(player.getBoard()).isCreatingShipSuccessful(start, type, direction);
            if (created) {
                count++;
                if (type.getAmount() - count != 0) {
                    printMessage(String.format(REMAINING_AMOUNT_OF_TYPE_TO_CREATE,
                            type.name().replace("_", " ").toLowerCase(), type.getAmount() - count));
                }
                printController.printBoardForPlayer(player, false);
            } else {
                printMessage(ERROR_INPUT_MESSAGE);
            }
        }
        printMessage(String.format(SHIP_CREATED_MESSAGE_FORMAT,
                "You", type.getAmount(), type.name().replace("_", " ").toLowerCase()));
    }

    private void createRightAmountOfTypeRandomly(ShipType type) {
        printMessage(String.format(CREATING_SHIP_MESSAGE_FORMAT, type.toString()));
        int count = 0;
        while (count != type.getAmount()) {
            Cell start = RandomCellGenerator.generateRandomCell();
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
