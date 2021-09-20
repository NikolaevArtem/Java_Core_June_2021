package course_project.sea_battle;

import base.UnitBase;
import course_project.sea_battle.boards.MyBoard;
import course_project.sea_battle.boards.MyShots;
import course_project.sea_battle.model.Player;
import course_project.sea_battle.model.Point;
import course_project.sea_battle.model.Ship;
import course_project.sea_battle.model.Shot;
import course_project.sea_battle.service.Engine;
import course_project.sea_battle.service.ShipPlacer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

import static course_project.sea_battle.view.BoardPrinter.showBoards;

public class ViewTest extends UnitBase {

    private static final String CYAN = "\u001B[36m";
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";

    private static final String MISS = GREEN + "0" + RESET;
    private static final String HIT = RED + "X" + RESET;
    private static final String WAVE = CYAN + "~" + RESET;

    private Shot shot;

    @Test
    void testBoardPrinterMyBoard() {
        MyBoard myBoard = new MyBoard();
        MyShots myShots = new MyShots();
        Player player1 = new Player(myBoard, myShots);

        Ship ship1 = new Ship(Arrays.asList(new Point(0, 1)));
        myBoard.placeShip(ship1);

        showBoards(player1);
        String expected1 =
                "  1  ~  W  ~  ~  ~  ~  ~  ~  ~  ~\t\t  1  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n";
        String expected2 =
                "  2  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  2  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\n";                ;
        assertEquals(expected1.trim(), getOutputLines()[3].replace(WAVE,"~").trim());
        assertEquals(expected2.trim(), getOutputLines()[4].replace(WAVE,"~").trim());


    }

    @Test
    void testBoardPrinterMyShotsIfMissed() {

        MyBoard myBoard2 = new MyBoard();
        MyShots myShots2 = new MyShots();
        Player player2 = new Player(myBoard2, myShots2);

        shot = Shot.KILLED;
        new Engine(new Scanner("b1")).putOnEnemyBoard(player2.getMyBoard());
        showBoards(player2);
        String expected2 =
                "  1  ~  ~  ~  ~  ~  ~  ~  ~  ~  ~\t\t  1  0  ~  ~  ~  ~  ~  ~  ~  ~  ~\n";
        assertEquals(expected2.trim(), getOutputLines()[3]
                .replace(WAVE, "~")
                .replace(MISS, "0")
                .replace(HIT, "X").trim());
    }

    @Test
    void testUserShipPlacer() {

        MyBoard myBoard = new MyBoard();
        MyShots myShots = new MyShots();
        Player player = new Player(myBoard, myShots);

//        Ship ship = new Ship(Arrays.asList(new Point(0, 1)));
//        myBoard.placeShip(ship);

        String input = "H1 hor\n" +
                "A1 h\n";
        setInput(input);

//        PlayingField field = new PlayingField();
        ShipPlacer placer = new ShipPlacer(new Scanner(input));

        placer.placeShip(player);
//        myBoard.placeShip();

        int actualSize = player.getMyShips().size();

        assertEquals(10, actualSize);
    }


//    @Test
//    void testUserShotInputReader() {
//        String input = "A11\n" +
//                "A10";
//        setInput(input);
//
//        Coordinate expected = new Coordinate(9, 0);
//
//        UserShotInputReader reader = new UserShotInputReader(new Scanner(System.in));
//        Coordinate pointFromReader = reader.getPointFromInput();
//
//        assertEquals(expected, pointFromReader);
//    }
}
