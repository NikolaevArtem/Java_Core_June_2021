package homework_4;

import homework_4.Singleton.MySingleton;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class SingletonTest {
    @Test
    public void testSingleton() {
        MySingleton expected = MySingleton.getInstance();
        MySingleton actual = MySingleton.getInstance();
        assertSame(expected, actual);
    }
}
