package course_project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class SeaBattleTest {
    SeaBattle game = new SeaBattle("\n", " ");

    @Test
    void setPlayerNamesTest() {
        //SeaBattle game = new SeaBattle("\n", " ");
        Assertions.assertEquals("Unknown1", game.getPlayer1().getName());
        Assertions.assertEquals("Unknown2", game.getPlayer2().getName());
    }

    @Test
    void shipIsInAStraightLineTest() {
        Assertions.assertTrue(Ship.shipIsInAStraightLine(4, new int[]{2, 3}, new int[]{5, 3}));
        Assertions.assertFalse(Ship.shipIsInAStraightLine(4, new int[]{2, 3}, new int[]{5, 2}));
    }

    @Test
    void rightShipLengthTest() {
        Assertions.assertTrue(Ship.rightShipLength(4, new int[]{2, 3}, new int[]{5, 3}));
        Assertions.assertFalse(Ship.rightShipLength(4, new int[]{2, 3}, new int[]{4, 3}));
        Assertions.assertTrue(Ship.rightShipLength(1, new int[]{2, 3}, new int[]{2, 3}));
        Assertions.assertFalse(Ship.rightShipLength(1, new int[]{2, 3}, new int[]{1, 3}));
    }

    @Test
    void cellBelongsToShipTest() {
        Ship ship = new Ship(4, new int[][] {{1, 2}, {1, 3}, {1, 4}, {1, 5}});
        Assertions.assertTrue(ship.cellBelongsToShip(new int[]{1, 3}));
        Assertions.assertFalse(ship.cellBelongsToShip(new int[]{2, 3}));
    }

    @Test
    void setShipHitAndSunkTest() {
        Ship ship = new Ship(2, new int[][] {{1, 2, 0}, {1, 3, 0}});
        assertSame(ship.getShipStatus(), Ship.status.INTACT);
        ship.setCellHit(new int[]{1, 2});
        ship.setCellHit(new int[]{1, 3});
        assertSame(ship.getShipStatus(), Ship.status.SUNK);
    }

}