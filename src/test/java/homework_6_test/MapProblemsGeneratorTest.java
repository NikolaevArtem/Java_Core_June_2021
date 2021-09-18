package homework_6_test;

import homework_6.MapProblemsGenerator.MapCollisionKey;
import homework_6.MapProblemsGenerator.MutableKey;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MapProblemsGeneratorTest {

    @Test
    void givenMapCollisionKey_whenPutInHashMap_thenCollision() {
        HashMap<MapCollisionKey, Integer> hMap = new HashMap<>();
        MapCollisionKey key1 = new MapCollisionKey("Seeta");
        MapCollisionKey key2 = new MapCollisionKey("Geeta");

        hMap.put(key1, 1);
        hMap.put(key2, 2);
        assertEquals(1, key2.getEqualsCalls());

        assertEquals(1, hMap.get(key1));
        assertEquals(2, hMap.get(key2));
        assertEquals(2, key2.getEqualsCalls());
    }

    @Test
    void givenMutableKey_whenMutateAfterPut_thenHashMapReturnsNull() {
        HashMap<MutableKey, Integer> hMap = new HashMap<>();
        MutableKey mKey = new MutableKey("Hello");

        MutableKey anotherKey = new MutableKey("Hello");
        assertEquals(mKey, anotherKey);

        hMap.put(mKey, 1);
        assertEquals(1, hMap.get(mKey));

        StringBuilder sb = mKey.getName();
        sb.append(" my friend");

        assertNull(hMap.get(mKey));
    }
}
