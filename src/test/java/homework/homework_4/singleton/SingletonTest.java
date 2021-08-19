package homework.homework_4.singleton;

import homework_4.singleton.Singleton;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SingletonTest {

    @Test
    public void compareInstances() {

    Singleton singleton1 = Singleton.getInstance();
    Singleton singleton2 = Singleton.getInstance();

    assertSame(singleton1, singleton2);
}
    @Test
    public void compareWithNull(){

        Singleton singleton1 = null;
        Singleton singleton2 = Singleton.getInstance();

        assertNotSame(singleton1, singleton2);
    }


}
