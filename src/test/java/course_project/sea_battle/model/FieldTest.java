package course_project.sea_battle.model;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest extends UnitBase {

    Field field = new Field(10, 10);
    @Test
    void addShip() {

        assertEquals("correct", field.addShip(new Ship(true, 1,1, 1)));
        assertEquals("fieldNotEmpty", field.addShip(new Ship(true, 1,1, 1 )));

        assertEquals("correct", field.addShip(new Ship(true, 4,4, 4 )));
        assertEquals("sizeShipBad", field.addShip(new Ship(true, 4,2, 4 )));

        assertEquals("correct", field.addShip(new Ship(false, 9,9, 1 )));
        assertEquals("fieldNotEmpty", field.addShip(new Ship(false, 9,9, 1 )));

        assertEquals("correct", field.addShip(new Ship(false, 7,7, 2 )));
        assertEquals("fieldNotEmpty", field.addShip(new Ship(false, 7,5, 2)));
    }

    @Test
    void shot() {
    }

    @Test
    void autoGenerateShips() {
    }

    @Test
    void canAddThisSize() {
    }

    @Test
    void autoShot() {
    }
}