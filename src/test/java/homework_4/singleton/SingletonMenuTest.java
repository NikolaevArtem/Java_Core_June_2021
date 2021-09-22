package homework_4.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonMenuTest {

    @Test
    void testCreatingInstancesOfSingletonClass() {
        SingletonMenu expected = SingletonMenu.getInstance();
        SingletonMenu current = SingletonMenu.getInstance();
        assertSame(expected, current);
    }

}
