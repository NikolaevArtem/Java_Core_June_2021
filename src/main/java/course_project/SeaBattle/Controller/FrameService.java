package course_project.SeaBattle.Controller;

import course_project.SeaBattle.Models.Player;
import course_project.SeaBattle.View.ConsolePrinter;

import java.util.List;

public class FrameService {

    List<Player> playerList;
    ConsolePrinter consolePrinter = new ConsolePrinter();

    public void display(Player shooterPlayer) {
       consolePrinter.printGrid(shooterPlayer);
    }

    public void setPlayers(List<Player> playerList) {
        this.playerList = playerList;
    }
}
