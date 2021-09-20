package course_project.sea_battle;

import course_project.sea_battle.boards.MyBoard;
import course_project.sea_battle.boards.MyShots;
import course_project.sea_battle.model.Player;
import course_project.sea_battle.model.Point;
import course_project.sea_battle.model.Ship;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    @Test
    void testPoint() {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(1, 2);
        Point point3 = new Point(3, 3);

        assertEquals(1, point1.getX());
        assertEquals(2, point1.getY());
        assertEquals(point1, point2);
        assertEquals(point1.hashCode(), point2.hashCode());
        assertNotEquals(point1, point3);
        assertEquals("[1,2]", point1.toString());
    }

    @Test
    void testShip() {
        ArrayList<Point> shipCoordinates = new ArrayList<>();
        shipCoordinates.add(new Point(0, 0));
        shipCoordinates.add(new Point(0, 1));

        Ship ship = new Ship(shipCoordinates);

        assertEquals(shipCoordinates, ship.getCoordinates());
        assertEquals(2, ship.getCoordinates().size());

        assertTrue(ship.isAlive());
        assertEquals(2, ship.getLives());
        ship.setLives(0);
        assertFalse(ship.isAlive());
    }

    @Test
    void testBoard() {
        int[][] myBoardTest = new int[10][10];

        MyBoard myBoard = new MyBoard();
        MyShots myShots = new MyShots();

        Player player = new Player(myBoard, myShots);
        assertEquals(0, player.getMyShips().size());

        List<Point> coordinates = new ArrayList<>();
        coordinates.add(new Point(0, 0));
        coordinates.add(new Point(0, 1));

        Ship ship = new Ship(coordinates);
        player.getMyBoard().placeShip(ship);
        player.getMyShips().add(ship);

        assertEquals(1, player.getMyShips().size());

        myBoardTest[0][0] = 1;
        myBoardTest[0][1] = 1;
        assertArrayEquals(myBoardTest, myBoard.getBoard());
    }

}