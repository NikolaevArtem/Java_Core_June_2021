package homework_4.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonTest {

    @Test
    void assertSingletons() {
        Singleton expected = Singleton.getInstance();
        Singleton actual = Singleton.getInstance();
        assertSame(expected, actual);
    }
}