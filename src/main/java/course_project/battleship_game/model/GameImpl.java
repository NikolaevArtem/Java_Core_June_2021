package course_project.battleship_game.model;

import course_project.battleship_game.view.View;

import java.util.concurrent.ThreadLocalRandom;

import static course_project.battleship_game.utils.Constants.DEFAULT_COMPUTER_NAME;
import static course_project.battleship_game.utils.Constants.FLEETS_CREATED_MESSAGE;
import static course_project.battleship_game.utils.Constants.PLAYER_TURN_MESSAGE_FORMAT;
import static course_project.battleship_game.utils.Constants.PLAYER_WINNER_MESSAGE_FORMAT;
import static course_project.battleship_game.utils.Constants.ROLLING_DICE_MESSAGE;
import static course_project.battleship_game.utils.Constants.WELCOME_MESSAGE;

public class GameImpl implements Game {
    private final View view = new View();

    @Override
    public void run() {
        view.printMessage(WELCOME_MESSAGE);
        GameMode gameMode = view.getGameMode();
        Player[] players = createPlayers(gameMode);
        rollingDiceToChooseWhoStarts(players);
        Player player1 = players[0];
        Player player2 = players[1];
        player1.createFleet(view);
        player2.createFleet(view);
        view.printMessage(FLEETS_CREATED_MESSAGE);
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
        view.printMessage(String.format(PLAYER_TURN_MESSAGE_FORMAT, player1.getName()));
        while (isMoveSuccessful && !isNoMoreAliveShips(player1, player2)) {
            isMoveSuccessful = player1.isMoveSuccessful(player2, view);
            printBoard(gameMode, player1, player2);
        }
        return isNoMoreAliveShips(player1, player2);
    }

    private void printBoard(GameMode mode, Player player1, Player player2) {
        if (mode.equals(GameMode.CVC) || !player1.getName().contains(DEFAULT_COMPUTER_NAME)) {
            view.printBoardForPlayer(player1, false);
            view.printBoardForPlayer(player2, true);
        }
    }

    private Player[] createPlayers(GameMode mode) {
        Player[] players = new Player[2];
        players[0] = mode.equals(GameMode.CVC) ? new Player(DEFAULT_COMPUTER_NAME + " Mimi", 0) :
                new Player(view.getPlayerName(), view.getModeToCreateFleet());
        players[1] = !mode.equals(GameMode.PVP) ? new Player(DEFAULT_COMPUTER_NAME + " Navi", 0) :
                new Player(view.getPlayerName(), view.getModeToCreateFleet());
        return players;
    }

    private void rollingDiceToChooseWhoStarts(Player[] players) {
        view.printMessage(ROLLING_DICE_MESSAGE);
        int dice = ThreadLocalRandom.current().nextInt(0, 2);
        if (dice == 1) {
            Player temp = players[0];
            players[0] = players[1];
            players[1] = temp;
        }
        view.printMessage(players[0].getName() + " will go first\n");
    }

    private boolean isNoMoreAliveShips(Player player1, Player player2) {
        return player1.getBoard().isNoMoreAliveShipsForBoard() || player2.getBoard().isNoMoreAliveShipsForBoard();
    }

    private void determineWinner(Player player1, Player player2) {
        if (isNoMoreAliveShips(player1, player2)) {
            long player1Fleet = player1.getBoard().countRemainedShips();
            long player2Fleet = player2.getBoard().countRemainedShips();
            Player winner = player1Fleet > player2Fleet ? player1 : player2;
            view.printMessage(String.format(PLAYER_WINNER_MESSAGE_FORMAT, winner.getName()));
        }
    }

}
