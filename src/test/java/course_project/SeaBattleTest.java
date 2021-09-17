package course_project;

import base.UnitBase;
import course_project.components.Coordinate;
import course_project.util.user_input_reader.UserShotInputReader;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class SeaBattleTest extends UnitBase {

    private static final String INPUT = "A1 hor\n" +
                                        "A3 hor\n" +
                                        "A5 hor\n" +
                                        "A7 hor\n" +
                                        "A9 hor\n" +
                                        "D9 ver\n" +
                                        "J1 ver\n" +
                                        "J3 ver\n" +
                                        "J5 ver\n" +
                                        "J7 ver";

    @Test
    void testPlacingUserShips() {
        setInput(INPUT);

        SeaBattle seaBattle = new SeaBattle();
        seaBattle.placePlayersShips();
        seaBattle.printer.printField(seaBattle.playersField);

        printOut();
    }

    @Test
    void testPlacingComputerShips() {
        SeaBattle seaBattle = new SeaBattle();
        seaBattle.placeComputerShips();
        seaBattle.printer.printField(seaBattle.enemyField);

        printOut();
    }

    @Test
    void testShooting() {
        SeaBattle seaBattle = new SeaBattle();
        seaBattle.placeComputerShips();

        setInput("A10");
        Coordinate shotCoordinate = new UserShotInputReader(new Scanner(System.in)).getPointFromInput();
        seaBattle.playersShot(shotCoordinate);
        seaBattle.printer.printField(seaBattle.enemyField);

        printOut();
    }
}
