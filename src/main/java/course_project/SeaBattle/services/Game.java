package course_project.SeaBattle.services;

import course_project.SeaBattle.models.Player;
import course_project.SeaBattle.utility.FileOutputScoreUtil;

public class Game extends Thread {

    public void run() {

        DisplayService.showMainMenuScreen();

        InitialGameService.createGame();

        while (PlayerService.isBattleGoing()) {
            Player currentTurnPlayer = PlayerService.getWhoseTurn();
            DisplayService.showMainBattleScreen(currentTurnPlayer);
            PlayerService.fire(currentTurnPlayer);
        }

        DisplayService.showCheersWinnerScreen(PlayerService.getWinner());
        DisplayService.showScoreMsg(PlayerService.getScore());

        FileOutputScoreUtil.saveScore();
    }
}
