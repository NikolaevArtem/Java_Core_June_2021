package course_project.sea_battle.model;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShipsGameTest extends UnitBase {
    ShipsGame shipsGame = new ShipsGame();
    @Test
    void getAllShips() {
        List<Ships> list = shipsGame.getAllShips();
        assertEquals(0, list.size());
    }

    @Test
    void ready() {
        assertFalse(shipsGame.ready());
    }

    @Test
    void addShip() {
        shipsGame.addShip(new Ship(true, 1 , 1 ,1));
        assertEquals(1, shipsGame.getAllShips().size());
    }

    @Test
    void shipsDead() {
        assertFalse(shipsGame.shipsDead());
    }

    @Test
    void canAddThisSize() {
        assertTrue(shipsGame.canAddThisSize(4));
        shipsGame.addShip(new Ship(true, 3 , 3 ,4));
        assertFalse(shipsGame.canAddThisSize(4));
    }
}