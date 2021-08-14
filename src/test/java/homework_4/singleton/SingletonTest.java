package homework_4.singleton;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingletonTest extends UnitBase {

    @Test
    void testSingleton() {
        Singleton instance = Singleton.getInstance();
        assertEquals(instance, Singleton.getInstance());
    }
}