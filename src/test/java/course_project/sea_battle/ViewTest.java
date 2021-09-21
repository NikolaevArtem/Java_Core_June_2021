package course_project.sea_battle;

import base.UnitBase;
import course_project.sea_battle.boards.MyBoard;
import course_project.sea_battle.boards.MyShots;
import course_project.sea_battle.model.Player;
import course_project.sea_battle.model.Point;
import course_project.sea_battle.model.Ship;
import course_project.sea_battle.model.Shot;
import course_project.sea_battle.service.inputs.BigSpace;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

import static course_project.sea_battle.service.inputs.InputShooterReader.putOnBoard;
import static course_project.sea_battle.view.BoardPrinter.showBoards;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ViewTest extends UnitBase {

    private static final String CYAN = "\u001B[36m";
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";

    private static final String MISS = GREEN + "0" + RESET;
    private static final String HIT = RED + "X" + RESET;
    private static final String WAVE = CYAN + "~" + RESET;

    MyBoard myBoard;
    MyShots myShots;
    Player player1;

    @Test
    void testBigSpacePrinter() {
        String input = "\n";
        setInput(input);

        new BigSpace(new Scanner(System.in)).printBigSpace();
        String expected = "Press ENTER to finish your move\n" +
                ".\n" +
                ".\n" +
                ".\n" +
                ".\n" +
                ".";
        assertEquals(expected, getOutput().replaceAll("\r", ""));
    }

    @Test
    void testBoardPrinterEmptyBoard() {
        createPlayers();
        player1.setName("Tom");

        showBoards(player1);
        String expected = "MY BOARD (Tom) vs ENEMY BOARD\n" + "\n" +
                "\t A  B  C  D  E  F  G  H  I  J \t\t\t A  B  C  D  E  F  G  H  I  J \n" +
                "  1  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  1  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  2  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  2  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  3  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  3  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  4  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  4  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  5  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  5  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  6  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  6  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  7  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  7  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  8  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  8  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  9  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  9  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                " 10  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t 10  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~";

        assertEquals(expected, getOutput().replace(WAVE, "~").replaceAll("\r", ""));
    }

    @Test
    void testBoardPrinterShipPlacer() {
        createPlayers();

        Ship ship1 = new Ship(Arrays.asList(new Point(0, 1), new Point(1, 1)));
        myBoard.placeShip(ship1);

        showBoards(player1);
        String expected = "MY BOARD (null) vs ENEMY BOARD\n" + "\n" +
                "\t A  B  C  D  E  F  G  H  I  J \t\t\t A  B  C  D  E  F  G  H  I  J \n" +
                "  1  ~  W  ~  ~  ~  ~  ~  ~  ~  ~\t\t  1  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  2  ~  W  ~  ~  ~  ~  ~  ~  ~  ~\t\t  2  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  3  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  3  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  4  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  4  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  5  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  5  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  6  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  6  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  7  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  7  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  8  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  8  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  9  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  9  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                " 10  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t 10  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~";

        assertEquals(expected, getOutput().replace(WAVE, "~").replaceAll("\r", ""));
    }

    @Test
    void testBoardPrinterMyShots() {
        createPlayers();

        putOnBoard(myShots, new Point(0,0), Shot.MISS);
        putOnBoard(myShots, new Point(1,1), Shot.HIT);
        putOnBoard(myShots, new Point(2,2), Shot.KILLED);

        showBoards(player1);
        String expected = "MY BOARD (null) vs ENEMY BOARD\n" + "\n" +
                "\t A  B  C  D  E  F  G  H  I  J \t\t\t A  B  C  D  E  F  G  H  I  J \n" +
                "  1  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  1  0  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  2  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  2  ~  X  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  3  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  3  ~  ~  X  ~  ~  ~  ~  ~  ~  ~\n" +
                "  4  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  4  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  5  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  5  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  6  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  6  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  7  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  7  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  8  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  8  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  9  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  9  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                " 10  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t 10  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~";

        assertEquals(expected, getOutput()
                .replace(WAVE, "~")
                .replace(MISS, "0")
                .replace(HIT, "X")
                .replaceAll("\r", ""));

    }

    @Test
    void testBoardPrinterEnemyShots() {
        createPlayers();

        putOnBoard(myBoard, new Point(0,1), Shot.MISS);
        putOnBoard(myBoard, new Point(0,2), Shot.HIT);
        putOnBoard(myBoard, new Point(0,3), Shot.KILLED);

        showBoards(player1);
        String expected = "MY BOARD (null) vs ENEMY BOARD\n" + "\n" +
                "\t A  B  C  D  E  F  G  H  I  J \t\t\t A  B  C  D  E  F  G  H  I  J \n" +
                "  1  ~  0  X  X  ~  ~  ~  ~  ~  ~\t\t  1  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  2  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  2  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  3  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  3  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  4  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  4  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  5  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  5  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  6  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  6  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  7  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  7  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  8  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  8  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                "  9  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  9  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n" +
                " 10  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t 10  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~";

        assertEquals(expected, getOutput()
                .replace(WAVE, "~")
                .replace(MISS, "0")
                .replace(HIT, "X")
                .replaceAll("\r", ""));
    }

    private void createPlayers() {
        myBoard = new MyBoard();
        myShots = new MyShots();
        player1 = new Player(myBoard, myShots);
    }

}
