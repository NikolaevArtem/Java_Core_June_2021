package homework_4.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SingletonTest {

    @Test
    void testSingleton() {
        assertTrue(Singleton.getInstance() == (Singleton.getInstance ()));
    }
}
