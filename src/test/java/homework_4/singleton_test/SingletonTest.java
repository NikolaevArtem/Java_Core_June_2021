package homework_4.singleton_test;

import homework_4.singleton.Singleton;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class SingletonTest {

    @Test
    void givenNothing_whenCreateTwoInstancesOfSingleton_thenTheyAreOneInstance() {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        assertSame(singleton1, singleton2);
    }
}
