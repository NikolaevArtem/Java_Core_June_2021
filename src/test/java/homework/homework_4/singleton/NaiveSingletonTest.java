package homework.homework_4.singleton;

import homework_4.singleton.NaiveSingleton;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NaiveSingletonTest {

    @Test
    public void compareInstancesWithEqualSign(){
        NaiveSingleton singleton1 = NaiveSingleton.getInstance();
        NaiveSingleton singleton2 = NaiveSingleton.getInstance();
        NaiveSingleton singletonX = NaiveSingleton.getInstance();

        assertSame(singleton1, singleton2);
        assertSame(singleton1, singletonX);

    }

    @Test
    public void compareInstancesWithEqualsMethod(){
        NaiveSingleton singleton1 = NaiveSingleton.getInstance();
        NaiveSingleton singleton2 = NaiveSingleton.getInstance();
        NaiveSingleton singletonX = NaiveSingleton.getInstance();

        assertEquals(singleton2, singleton1);
        assertSame(singleton1, singletonX);

    }

}
