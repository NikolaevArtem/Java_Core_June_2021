package course_project.sea_battle.model;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest extends UnitBase {

    @Test
    void shot() {
        Ship ship = new Ship(true, 2, 2, 3);
        assertTrue(ship.shot(2, 2));
        assertTrue(ship.shot(3, 2));
        assertTrue(ship.shot(4, 2));
        assertFalse(ship.shot(4, 3));
        assertFalse(ship.shot(2, 3));
        assertFalse(ship.shot(1, 1));
        assertFalse(ship.shot(11, 11));
    }
}