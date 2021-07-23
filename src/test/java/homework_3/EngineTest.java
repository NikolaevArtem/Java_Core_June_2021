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
        assertEquals(model, "Default");
        assertFalse(isOk);
        assertEquals(power, 10);
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
        assertEquals(engine.getModel(), "BMW");
        assertTrue(engine.isOk());
        assertEquals(engine.getPower(), 150);
        assertEquals(engine.getSpec(), spec);
    }

    @Test
    void givennNonFullData_whenNewEngine_thenGetObject() {
        String model = "BMW";
        int power = 150;
        Engine engine = new Engine(model, power);
        assertEquals(engine.getModel(), "BMW");
        assertFalse(engine.isOk());
        assertEquals(engine.getPower(), 150);
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

        assertNotEquals(newEngine, engine);
        assertEquals(newEngine.getModel(), "BMW");
        assertEquals(newEngine.getPower(), 150);
        assertTrue(newEngine.isOk());
        assertEquals(newEngine.getSpec(), engine.getSpec());
    }
}