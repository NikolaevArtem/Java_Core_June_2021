package course_project.battleship_game.service;

import course_project.battleship_game.model.Board;
import course_project.battleship_game.model.Cell;
import course_project.battleship_game.model.CellStatus;
import course_project.battleship_game.model.Player;
import course_project.battleship_game.model.Ship;

import static course_project.battleship_game.utils.Constants.DEFAULT_COMPUTER_NAME;
import static course_project.battleship_game.utils.Constants.HIT_MESSAGE_FORMAT;
import static course_project.battleship_game.utils.Constants.MISSED_MESSAGE_FORMAT;
import static course_project.battleship_game.utils.Constants.PLAYER_MOVE_MESSAGE_FORMAT;
import static course_project.battleship_game.utils.Constants.SAME_COORDINATE_ERROR_MESSAGE;
import static course_project.battleship_game.utils.InputUtils.getCell;
import static course_project.battleship_game.utils.PrintUtils.printMessage;

public class PlayerService {
    private final Player player;

    public PlayerService(Player player) {
        this.player = player;
    }

    public boolean isMoveSuccessful(Player enemy) {
        Cell cell = null;
        while (cell == null || !player.getLogOfMoves().contains(cell)) {
            if (player.getName().contains(DEFAULT_COMPUTER_NAME)) {
                cell = new CreateService().createRandomCell();
            } else {
                cell = getCell();
            }

            if (!player.getLogOfMoves().contains(cell)) {
                player.getLogOfMoves().add(cell);
            } else {
                if (!player.getName().contains(DEFAULT_COMPUTER_NAME)) {
                    printMessage(SAME_COORDINATE_ERROR_MESSAGE);
                    cell = null;
                }
            }
        }
        printMessage(String.format(PLAYER_MOVE_MESSAGE_FORMAT, player.getName(), cell.toString()));
        boolean hit = isHitCellOnBoard(enemy.getBoard(), cell); //new BoardService(enemy.getBoard()).isHitCellOnBoard(cell);
        if (hit) {
            printMessage(String.format(HIT_MESSAGE_FORMAT, player.getName(), enemy.getName(), cell.toString()));
        } else {
            printMessage(String.format(MISSED_MESSAGE_FORMAT, player.getName(), cell.toString()));
        }
        return hit;
    }


    public boolean isNoMoreAliveShipsForBoard() {
        return player.getBoard().getShipList().stream().allMatch(ship -> new ShipService(ship).isNotAlive());
    }

    private boolean isHitCellOnBoard(Board board, Cell cell) {
        Ship shipResult = board.getShipList().stream()
                .filter(ship ->
                        ship.getCellsList().stream()
                                .anyMatch(cell1 -> cell1.equals(cell))).findFirst().orElse(null);
        boolean hit = shipResult != null && new ShipService(shipResult).isHit(cell);
        if (!hit) {
            board.getBoardMatrix()[cell.getY()][cell.getX()].setCellStatus(CellStatus.MISSED);
        }
        return hit;
    }
}
