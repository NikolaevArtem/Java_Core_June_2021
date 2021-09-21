package course_project.sea_battle.controller.impl;

import course_project.sea_battle.controller.FieldFillController;
import course_project.sea_battle.controller.ShipController;
import course_project.sea_battle.model.CellStatus;
import course_project.sea_battle.model.Field;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class RandomFieldFillControllerTest {

    FieldFillController randomFieldFillController;
    FieldControllerImpl fieldController = FieldControllerImpl.getInstance();
    ShipController shipController = ShipControllerImpl.getInstance();

    @AfterEach
    void after() {
        randomFieldFillController = null;
    }
    @Test
    void setShips() {
        randomFieldFillController = RandomFieldFillController.getInstance()
                .setGameSetupHolder(()-> {
                    TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
                    map.put(5, 1);
                    return map;
                });

        Field instance = fieldController.instance();
        assertFalse(shipController.isAnyShipAlive(instance));
        randomFieldFillController.setShips(instance);
        assertTrue(shipController.isAnyShipAlive(instance));
        long count = Arrays.stream(instance.getCells())
                .flatMap(Arrays::stream)
                .filter(x -> x.equals(CellStatus.SHIP))
                .count();
        assertEquals(5, count);
    }
}