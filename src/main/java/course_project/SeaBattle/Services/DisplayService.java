package course_project.SeaBattle.Services;

import course_project.SeaBattle.Models.Player;
import course_project.SeaBattle.View.ConsolePrinter;

public class DisplayService {

    static ConsolePrinter consolePrinter = new ConsolePrinter();

    public static void display(Player shooterPlayer) {
       consolePrinter.printBattleGrids(shooterPlayer);
    }

    public static void prepareDisplay(Player preparePlayer) {
        consolePrinter.printPrepareGrid(preparePlayer);
    }

}
