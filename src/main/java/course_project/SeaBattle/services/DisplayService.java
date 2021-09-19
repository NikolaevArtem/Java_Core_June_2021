package course_project.SeaBattle.services;

import course_project.SeaBattle.models.Player;
import course_project.SeaBattle.models.Ship;
import course_project.SeaBattle.view.ConsolePrinter;
import course_project.SeaBattle.view.MenuScreen;

public class DisplayService {

    static ConsolePrinter consolePrinter = new ConsolePrinter();
    static MenuScreen menuScreen = new MenuScreen();

    public static void showMainMenuScreen() {
        menuScreen.printMainMenu();
    }

    public static void showChooseShipArrangeModScreen() {
        menuScreen.printShipArrangeMod();
    }

    public static void showEnterNameScreen() {
        menuScreen.printEnterName();
    }

    public static void showMainBattleScreen(Player shooterPlayer) {
        consolePrinter.printBattleGrids(shooterPlayer);
    }

    public static void showPrepareBattleScreen(Player preparePlayer) {
        consolePrinter.printPrepareGrid(preparePlayer);
    }

    public static void showCheersWinnerScreen(Player winner) {
        consolePrinter.cheersMessage(winner);
    }

    public static void showPrepareShipMessage(Ship ship) {
        consolePrinter.printPrepareShipMessage(ship);
    }

    public static void getShipDirection() {
        consolePrinter.printShipDirectionRequest();
    }

    public static void errorArrangeShip() {
        consolePrinter.printErrorShipArrange();
    }

    public static void cleanScreen() {
        menuScreen.printClearScreen();
    }

    public static void callPlayerScreen() {
        menuScreen.printCallPlayer();
    }

    public static void showHitMsg(Player player) {
        if (!player.isComputer()){
            consolePrinter.printHit();
        }
    }

    public static void showMissMsg(Player player) {
        if (!player.isComputer()){
            consolePrinter.printMiss();
        }

    }

    public static void showScoreMsg(int score) {
            consolePrinter.printScore(score);
    }
}
