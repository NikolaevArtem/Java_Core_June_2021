package homework_4.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Singleton_test {

    @Test
    void testSingleton() {

        assertTrue(Singleton.getInstance() == (Singleton.getInstance ()));
    }
}
