package course_project.SeaBattle.view;

import course_project.SeaBattle.model.Player;
import course_project.SeaBattle.model.Ship;
import course_project.SeaBattle.model.Square;

public interface Printer {

    void printPrepareShipMessage(Ship ship);

    void printShipDirectionRequest();

    void printPrepareGrid(Player player);

    void printErrorShipArrange();

    void printBattleGrids(Player player);

    void printMiss(Player player);

    void printHit(Player player, Square square);

    void printMsgAlreadyShot();

    void printScore(int score);

    void cheersMessage(Player winner);

    void printMainMenu();

    void printShipArrangeMod();

    void printEnterName();

    void printClearScreen();

    void printCallPlayer();

    void printDestroyMsg(Player enemy, Ship ship);
}
