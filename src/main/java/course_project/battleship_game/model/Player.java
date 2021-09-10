package course_project.battleship_game.model;

import course_project.battleship_game.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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

public class Player {
    private final String name;
    private final Board board;
    private final int modeToCreateFleet;
    private final List<Cell> logOfMoves;

    public Player(String name, int modeToCreateFleet) {
        this.name = name;
        this.modeToCreateFleet = modeToCreateFleet;
        this.board = new Board();
        this.logOfMoves = new ArrayList<>();
    }

    public Board getBoard() {
        return board;
    }

    public String getName() {
        return name;
    }

    public boolean isMoveSuccessful(Player player, View view) {
        Cell cell = null;
        while (cell == null || !logOfMoves.contains(cell)) {
            if (this.name.contains(DEFAULT_COMPUTER_NAME)) {
                cell = Cell.generateRandomCell();
            } else {
                cell = view.getCell();
            }
            if (!logOfMoves.contains(cell)) {
                logOfMoves.add(cell);
            } else {
                if (!this.name.contains(DEFAULT_COMPUTER_NAME)) {
                    view.printMessage(SAME_COORDINATE_ERROR_MESSAGE);
                }
            }
        }
        view.printMessage(String.format(PLAYER_MOVE_MESSAGE_FORMAT, name, cell.toString()));
        boolean hit = player.board.isMoveSuccessful(cell);
        if (hit) {
            view.printMessage(String.format(HIT_MESSAGE_FORMAT, name, player.name, cell.toString()));
        } else {
            view.printMessage(String.format(MISSED_MESSAGE_FORMAT, name, cell.toString()));
        }
        return hit;
    }

    public void createFleet(View view) {
        view.printMessage(String.format(CREATING_FLEET_MESSAGE_FORMAT, name));
        if (modeToCreateFleet == 0) {
            createRightAmountOfTypeRandomly(view, ShipType.BATTLESHIP);
            createRightAmountOfTypeRandomly(view, ShipType.CRUISER);
            createRightAmountOfTypeRandomly(view, ShipType.DESTROYER);
            createRightAmountOfTypeRandomly(view, ShipType.TORPEDO_BOAT);
        } else {
            createRightAmountOfTypeManually(view, ShipType.BATTLESHIP);
            createRightAmountOfTypeManually(view, ShipType.CRUISER);
            createRightAmountOfTypeManually(view, ShipType.DESTROYER);
            createRightAmountOfTypeManually(view, ShipType.TORPEDO_BOAT);
        }
        view.printMessage(String.format(FLEET_CREATED_MESSAGE_FORMAT, name));
    }

    private void createRightAmountOfTypeManually(View view, ShipType type) {
        view.printMessage(String.format(CREATING_SHIP_MESSAGE_FORMAT, type.toString()));
        int count = 0;
        while (count != type.getAmount()) {
            Cell start = view.getCell();
            int direction = view.getDirection();
            start.setCellStatus(CellStatus.SHIP);
            boolean created = board.isCreatingShipSuccessful(start, type, direction);
            if (created) {
                count++;
                if (type.getAmount() - count != 0) {
                    view.printMessage(String.format(REMAINING_AMOUNT_OF_TYPE_TO_CREATE,
                            type.name().replace("_", " ").toLowerCase(), type.getAmount() - count));
                }
                view.printBoardForPlayer(this, false);
            } else {
                view.printMessage(ERROR_INPUT_MESSAGE);
            }
        }
        view.printMessage(String.format(SHIP_CREATED_MESSAGE_FORMAT,
                "You", type.getAmount(), type.name().replace("_", " ").toLowerCase()));
    }

    private void createRightAmountOfTypeRandomly(View view, ShipType type) {
        view.printMessage(String.format(CREATING_SHIP_MESSAGE_FORMAT, type.toString()));
        int count = 0;
        while (count != type.getAmount()) {
            Cell start = Cell.generateRandomCell();
            int direction = ThreadLocalRandom.current().nextInt(0, 2);
            boolean created = board.isCreatingShipSuccessful(start, type, direction);
            if (created) {
                count++;
            }
        }
        view.printMessage(String.format(SHIP_CREATED_MESSAGE_FORMAT,
                this.getName(), type.getAmount(), type.name().replace("_", " ").toLowerCase()));
    }

}
