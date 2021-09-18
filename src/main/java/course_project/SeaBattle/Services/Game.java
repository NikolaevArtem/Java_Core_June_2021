package course_project.SeaBattle.Services;

import course_project.SeaBattle.Models.Player;
import course_project.SeaBattle.Utility.FileOutputScoreUtil;

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
