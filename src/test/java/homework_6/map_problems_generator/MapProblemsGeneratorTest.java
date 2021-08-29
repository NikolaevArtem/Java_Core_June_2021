package homework_6.map_problems_generator;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapProblemsGeneratorTest {

    Map<Getable, String> map = new HashMap<>();
    MapProblemsGenerator mapProblemsGenerator = new MapProblemsGenerator();

    @SuppressWarnings("java:S5785")
    @Test
    void testOneHundredPercentCollisionsInHashMap() {
        GenerateCollisions gc1 = mapProblemsGenerator.getGenerateCollisions("Hello");
        GenerateCollisions gc2 = mapProblemsGenerator.getGenerateCollisions("Goodbye");
        map.put(gc1, gc1.getVal());
        map.put(gc2, gc2.getVal());
        assertEquals(gc1.hashCode(), gc2.hashCode());
        assertFalse(gc1.equals(gc2));
        map.clear();
    }

    @Test
    void testMutableClass() {
        MutableClass mutableClass = mapProblemsGenerator.getMutableClass("default");
        map.put(mutableClass, mutableClass.getVal());
        assertNull(map.get(mutableClass));
        map.clear();
    }

    @SuppressWarnings("java:S5785")
    @Test
    void testMutableClassEqualsMethodWorksCorrectly() {
        MutableClass mc1 = mapProblemsGenerator.getMutableClass("theonlyone");
        MutableClass mc2 = mapProblemsGenerator.getMutableClass("theonlyone");
        assertTrue(mc1.equals(mc2));
        MutableClass mcDifferent = mapProblemsGenerator.getMutableClass("anotherone");
        assertFalse(mc1.equals(mcDifferent));
    }


}
