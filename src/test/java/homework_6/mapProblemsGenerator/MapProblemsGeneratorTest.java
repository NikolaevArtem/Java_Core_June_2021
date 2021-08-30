package homework_6.mapProblemsGenerator;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapProblemsGeneratorTest extends UnitBase {

    @Test
    void testCatClass() {
        Cat cat1 = new Cat(3);
        Cat cat2 = new Cat(4);
        assertEquals(cat1.hashCode(), cat2.hashCode());
        assertNotEquals(cat1, cat2);
    }

    @Test
    void testDatClass() {
        Dog dog1 = new Dog(3);
        Dog dog2 = new Dog(3);
        Dog dog3 = new Dog(4);
        assertEquals(dog1, dog2);
        assertNotEquals(dog1, dog3);

        Map<Dog, String> map = new HashMap<>();
        map.put(dog1, "Gav");
        dog1.setAge(4);
        assertFalse(map.containsKey(dog1));
    }

}