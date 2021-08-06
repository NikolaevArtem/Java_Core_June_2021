package homework_4.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonMenuTest {

    @Test
    void testInstances() {
        SingletonMenu expected = SingletonMenu.getInstance();
        SingletonMenu current = SingletonMenu.getInstance();
        assertSame(expected, current);
    }

}