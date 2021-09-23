package course_project.sea_battle.service;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class СomputeHelperTest extends UnitBase {

    @Test
    void chekCanPutShip() {
        int[][] field = new int[10][10];
        assertTrue(ComputeHelper.chekCanPutShip(0,0, field));
        assertTrue(ComputeHelper.chekCanPutShip(1,0, field));
        assertTrue(ComputeHelper.chekCanPutShip(0,1, field));
        assertTrue(ComputeHelper.chekCanPutShip(3,0, field));
        field[1][1] = 5;
        assertFalse(ComputeHelper.chekCanPutShip(1,0, field));
        assertFalse(ComputeHelper.chekCanPutShip(1,1, field));
        assertFalse(ComputeHelper.chekCanPutShip(0,1, field));
        assertFalse(ComputeHelper.chekCanPutShip(1,2, field));

        assertTrue(ComputeHelper.chekCanPutShip(5,5, field));
        assertTrue(ComputeHelper.chekCanPutShip(4,6, field));
        assertTrue(ComputeHelper.chekCanPutShip(8,7, field));
        assertTrue(ComputeHelper.chekCanPutShip(7,4, field));
        field[5][6] = 5;
        assertFalse(ComputeHelper.chekCanPutShip(5,5, field));
        assertFalse(ComputeHelper.chekCanPutShip(6,6, field));
        assertFalse(ComputeHelper.chekCanPutShip(6,7, field));
        assertFalse(ComputeHelper.chekCanPutShip(6,5, field));
    }
}