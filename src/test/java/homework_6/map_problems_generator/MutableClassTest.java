package homework_6.map_problems_generator;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MutableClassTest extends UnitBase {

    @Test
    void testMutable() {
        HashMap<MutableClass, Integer> hMap = new HashMap<>();
        MutableClass mutableClass = new MutableClass(33);
        hMap.put(mutableClass, 1);
        assertNull(hMap.get(mutableClass));

    }

}