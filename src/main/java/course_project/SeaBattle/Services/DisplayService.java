package course_project.SeaBattle.Services;

import course_project.SeaBattle.Models.Player;
import course_project.SeaBattle.Models.Ship;
import course_project.SeaBattle.View.ConsolePrinter;
import course_project.SeaBattle.View.MenuScreen;

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

    public static void showHit(Player player) {
        if (!player.isComputer()){
            consolePrinter.printHit();
        }
    }

    public static void showMiss(Player player) {
        if (!player.isComputer()){
            consolePrinter.printMiss();
        }

    }

    public static void showDestroyed(Ship ship, Player player) {
        if (!player.isComputer()){
            consolePrinter.printDestroyedShip(ship);
        }
    }

    public static void showScore(int score) {
            consolePrinter.printScore(score);
    }
}
