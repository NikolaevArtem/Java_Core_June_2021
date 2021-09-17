package course_project.SeaBattle.Controller;

import course_project.SeaBattle.Models.Player;
import course_project.SeaBattle.View.ConsolePrinter;

import java.util.List;

import static course_project.SeaBattle.Utility.Input.getSquare;

public class Game {

    public void start() {

        InitialGameService initialGameService = new InitialGameService();
        GridService gridService = new GridService();
        FrameService FrameController = new FrameService();
        PlayerService playerService = new PlayerService();

        List<Player> playerList = initialGameService.getListPlayers();

        gridService.fillPlayerGrid(playerList);
        FrameController.setPlayers(playerList);
        playerService.setPlayers(playerList);





        int count = 0;
        while (count < 100) {

            Player shooterPlayer = playerService.playerTurn();
            FrameController.display(shooterPlayer);
            System.out.println(shooterPlayer.getName() + " shooter");
            playerService.shotProcess(shooterPlayer, getSquare());


            count++;
        }



    }

}
