package course_project.SeaBattle.controller;

import course_project.SeaBattle.model.Player;
import course_project.SeaBattle.service.DisplayService;
import course_project.SeaBattle.service.InitialGameService;
import course_project.SeaBattle.service.PlayerService;
import course_project.SeaBattle.utility.FileOutputScoreUtil;

public class GameController extends Thread {

    public void run() {

        DisplayService.showMainMenuScreen();

        InitialGameService.createGame();

        while (PlayerService.isBattleGoing()) {
            Player currentTurnPlayer = PlayerService.getWhoseTurn();
            DisplayService.showMainBattleScreen(currentTurnPlayer);
            PlayerService.fire(currentTurnPlayer);
        }

        DisplayService.showCheersWinnerScreen(PlayerService.getWinner());

        FileOutputScoreUtil.saveScore();
    }
}
