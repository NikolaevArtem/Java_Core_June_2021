package course_project.SeaBattle.Services;

import course_project.SeaBattle.Models.Player;


import static course_project.SeaBattle.Utility.Input.getSquare;

public class Game extends Thread {

    public void run() {
        int mod = 0;

        InitialGameService.createPlayers(1);

        while (PlayerService.isBattleGoing()) {

            DisplayService.display(PlayerService.playerTurn());

            System.out.println(PlayerService.playerTurn().getName() + " shooter");

            PlayerService.shotProcess(PlayerService.playerTurn(), getSquare());


        }



    }

}
