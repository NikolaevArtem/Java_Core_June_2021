package course_project.SeaBattle.services;

import course_project.SeaBattle.models.Player;
import course_project.SeaBattle.utility.FileOutputScoreUtil;

public class Game extends Thread {

    public void run() {

        DisplayService.showMainMenuScreen();

        InitialGameService.createGame();

        while (PlayerService.isBattleGoing()) {
            Player currentPlayerTurn = PlayerService.getWhoseTurn();
            DisplayService.showMainBattleScreen(currentPlayerTurn);
            PlayerService.fire(currentPlayerTurn);
        }

        DisplayService.showCheersWinnerScreen(PlayerService.getWinner());

        DisplayService.showScore(PlayerService.getScore());

        FileOutputScoreUtil.saveScore();
    }
}
