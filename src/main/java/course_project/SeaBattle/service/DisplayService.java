package course_project.SeaBattle.service;

import course_project.SeaBattle.model.Player;
import course_project.SeaBattle.model.Ship;
import course_project.SeaBattle.model.Square;
import course_project.SeaBattle.view.ConsolePrinter;
import course_project.SeaBattle.view.Printer;

public class DisplayService {

    static Printer printer = new ConsolePrinter();

    public static void showMainMenuScreen() {
        printer.printMainMenu();
    }

    public static void showChooseShipArrangeModScreen() {
        printer.printShipArrangeMod();
    }

    public static void showEnterNameScreen() {
        printer.printEnterName();
    }

    public static void showMainBattleScreen(Player shooterPlayer) {
        printer.printBattleGrids(shooterPlayer);
    }

    public static void showPrepareBattleScreen(Player preparePlayer) {
        printer.printPrepareGrid(preparePlayer);
    }

    public static void showCheersWinnerScreen(Player winner) {
        printer.cheersMessage(winner);
        printer.printScore(PlayerService.getScore());
    }

    public static void showPrepareShipMessage(Ship ship) {
        printer.printPrepareShipMessage(ship);
    }

    public static void getShipDirection() {
        printer.printShipDirectionRequest();
    }

    public static void errorArrangeShip() {
        printer.printErrorShipArrange();
    }

    public static void cleanScreen() {
        printer.printClearScreen();
    }

    public static void callPlayerScreen() {
        printer.printCallPlayer();
    }

    public static void showHitMsg(Player player, Square square) {
        printer.printHit(player, square);
    }

    public static void showDestroyMsg(Player enemy, Ship ship){
        printer.printDestroyMsg(enemy, ship);
    }

    public static void showMissMsg(Player player) {
        printer.printMiss(player);
    }

    public static void showMsgAlreadyShot(Player player) {
        if (player.isComputer()){
            printer.printMsgAlreadyShot();
        }
    }
}
