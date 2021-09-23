package homework_4;

import homework_4.singleton.Singleton;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingletonTest {

    @Test
    void singletonFeaturesTest() {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        assertEquals("created", singleton1.getState());
        assertEquals("created", singleton2.getState());

        singleton1.setState("changed");

        assertEquals("changed", singleton1.getState());
        assertEquals("changed", singleton2.getState());

        assertEquals(singleton2, singleton1);
    }

}
