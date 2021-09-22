package course_project_test;

import base.UnitBase;
import course_project.Game;
import course_project.GameField;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseProjectTest extends UnitBase {

    @Test
    void givenCorrectInput_whenCheckingIncorrectInput_thenTrue() {
        assertTrue(Game.checkingCorrectInput("A10"));
        assertTrue(Game.checkingCorrectInput("B1"));
        assertTrue(Game.checkingCorrectInput("I7"));
        assertTrue(Game.checkingCorrectInput("C8"));
        assertTrue(Game.checkingCorrectInput("J10"));
    }

    @Test
    void givenIncorrectInput_whenCheckingIncorrectInput_thenFalse() {
        assertFalse(Game.checkingCorrectInput("A11"));
        assertFalse(Game.checkingCorrectInput("A 1"));
        assertFalse(Game.checkingCorrectInput("A90"));
        assertFalse(Game.checkingCorrectInput(" "));
        assertFalse(Game.checkingCorrectInput(""));
        assertFalse(Game.checkingCorrectInput("J"));
        assertFalse(Game.checkingCorrectInput("a1"));
        assertFalse(Game.checkingCorrectInput("two"));
        assertFalse(Game.checkingCorrectInput("B100"));
    }

    @Test
    void givenFieldWithShips_whenCheckSpaceAround() {
        GameField field = new GameField(false);
        field.setStatusShipInCell(4, true, new int[]{6,9});
        field.setStatusShipInCell(3, true, new int[]{4,1});
        field.setStatusShipInCell(3, false, new int[]{7,5});
        field.setStatusShipInCell(2, false, new int[]{9,1});
        field.setStatusShipInCell(2, false, new int[]{9,6});
        field.setStatusShipInCell(2, true, new int[]{3,8});
        field.setStatusShipInCell(1, true, new int[]{7,3});
        field.setStatusShipInCell(1, true, new int[]{3,6});
        field.setStatusShipInCell(1, true, new int[]{1,4});
        field.setStatusShipInCell(1, true, new int[]{1,9});

        assertFalse(field.checkSpaceAround(2, 5, 3, false));
        assertFalse(field.checkSpaceAround(4, 4, 3, false));
        assertFalse(field.checkSpaceAround(4, 9, 3, true));
        assertFalse(field.checkSpaceAround(10, 5, 1, true));
        assertTrue(field.checkSpaceAround(2, 1, 2, false));
        assertTrue(field.checkSpaceAround(5, 3, 3, false));
        assertTrue(field.checkSpaceAround(10, 4, 1, true));
        assertTrue(field.checkSpaceAround(3, 3, 3, true));
    }

    @Test
    void testConstructorGameField() {
        GameField field = new GameField(true);
        int countShipCells = countingShipCells(field);

        assertEquals(20, countShipCells);
    }

    @Test
    void testCreateShip() {
        GameField field = new GameField(false);
        field.createShip(4);
        assertEquals(4, countingShipCells(field));

        field = new GameField(false);
        field.createShip(3);
        assertEquals(3, countingShipCells(field));

        field = new GameField(false);
        field.createShip(2);
        assertEquals(2, countingShipCells(field));

        field = new GameField(false);
        field.createShip(1);
        assertEquals(1, countingShipCells(field));
    }

    private int countingShipCells(GameField field) {
        int countShipCells = 0;

        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                if (field.cells[i][j] == GameField.CellStatus.SHIP) {
                    countShipCells++;
                }
            }
        }

        return countShipCells;
    }
}
