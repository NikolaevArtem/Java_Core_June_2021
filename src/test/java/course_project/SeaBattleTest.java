package course_project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class SeaBattleTest {

    @Test
    void setPlayerNamesTest() {
        Player.numberOfUsers = 0;
        SeaBattle game = new SeaBattle("\n", " ");
        Assertions.assertEquals("Unknown1", game.getPlayer1().getName());
        Assertions.assertEquals("Unknown2", game.getPlayer2().getName());
    }

    @Test
    void stringToCellTest() {
        Assertions.assertArrayEquals(new int[]{3, 0}, Field.stringToCell("A4"));
        Assertions.assertArrayEquals(new int[]{0, 9}, Field.stringToCell("J1"));
        Assertions.assertNull(Field.stringToCell("A14"));
        Assertions.assertNull(Field.stringToCell("A-4"));
        Assertions.assertNull(Field.stringToCell("M4"));
        Assertions.assertNull(Field.stringToCell("a4"));
        Assertions.assertNull(Field.stringToCell("4"));
    }

    @Test
    void shipRightCreationTest() {
        SeaBattle game = new SeaBattle("Player1", "Player2");
        Assertions.assertTrue(game.getPlayer1().getField().createShip(4, new String[]{"A1", "A4"}));
        Assertions.assertTrue(game.getPlayer1().getField().createShip(1, new String[]{"J10"}));
    }

    @Test
    void shipWrongCreationTest() {
        SeaBattle game = new SeaBattle("Player1", "Player2");
        Assertions.assertFalse(game.getPlayer1().getField().createShip(4, new String[]{"A1", "A1"}));
        Assertions.assertFalse(game.getPlayer1().getField().createShip(4, new String[]{"A1", "A-2"}));
        Assertions.assertFalse(game.getPlayer1().getField().createShip(4, new String[]{"A1", "A1"}));
        Assertions.assertFalse(game.getPlayer1().getField().createShip(4, new String[]{"A1", "B4"}));
        Assertions.assertFalse(game.getPlayer1().getField().createShip(4, new String[]{"A1", "A3"}));
        Assertions.assertFalse(game.getPlayer1().getField().createShip(4, new String[]{"A1", "A4", "A1"}));
        Assertions.assertFalse(game.getPlayer1().getField().createShip(4, new String[]{"A1", "AA4"}));
        Assertions.assertFalse(game.getPlayer1().getField().createShip(4, new String[]{"A1", null}));
        Assertions.assertFalse(game.getPlayer1().getField().createShip(4, new String[]{null, "A4"}));
        Assertions.assertFalse(game.getPlayer1().getField().createShip(1, new String[]{null}));
        Assertions.assertFalse(game.getPlayer1().getField().createShip(4, new String[]{"A10", "A13"}));
        Assertions.assertFalse(game.getPlayer1().getField().createShip(4, new String[]{"K1", "K4"}));
        Assertions.assertFalse(game.getPlayer1().getField().createShip(1, new String[]{"J10 J"}));
        Assertions.assertFalse(game.getPlayer1().getField().createShip(1, new String[]{"J11"}));
    }

    @Test
    void shipTouchingCreationTest() {
        SeaBattle game = new SeaBattle("Player1", "Player2");
        Assertions.assertTrue(game.getPlayer1().getField().createShip(4, new String[]{"A1", "A4"}));
        Assertions.assertFalse(game.getPlayer1().getField().createShip(4, new String[]{"A1", "D1"}));
        Assertions.assertFalse(game.getPlayer1().getField().createShip(1, new String[]{"A2"}));
        Assertions.assertFalse(game.getPlayer1().getField().createShip(1, new String[]{"B2"}));
    }

    @Test
    void shipIsInAStraightLineTest() {
        SeaBattle game = new SeaBattle("Player1", "Player2");
        Assertions.assertTrue(Ship.shipIsInAStraightLine(4, new int[]{2, 3}, new int[]{5, 3}));
        Assertions.assertFalse(Ship.shipIsInAStraightLine(4, new int[]{2, 3}, new int[]{5, 2}));
    }

    @Test
    void rightShipLengthTest() {
        SeaBattle game = new SeaBattle("Player1", "Player2");
        Assertions.assertTrue(Ship.rightShipLength(4, new int[]{2, 3}, new int[]{5, 3}));
        Assertions.assertFalse(Ship.rightShipLength(4, new int[]{2, 3}, new int[]{4, 3}));
        Assertions.assertTrue(Ship.rightShipLength(1, new int[]{2, 3}, new int[]{2, 3}));
        Assertions.assertFalse(Ship.rightShipLength(1, new int[]{2, 3}, new int[]{1, 3}));
    }

    @Test
    void cellBelongsToShipTest() {
        SeaBattle game = new SeaBattle("Player1", "Player2");
        Ship ship = new Ship(4, new int[][] {{1, 2}, {1, 3}, {1, 4}, {1, 5}});
        Assertions.assertTrue(ship.cellBelongsToShip(new int[]{1, 3}));
        Assertions.assertFalse(ship.cellBelongsToShip(new int[]{2, 3}));
    }

    @Test
    void allShipsSunkTest() {
        SeaBattle game = new SeaBattle("Player1", "Player2");
        Field field = game.getPlayer1().getField();
        field.createShip(4, new String[]{"A1", "A4"});
        field.createShip(1, new String[]{"J8"});

        Assertions.assertFalse(game.getPlayer1().allShipsSunk());
        for (Ship ship : game.getPlayer1().getField().getListOfShips()) {
            ship.setShipStatus(Ship.status.SUNK);
        }
        Assertions.assertTrue(game.getPlayer1().allShipsSunk());
    }

    @Test
    void shotResultTest() {
        SeaBattle game = new SeaBattle("Player1", "Player2");
        Field field = game.getPlayer1().getField();
        field.createShip(3, new String[]{"A1", "A3"});
        field.createShip(1, new String[]{"J8"});

        Assertions.assertEquals("miss", field.shotResult(new int[]{9, 7}));
        Assertions.assertEquals("repeat", field.shotResult(new int[]{9, 7}));
        Assertions.assertEquals("hit", field.shotResult(new int[]{0, 0}));
        Assertions.assertEquals("hit", field.shotResult(new int[]{1, 0}));
        Assertions.assertEquals("sunk", field.shotResult(new int[]{2, 0}));
        Assertions.assertEquals("repeat", field.shotResult(new int[]{2, 0}));
        Assertions.assertEquals("sunk", field.shotResult(new int[]{7, 9}));
    }

    /*


    */

    @Test
    void setShipHitAndSunkTest() {
        Ship ship = new Ship(2, new int[][] {{1, 2, 0}, {1, 3, 0}});
        assertSame(ship.getShipStatus(), Ship.status.INTACT);
        ship.setCellHit(new int[]{1, 2});
        ship.setCellHit(new int[]{1, 3});
        assertSame(ship.getShipStatus(), Ship.status.SUNK);
    }

}