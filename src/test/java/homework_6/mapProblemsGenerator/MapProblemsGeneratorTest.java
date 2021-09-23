package homework_6.mapProblemsGenerator;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapProblemsGeneratorTest extends UnitBase {

    @Test
    void testCatClass() {
        MapProblemsCollisionGenerator generator1 = new MapProblemsCollisionGenerator(3);
        MapProblemsCollisionGenerator generator2 = new MapProblemsCollisionGenerator(4);
        assertEquals(generator1.hashCode(), generator2.hashCode());
        assertNotEquals(generator1, generator2);
    }

    @Test
    void testDatClass() {
        MapProblemsMutableGenerator generator1 = new MapProblemsMutableGenerator(3);
        MapProblemsMutableGenerator generator2 = new MapProblemsMutableGenerator(3);
        MapProblemsMutableGenerator generator3 = new MapProblemsMutableGenerator(4);
        assertEquals(generator1, generator2);
        assertNotEquals(generator1, generator3);

        Map<MapProblemsMutableGenerator, String> map = new HashMap<>();
        map.put(generator1, "someString");
        generator1.setSomeField(4);
        assertFalse(map.containsKey(generator1));
    }

}