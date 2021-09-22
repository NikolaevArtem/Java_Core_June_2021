package course_project.sea_battle.controller.impl;

import course_project.sea_battle.controller.FireController;
import course_project.sea_battle.model.CellStatus;
import course_project.sea_battle.model.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FireControllerImplTest {
    Field radar;
    Field def;
    FireController fireController = FireControllerImpl.getInstance();

    @BeforeEach
    void setField() {
        radar = FieldControllerImpl.getInstance().instance();
        def = FieldControllerImpl.getInstance().instance();
        def.setCell(0, 0, CellStatus.SHIP);
        def.setCell(1, 0, CellStatus.HIT);
        def.setCell(2, 0, CellStatus.SHOT);
        def.setCell(3, 0, CellStatus.WATER);
    }

    @Test
    void fireShipTest() {
        assertEquals(CellStatus.WATER, radar.getCell(0,0));
        assertEquals(CellStatus.SHIP, def.getCell(0,0));
        CellStatus cell1 = fireController.fire(def, radar, "a1");
        assertEquals(CellStatus.HIT, radar.getCell(0,0));
        assertEquals(CellStatus.HIT, def.getCell(0,0));
    }

    @Test
    void fireHitTest() {
        assertEquals(CellStatus.WATER, radar.getCell(1,0));
        assertEquals(CellStatus.HIT, def.getCell(1,0));
        CellStatus cell1 = fireController.fire(def, radar, "b1");
        assertEquals(CellStatus.HIT, radar.getCell(1,0));
        assertEquals(CellStatus.HIT, def.getCell(1,0));
    }

    @Test
    void fireShotTest() {
        assertEquals(CellStatus.WATER, radar.getCell(2,0));
        assertEquals(CellStatus.SHOT, def.getCell(2,0));
        CellStatus cell1 = fireController.fire(def, radar, "c1");
        assertEquals(CellStatus.SHOT, radar.getCell(2,0));
        assertEquals(CellStatus.SHOT, def.getCell(2,0));
    }

    @Test
    void fireWaterTest() {
        assertEquals(CellStatus.WATER, radar.getCell(3,0));
        assertEquals(CellStatus.WATER, def.getCell(3,0));
        CellStatus cell1 = fireController.fire(def, radar, "d1");
        assertEquals(CellStatus.SHOT, radar.getCell(3,0));
        assertEquals(CellStatus.SHOT, def.getCell(3,0));
    }

    @Test
    void checkFireValidDataTest() {
        //проверет на корректные данные координат
        boolean res = fireController.checkFire(def, "a2");
        boolean res2 = fireController.checkFire(def, "a3");
        boolean res3 = fireController.checkFire(def, "a4");

        boolean res4 = fireController.checkFire(def, "a1");
        boolean res5 = fireController.checkFire(def, "b1");
        boolean res6 = fireController.checkFire(def, "c1");
        boolean res7 = fireController.checkFire(def, "d1");

        assertTrue(res);
        assertTrue(res2);
        assertTrue(res3);

        assertTrue(res4);
        assertTrue(res7);

        // стрелять 2 раза в 1 место нельзя, по этому тут ожидаем обратного
        assertFalse(res5);
        assertFalse(res6);
    }

    @Test
    void checkFireInValidDataTest() {
        //проверет на корректные данные координат
        boolean res = fireController.checkFire(def, "adsf");
        boolean res2 = fireController.checkFire(def, "adsf");
        boolean res3 = fireController.checkFire(def, "asdf");

        boolean res4 = fireController.checkFire(def, "adf");
        boolean res5 = fireController.checkFire(def, "zcv");
        boolean res6 = fireController.checkFire(def, "asfd");
        boolean res7 = fireController.checkFire(null, "fgj");

        assertFalse(res);
        assertFalse(res2);
        assertFalse(res3);
        assertFalse(res4);
        assertFalse(res5);
        assertFalse(res6);
        assertFalse(res7);

    }
}