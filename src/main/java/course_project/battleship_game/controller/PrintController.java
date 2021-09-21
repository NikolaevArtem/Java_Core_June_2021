package course_project.battleship_game.controller;

import course_project.battleship_game.model.Cell;
import course_project.battleship_game.model.CellStatus;
import course_project.battleship_game.model.GameMode;
import course_project.battleship_game.model.Player;

import static course_project.battleship_game.utils.Constants.DEFAULT_COMPUTER_NAME;
import static course_project.battleship_game.utils.Constants.PLAYER_BOARD_MESSAGE_FORMAT;
import static java.lang.System.lineSeparator;

public class PrintController {

    public static void printMessage(String message) {
        System.out.print(message);
    }

    public void printBoards(GameMode mode, Player player1, Player player2) {
        if (mode.equals(GameMode.CVC) || !player1.getName().contains(DEFAULT_COMPUTER_NAME)) {
            printBoardForPlayer(player1, false);
            printBoardForPlayer(player2, true);
        }
    }

    public void printBoardForPlayer(Player player, boolean isEnemy) {
        printMessage(String.format(PLAYER_BOARD_MESSAGE_FORMAT, player.getName()));
        printHeader();
        Cell[][] boardMatrix = player.getBoard().getBoardMatrix();
        for (int y = 0; y < boardMatrix.length; y++) {
            printMessage((char) (65 + y) + " ");
            for (int x = 0; x < boardMatrix.length; x++) {
                printCell(isEnemy, boardMatrix[y][x]);
            }
            printMessage(lineSeparator());
        }
    }

    private void printCell(boolean isEnemy, Cell cell) {
        if (isEnemy && cell.getCellStatus().equals(CellStatus.SHIP)) {
            printMessage(CellStatus.EMPTY.getCharacter());
        } else {
            printMessage(cell.getCellStatus().getCharacter());
        }
    }

    private void printHeader() {
        printMessage("   ");
        for (int i = 1; i < 11; i++) {
            printMessage(i + " ");
        }
        printMessage(lineSeparator());
    }
}
