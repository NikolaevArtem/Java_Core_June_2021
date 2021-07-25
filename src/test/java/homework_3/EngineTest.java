package homework_3;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EngineTest extends UnitBase {

    @Test
    void givenNoData_whenNewEngine_thenGetObject() {
        Engine engine = new Engine();
        String model = engine.getModel();
        boolean isOk = engine.isOk();
        int power = engine.getPower();
        List<String> spec = engine.getSpec();
        assertEquals( "Default", model);
        assertFalse(isOk);
        assertEquals(10, power);
        assertTrue(spec.isEmpty());
    }

    @Test
    void givenFullData_whenNewEngine_thenGetObject() {
        String model = "BMW";
        boolean isOk = true;
        int power = 150;
        List<String> spec = new ArrayList<>();
        spec.add("air conditioner");
        spec.add("water pump");
        spec.add("exhaust");
        Engine engine = new Engine(model, isOk, power, spec);
        assertEquals("BMW", engine.getModel());
        assertTrue(engine.isOk());
        assertEquals(150, engine.getPower());
        assertEquals(spec, engine.getSpec());
    }

    @Test
    void givenNonFullData_whenNewEngine_thenGetObject() {
        String model = "BMW";
        int power = 150;
        Engine engine = new Engine(model, power);
        assertEquals("BMW", engine.getModel());
        assertFalse(engine.isOk());
        assertEquals(150, engine.getPower());
        assertTrue(engine.getSpec().isEmpty());
    }

    @Test
    void givenData_whenGetNewEngine_thenGetNewObject() {
        String model = "Mercedes";
        boolean isOk = true;
        int power = 79;
        List<String> spec = new ArrayList<>();
        spec.add("air conditioner");
        spec.add("water pump");
        spec.add("exhaust");
        Engine engine = new Engine(model, isOk, power, spec);
        Engine newEngine = engine.getNewEngine("BMW", 150);

        assertNotEquals(engine, newEngine);
        assertEquals("BMW", newEngine.getModel());
        assertEquals(150, newEngine.getPower());
        assertTrue(newEngine.isOk());
        assertEquals(engine.getSpec(), newEngine.getSpec());
    }
}