package course_project;

import base.UnitBase;
import course_project.components.Coordinate;
import course_project.util.UserInputReader;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class SeaBattleTest extends UnitBase {

    private static final String INPUT = "A 1 hor\n" +
                                        "A 3 hor\n" +
                                        "A 5 hor\n" +
                                        "A 7 hor\n" +
                                        "A 9 hor\n" +
                                        "D 9 ver\n" +
                                        "J 1 ver\n" +
                                        "J 3 ver\n" +
                                        "J 5 ver\n" +
                                        "J 7 ver";

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

        setInput("A 10");
        Coordinate shotCoordinate = UserInputReader.getInputForShot(new Scanner(System.in));
        seaBattle.playersShot(shotCoordinate);
        seaBattle.printer.printField(seaBattle.enemyField);

        printOut();
    }
}
