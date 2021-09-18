package course_project;

import course_project.components.Coordinate;
import course_project.components.PlayingField;
import course_project.components.Ship;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComponentsTest {

    @Test
    void testCoordinate() {
        Coordinate cell1 = new Coordinate(0, 1);
        Coordinate cell2 = new Coordinate(0, 1);

        assertEquals(0, cell1.getX());
        assertEquals(1, cell1.getY());
        assertEquals(cell1, cell2);
        assertEquals(cell1.hashCode(), cell2.hashCode());
        assertEquals("B1", cell1.toString());
    }

    @Test
    void testShip() {
        ArrayList<Coordinate> shipCoordinates = new ArrayList<>();
        shipCoordinates.add(new Coordinate(0, 0));
        shipCoordinates.add(new Coordinate(0, 1));

        Ship ship = new Ship(shipCoordinates.size(), shipCoordinates);

        assertEquals(shipCoordinates, ship.getCoordinates());
        assertEquals(shipCoordinates.size(), ship.getSize());

        assertFalse(ship.isSunk());
        ship.gotShot();
        ship.gotShot();
        assertTrue(ship.isSunk());
    }

    @Test
    void testPlayingField() {
        int[][] fleet = new int[10][10];
        boolean[][] cellsShot = new boolean[10][10];
        HashMap<Coordinate, Ship> coordinateToShip = new HashMap<>(32);
        ArrayList<Ship> playersShips = new ArrayList<>();

        PlayingField field = new PlayingField();

        List<Coordinate> list = Arrays.asList(new Coordinate(0, 0), new Coordinate(0, 1));
        Ship ship = new Ship(list.size(), list);

        field.placeShip(ship);
        assertEquals(1, field.getPlayersShips().size());
        assertEquals(2, field.getCoordinateMapping().size());

        fleet[0][0] = 2;
        fleet[0][1] = 2;
        assertArrayEquals(fleet, field.getFleet());

        assertTrue(field.placeShot(new Coordinate(0, 0)));
        assertFalse(field.placeShot(new Coordinate(0, 0)));

        assertTrue(field.placeShot(new Coordinate(0, 1)));
        assertEquals(0, field.getPlayersShips().size());

        assertTrue(field.isCellShot(new Coordinate(0, 0)));
        cellsShot[0][0] = true;
        cellsShot[0][1] = true;
        cellsShot[0][2] = true;
        cellsShot[1][0] = true;
        cellsShot[1][1] = true;
        assertArrayEquals(cellsShot, field.getCellsShot());
    }
}
