package course_project.battleship_game.service;

import course_project.battleship_game.controller.InputController;
import course_project.battleship_game.controller.PrintController;
import course_project.battleship_game.exception.GameException;
import course_project.battleship_game.model.GameMode;
import course_project.battleship_game.model.Player;

import java.util.concurrent.ThreadLocalRandom;

import static course_project.battleship_game.controller.PrintController.printMessage;
import static course_project.battleship_game.utils.Constants.DEFAULT_COMPUTER_NAME;
import static course_project.battleship_game.utils.Constants.PLAYER_TURN_MESSAGE_FORMAT;
import static course_project.battleship_game.utils.Constants.PLAYER_WINNER_MESSAGE_FORMAT;
import static course_project.battleship_game.utils.Constants.ROLLING_DICE_MESSAGE;

public class GameService {
    private final InputController inputController = new InputController();
    private final PrintController printController = new PrintController();

    public Player[] createPlayers(GameMode mode) {
        Player[] players = new Player[2];
        players[0] = mode.equals(GameMode.CVC) ? new Player(DEFAULT_COMPUTER_NAME + " Mimi", 0) :
                new Player(inputController.getPlayerName(), inputController.getModeToCreateFleet());
        players[1] = !mode.equals(GameMode.PVP) ? new Player(DEFAULT_COMPUTER_NAME + " Navi", 0) :
                new Player(inputController.getPlayerName(), inputController.getModeToCreateFleet());
        return players;
    }

    public void rollingDiceToChooseWhoStarts(Player[] players) {
        printMessage(ROLLING_DICE_MESSAGE);
        int dice = ThreadLocalRandom.current().nextInt(1, 3);
        printMessage("Dice is " + dice + "\n");
        if (dice == 2) {
            Player temp = players[0];
            players[0] = players[1];
            players[1] = temp;
        }
        printMessage(players[0].getName() + " will go first\n");
    }

    public void createFleet(Player[] players) {
        if (players.length != 2) {
            throw new GameException();
        }
        new PlayerService(players[0]).createFleetForPlayer();
        new PlayerService(players[1]).createFleetForPlayer();
    }

    public boolean isGameOver(Player player1, Player player2, GameMode gameMode) {
        boolean isMoveSuccessful = true;
        printMessage(String.format(PLAYER_TURN_MESSAGE_FORMAT, player1.getName()));
        while (isMoveSuccessful && !isNoMoreAliveShips(player1, player2)) {
            isMoveSuccessful = new PlayerService(player1).isMoveSuccessful(player2);
            printController.printBoards(gameMode, player1, player2);
        }
        return isNoMoreAliveShips(player1, player2);
    }

    public void determineWinner(Player[] players) {
        Player player1 = players[0];
        Player player2 = players[1];
        if (isNoMoreAliveShips(player1, player2)) {
            long player1Fleet = new PlayerService(player1).countRemainedShips();
            long player2Fleet = new PlayerService(player2).countRemainedShips();
            Player winner = player1Fleet > player2Fleet ? player1 : player2;
            printMessage(String.format(PLAYER_WINNER_MESSAGE_FORMAT, winner.getName()));
        }
    }

    private boolean isNoMoreAliveShips(Player player1, Player player2) {
        return new PlayerService(player1).isNoMoreAliveShips() || new PlayerService(player2).isNoMoreAliveShips();
    }

}
