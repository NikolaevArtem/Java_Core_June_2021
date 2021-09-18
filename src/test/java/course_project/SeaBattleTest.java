package course_project;

import base.UnitBase;
import course_project.components.Coordinate;
import course_project.components.PlayingField;
import course_project.components.Ship;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeaBattleTest extends UnitBase {

    @Test
    void testPlacing() {
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

        SeaBattle seaBattle = new SeaBattle();

        seaBattle.placePlayersShips();
        int numOfPlayersShips = seaBattle.playersField.getPlayersShips().size();

        assertEquals(10, numOfPlayersShips);

        seaBattle.placeComputerShips();
        int numOfComputerShips = seaBattle.enemyField.getPlayersShips().size();

        assertEquals(10, numOfComputerShips);
    }

    @Test
    void testMoves() {
        String input = "A10\n" +
                       "A1";
        setInput(input);

        List<Coordinate> coordinates = new ArrayList<>();

        coordinates.add(new Coordinate(0, 0));
        Ship ship1 = new Ship(1, coordinates);

        coordinates.add(new Coordinate(0, 1));
        Ship ship2 = new Ship(1, coordinates);

        SeaBattle seaBattle = new SeaBattle();
        addShipToField(coordinates, ship1, seaBattle.enemyField);
        addShipToField(coordinates, ship2, seaBattle.playersField);

        int numOfPlayerShips = seaBattle.playersField.getPlayersShips().size();
        int numOfComputerShips = seaBattle.enemyField.getPlayersShips().size();

        assertEquals(1, numOfPlayerShips);
        assertEquals(1, numOfComputerShips);

        seaBattle.makeMoves();

        numOfPlayerShips = seaBattle.playersField.getPlayersShips().size();
        numOfComputerShips = seaBattle.enemyField.getPlayersShips().size();

        assertEquals(1, numOfPlayerShips);
        assertEquals(0, numOfComputerShips);
    }

    private void addShipToField(List<Coordinate> coordinates, Ship ship1, PlayingField field) {
        field.getPlayersShips().add(ship1);
        Map<Coordinate, Ship> map = field.getCoordinateMapping();
        map.put(coordinates.get(0), ship1);
    }

    @Test
    void testDefineWinner() {
        SeaBattle seaBattle = new SeaBattle();
        Ship ship = new Ship(1, Arrays.asList(new Coordinate(0, 0)));
        List<Ship> playersShips = seaBattle.playersField.getPlayersShips();
        playersShips.add(ship);

        seaBattle.defineWinner();

        assertEquals("Player won!", getOutput());
        
        removeFromOutput("Player won!");
        playersShips.remove(0);

        seaBattle.enemyField.getPlayersShips().add(ship);

        seaBattle.defineWinner();

        assertEquals("Computer won!", getOutput());
    }
}
