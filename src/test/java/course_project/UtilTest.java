package course_project;

import base.UnitBase;
import course_project.components.Coordinate;
import course_project.components.PlayingField;
import course_project.components.Ship;
import course_project.util.PlayingFieldPrinter;
import course_project.util.ship_placer.ComputerShipPlacer;
import course_project.util.ship_placer.ShipPlacer;
import course_project.util.ship_placer.UserShipPlacer;
import course_project.util.user_input_reader.UserShotInputReader;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UtilTest extends UnitBase {

    @Test
    void testPlatingFieldPrinter() {
        PlayingField field = new PlayingField();
        Ship ship1 = new Ship(1, Arrays.asList(new Coordinate(0, 0)));
        Ship ship2 = new Ship(2, Arrays.asList(new Coordinate(0, 2), new Coordinate(0, 3)));

        field.placeShip(ship1);
        field.placeShip(ship2);
        field.placeShot(new Coordinate(0, 0));

        String printedField = "\tA B C D E F G H I J \r\n" + // testing on Windows, so \r\n
                             "1\tX * 2 2 - - - - - - \r\n" +
                             "2\t* - - - - - - - - - \r\n" +
                             "3\t- - - - - - - - - - \r\n" +
                             "4\t- - - - - - - - - - \r\n" +
                             "5\t- - - - - - - - - - \r\n" +
                             "6\t- - - - - - - - - - \r\n" +
                             "7\t- - - - - - - - - - \r\n" +
                             "8\t- - - - - - - - - - \r\n" +
                             "9\t- - - - - - - - - - \r\n" +
                            "10\t- - - - - - - - - -";

        PlayingFieldPrinter printer = new PlayingFieldPrinter();
        printer.printField(field);

        assertTrue(getOutput().contains(printedField));

        printer.printShotCells(field);

        String printedShots = "\tA B C D E F G H I J \r\n" +
                             "1\tX * - - - - - - - - \r\n" +
                             "2\t* - - - - - - - - - \r\n" +
                             "3\t- - - - - - - - - - \r\n" +
                             "4\t- - - - - - - - - - \r\n" +
                             "5\t- - - - - - - - - - \r\n" +
                             "6\t- - - - - - - - - - \r\n" +
                             "7\t- - - - - - - - - - \r\n" +
                             "8\t- - - - - - - - - - \r\n" +
                             "9\t- - - - - - - - - - \r\n" +
                            "10\t- - - - - - - - - -";

        assertTrue(getOutput().contains(printedShots));
    }

    @Test
    void testUserShipPlacer() {
        String input = "H1 hor\n" +
                       "A1 hor\n" +
                       "A2 hor\n" +
                       "A3 hor\n" +
                       "A5 hor\n" +
                       "A7 hor\n" +
                       "A9 hor\n" +
                       "D9 ver\n" +
                       "J1 ver\n" +
                       "J3 ver\n" +
                       "J5 ver\n" +
                       "Z5 ver\n" +
                       "J7 ver";
        setInput(input);

        PlayingField field = new PlayingField();
        ShipPlacer placer = new UserShipPlacer(new Scanner(System.in));

        placer.placeShips(field);

        int actualSize = field.getPlayersShips().size();

        assertEquals(10, actualSize);
    }

    @Test
    void testComputerShipPlacer() {
        PlayingField field = new PlayingField();
        ShipPlacer placer = new ComputerShipPlacer();

        placer.placeShips(field);

        int actualSize = field.getPlayersShips().size();

        assertEquals(10, actualSize);
    }

    @Test
    void testUserShotInputReader() {
        String input = "A11\n" +
                "A10";
        setInput(input);

        Coordinate expected = new Coordinate(9, 0);

        UserShotInputReader reader = new UserShotInputReader(new Scanner(System.in));
        Coordinate pointFromReader = reader.getPointFromInput();

        assertEquals(expected, pointFromReader);
    }
}
