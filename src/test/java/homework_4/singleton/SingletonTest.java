package homework_4.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingletonTest {
    @Test
    public void testSingleton() {
        Singleton singleton1 = Singleton.getInstance("I am 1");
        Singleton singleton2 = Singleton.getInstance("I am 2");
        assertEquals(singleton1, singleton2);
    }
}
