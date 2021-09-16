package course_project.sea_battle.model;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelPlayerTest extends UnitBase {

    public static ModelPlayer dima = new ModelPlayer("Dima", new Field(10,10));

    @Test
    void getName() {
       assertEquals("Dima", dima.getName());
    }

    @Test
    void getPlayerField() {
        assertEquals(10, dima.getPlayerField().getSize());
    }
}