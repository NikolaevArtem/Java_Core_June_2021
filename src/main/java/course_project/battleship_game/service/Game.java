package course_project.battleship_game.service;

import course_project.battleship_game.model.GameMode;
import course_project.battleship_game.model.Player;

import java.util.concurrent.ThreadLocalRandom;

import static course_project.battleship_game.utils.Constants.FLEETS_CREATED_MESSAGE;
import static course_project.battleship_game.utils.Constants.PLAYER_TURN_MESSAGE_FORMAT;
import static course_project.battleship_game.utils.Constants.PLAYER_WINNER_MESSAGE_FORMAT;
import static course_project.battleship_game.utils.Constants.ROLLING_DICE_MESSAGE;
import static course_project.battleship_game.utils.Constants.WELCOME_MESSAGE;
import static course_project.battleship_game.utils.InputUtils.getGameMode;
import static course_project.battleship_game.utils.PrintUtils.printBoards;
import static course_project.battleship_game.utils.PrintUtils.printMessage;

public class Game {

    public void run() {
        printMessage(WELCOME_MESSAGE);
        GameMode gameMode = getGameMode();
        CreateService createService = new CreateService();
        Player[] players = createService.createPlayers(gameMode);
        rollingDiceToChooseWhoStarts(players);
        Player player1 = players[0];
        Player player2 = players[1];
        createService.createFleet(player1);
        createService.createFleet(player2);
        printMessage(FLEETS_CREATED_MESSAGE);
        boolean isGameOver = false;
        while (!isGameOver) {
            isGameOver = isGameOver(player1, player2, gameMode);
            if (!isGameOver) {
                isGameOver = isGameOver(player2, player1, gameMode);
            }
        }
        determineWinner(player1, player2);
    }

    private boolean isGameOver(Player player1, Player player2, GameMode gameMode) {
        boolean isMoveSuccessful = true;
        printMessage(String.format(PLAYER_TURN_MESSAGE_FORMAT, player1.getName()));
        while (isMoveSuccessful && !isNoMoreAliveShips(player1, player2)) {
            isMoveSuccessful = new PlayerService(player1).isMoveSuccessful(player2);
            printBoards(gameMode, player1, player2);
        }
        return isNoMoreAliveShips(player1, player2);
    }

    private void rollingDiceToChooseWhoStarts(Player[] players) {
        printMessage(ROLLING_DICE_MESSAGE);
        int dice = ThreadLocalRandom.current().nextInt(0, 2);
        if (dice == 1) {
            Player temp = players[0];
            players[0] = players[1];
            players[1] = temp;
        }
        printMessage(players[0].getName() + " will go first\n");
    }

    private boolean isNoMoreAliveShips(Player player1, Player player2) {
        return new PlayerService(player1).isNoMoreAliveShipsForBoard() || new PlayerService(player2).isNoMoreAliveShipsForBoard();
    }

    private void determineWinner(Player player1, Player player2) {
        if (isNoMoreAliveShips(player1, player2)) {
            long player1Fleet = new BoardService(player1.getBoard()).countRemainedShipsForBoard();
            long player2Fleet = new BoardService(player2.getBoard()).countRemainedShipsForBoard();
            Player winner = player1Fleet > player2Fleet ? player1 : player2;
            printMessage(String.format(PLAYER_WINNER_MESSAGE_FORMAT, winner.getName()));
        }
    }

}
