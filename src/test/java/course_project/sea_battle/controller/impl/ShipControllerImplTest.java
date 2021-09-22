package course_project.sea_battle.controller.impl;

import course_project.sea_battle.controller.FieldController;
import course_project.sea_battle.controller.ShipController;
import course_project.sea_battle.model.CellStatus;
import course_project.sea_battle.model.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ShipControllerImplTest {
    FieldController fieldController = FieldControllerImpl.getInstance();
    ShipController shipController = ShipControllerImpl.getInstance();
    Field field;

    @BeforeEach
    void set() {
        field = fieldController.instance();
        assertTrue(Arrays.stream(field.getCells())
                .flatMap(Arrays::stream)
                .allMatch(x -> x.equals(CellStatus.WATER)));
    }

    @Test
    void placeShip4timeTest() {
        assertTrue(shipController.placeShip(field, "a1","v", 5));
        assertFalse(shipController.placeShip(field, "a1","v", 5));
        assertFalse(shipController.placeShip(field, "a1","v", 5));
        assertFalse(shipController.placeShip(field, "a1","v", 5));
        assertFalse(shipController.placeShip(field, "a1","v", 5));

        assertEquals(5, Arrays.stream(field.getCells())
                .flatMap(Arrays::stream)
                .filter(x -> x.equals(CellStatus.SHIP))
                .count()
        );
    }

    @Test
    void placeShip1timeTest() {
        assertTrue(shipController.placeShip(field, "a1","v", 5));
        assertEquals(5, Arrays.stream(field.getCells())
                .flatMap(Arrays::stream)
                .filter(x -> x.equals(CellStatus.SHIP))
                .count()
        );
    }

    @Test
    void placeShipNotValidCoordinateTest() {
        assertFalse(shipController.placeShip(field, "z1","v", 5));
        assertFalse(shipController.placeShip(field, "a11","v", 5));
        assertFalse(shipController.placeShip(field, "z11","v", 5));
        assertFalse(shipController.placeShip(field, "a1","q", 5));
        assertFalse(shipController.placeShip(field, "a1","w", 5));

        assertEquals(0, Arrays.stream(field.getCells())
                .flatMap(Arrays::stream)
                .filter(x -> x.equals(CellStatus.SHIP))
                .count()
        );
    }

    @Test
    void placeShipByCoordinate4timeTest() {
        assertTrue(shipController.placeShipByCoordinate(field, 0, 0, true, 5));
        assertFalse(shipController.placeShipByCoordinate(field, 0, 0, true, 5));
        assertFalse(shipController.placeShipByCoordinate(field, 0, 1, true, 5));
        assertFalse(shipController.placeShipByCoordinate(field, 0, 4, true, 5));

        assertEquals(field.getCell(0, 0), CellStatus.SHIP);
        assertEquals(field.getCell(0, 1), CellStatus.SHIP);
        assertEquals(field.getCell(0, 2), CellStatus.SHIP);
        assertEquals(field.getCell(0, 3), CellStatus.SHIP);
        assertEquals(field.getCell(0, 4), CellStatus.SHIP);

        assertNotEquals(field.getCell(0, 5), CellStatus.SHIP);
    }

    @Test
    void placeShipByCoordinate1TimeTest() {
        assertTrue(shipController.placeShipByCoordinate(field, 0, 0, true, 3));

        assertEquals(field.getCell(0, 0), CellStatus.SHIP);
        assertEquals(field.getCell(0, 1), CellStatus.SHIP);
        assertEquals(field.getCell(0, 2), CellStatus.SHIP);
        assertNotEquals(field.getCell(0, 3), CellStatus.SHIP);
        assertNotEquals(field.getCell(0, 4), CellStatus.SHIP);
        assertNotEquals(field.getCell(0, 5), CellStatus.SHIP);
    }

    @Test
    void placeShipByNotValidCoordinate() {
        assertFalse(shipController.placeShipByCoordinate(field, 10, 0, true, 3));

        field = fieldController.instance();
        assertTrue(Arrays.stream(field.getCells())
                .flatMap(Arrays::stream)
                .allMatch(x -> x.equals(CellStatus.WATER)));
    }

    @Test
    void isAnyShipAlive() {
        assertFalse(shipController.isAnyShipAlive(field));
        field.setCell(0,0, CellStatus.SHIP);
        assertFalse(shipController.isAnyShipAlive(field));
        field.setCell(0,0, CellStatus.WATER);
        assertFalse(shipController.isAnyShipAlive(field));
        field.setCell(0,0, CellStatus.SHOT);
        assertFalse(shipController.isAnyShipAlive(field));

        assertTrue(shipController.isAnyShipAlive(field));
        field.setCell(0,0, CellStatus.HIT);
    }
}