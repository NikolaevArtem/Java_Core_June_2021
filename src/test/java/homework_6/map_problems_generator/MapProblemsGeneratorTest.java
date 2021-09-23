package homework_6.map_problems_generator;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static homework_6.map_problems_generator.MapProblemsGenerator.MapProblemsMutableGenerator;
import static org.junit.jupiter.api.Assertions.*;

class MapProblemsGeneratorTest {

    @Test
    void testMapProblemsMutableGenerator() {
        MapProblemsMutableGenerator element =
                new MapProblemsMutableGenerator(27, "Element 1");
        MapProblemsMutableGenerator sameElement =
                new MapProblemsMutableGenerator(27, "Element 1");
        assertEquals(element, sameElement);

        HashMap<MapProblemsMutableGenerator, String> map = new HashMap<>();
        map.put(element, element.getName());
        assertNotNull(map.get(element));

        element.setId(30);
        assertNull(map.get(element));
    }
}