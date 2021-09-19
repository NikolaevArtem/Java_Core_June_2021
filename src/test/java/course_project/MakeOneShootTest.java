package course_project;

import course_project.engine.BoardPrinter;
import course_project.engine.ShipPlacer;
import course_project.engine.Shooter;
import course_project.models.Coordinate;
import course_project.models.Player;
import course_project.models.Ship;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MakeOneShootTest {

    Player currentPlayer = new Player();
    Player enemyPlayer = new Player();

    @Test
    public void oneShipPlacedA1Horizontally_ShootAround_thenMiss() {
        Coordinate toPlace = new Coordinate("a1");
        Coordinate toShoot = new Coordinate("a2");
        ShipPlacer.placeShip(enemyPlayer, toPlace, new Ship("Carrier", 4), "h");
        enemyPlayer.setHp(4);

        assertFalse(Shooter.makeOneShoot(currentPlayer, enemyPlayer, toShoot)); // currentPlayer has no additional shoot
        assertEquals("*", enemyPlayer.mainBoard().getCell(toShoot)); //marked as miss

        toShoot = new Coordinate("b2");
        assertFalse(Shooter.makeOneShoot(currentPlayer, enemyPlayer, toShoot)); // currentPlayer has no additional shoot
        assertEquals("*", enemyPlayer.mainBoard().getCell(toShoot)); //marked as miss

        toShoot = new Coordinate("c2");
        assertFalse(Shooter.makeOneShoot(currentPlayer, enemyPlayer, toShoot)); // currentPlayer has no additional shoot
        assertEquals("*", enemyPlayer.mainBoard().getCell(toShoot)); //marked as miss

        toShoot = new Coordinate("d2");
        assertFalse(Shooter.makeOneShoot(currentPlayer, enemyPlayer, toShoot)); // currentPlayer has no additional shoot
        assertEquals("*", enemyPlayer.mainBoard().getCell(toShoot)); //marked as miss

        toShoot = new Coordinate("e1");
        assertFalse(Shooter.makeOneShoot(currentPlayer, enemyPlayer, toShoot)); // currentPlayer has no additional shoot
        assertEquals("*", enemyPlayer.mainBoard().getCell(toShoot)); //marked as miss

        toShoot = new Coordinate("e2");
        assertFalse(Shooter.makeOneShoot(currentPlayer, enemyPlayer, toShoot)); // currentPlayer has no additional shoot
        assertEquals("*", enemyPlayer.mainBoard().getCell(toShoot)); //marked as miss

        assertEquals(4, enemyPlayer.hp());

        BoardPrinter.printMainBoard(enemyPlayer);
    }

    @Test
    public void oneShipPlacedA1Horizontally_ShootAtShip_thenHit() {
        Coordinate toPlace = new Coordinate("a1");
        Coordinate toShoot = new Coordinate("a1");
        ShipPlacer.placeShip(enemyPlayer, toPlace, new Ship("Carrier", 4), "h");
        enemyPlayer.setHp(4);

        assertTrue(Shooter.makeOneShoot(currentPlayer, enemyPlayer, toShoot)); // currentPlayer has additional shoot
        assertEquals("X", enemyPlayer.mainBoard().getCell(toShoot)); //marked as hit

        toShoot = new Coordinate("b1");
        assertTrue(Shooter.makeOneShoot(currentPlayer, enemyPlayer, toShoot)); // currentPlayer has additional shoot
        assertEquals("X", enemyPlayer.mainBoard().getCell(toShoot)); //marked as hit

        toShoot = new Coordinate("c1");
        assertTrue(Shooter.makeOneShoot(currentPlayer, enemyPlayer, toShoot)); // currentPlayer has additional shoot
        assertEquals("X", enemyPlayer.mainBoard().getCell(toShoot)); //marked as hit

        toShoot = new Coordinate("d1");
        assertFalse(Shooter.makeOneShoot(currentPlayer, enemyPlayer, toShoot)); // enemyPlayer has no HP, stop shooting
        assertEquals("X", enemyPlayer.mainBoard().getCell(toShoot)); //marked as hit

        assertEquals(0, enemyPlayer.hp());

        BoardPrinter.printMainBoard(enemyPlayer);
    }

    @Test
    public void twoShipsPlacedA1Horizontally_andE2VerticallyShootAtShipsReverseOrder_thenHit() {
        Coordinate toPlace1 = new Coordinate("a1");
        Coordinate toPlace2 = new Coordinate("e2");

        ShipPlacer.placeShip(enemyPlayer, toPlace1, new Ship("Carrier", 4), "h");
        ShipPlacer.placeShip(enemyPlayer, toPlace2, new Ship("Cruiser", 3), "v");
        enemyPlayer.setHp(7);

        Coordinate toShoot = new Coordinate("e4");
        assertTrue(Shooter.makeOneShoot(currentPlayer, enemyPlayer, toShoot)); // currentPlayer has additional shoot
        assertEquals("X", enemyPlayer.mainBoard().getCell(toShoot)); //marked as hit

        toShoot = new Coordinate("e3");
        assertTrue(Shooter.makeOneShoot(currentPlayer, enemyPlayer, toShoot)); // currentPlayer has additional shoot
        assertEquals("X", enemyPlayer.mainBoard().getCell(toShoot)); //marked as hit

        toShoot = new Coordinate("e2");
        assertTrue(Shooter.makeOneShoot(currentPlayer, enemyPlayer, toShoot)); // currentPlayer has additional shoot
        assertEquals("X", enemyPlayer.mainBoard().getCell(toShoot)); //marked as hit

        toShoot = new Coordinate("d1");
        assertTrue(Shooter.makeOneShoot(currentPlayer, enemyPlayer, toShoot)); // currentPlayer has additional shoot
        assertEquals("X", enemyPlayer.mainBoard().getCell(toShoot)); //marked as hit

        toShoot = new Coordinate("c1");
        assertTrue(Shooter.makeOneShoot(currentPlayer, enemyPlayer, toShoot)); // currentPlayer has additional shoot
        assertEquals("X", enemyPlayer.mainBoard().getCell(toShoot)); //marked as hit

        toShoot = new Coordinate("b1");
        assertTrue(Shooter.makeOneShoot(currentPlayer, enemyPlayer, toShoot)); // currentPlayer has additional shoot
        assertEquals("X", enemyPlayer.mainBoard().getCell(toShoot)); //marked as hit

        toShoot = new Coordinate("a1");
        assertFalse(Shooter.makeOneShoot(currentPlayer, enemyPlayer, toShoot)); // enemyPlayer has no HP, stop shooting
        assertEquals("X", enemyPlayer.mainBoard().getCell(toShoot)); //marked as hit

        assertEquals(0, enemyPlayer.hp());

        BoardPrinter.printMainBoard(enemyPlayer);
    }

}
