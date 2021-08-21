package homework_4.singleton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SingletonTest{

    @Test
    public void checkSingleton() {
        Singleton singleton = Singleton.getInstance();
        Singleton anotherSingleton = Singleton.getInstance();
        assertEquals(singleton,anotherSingleton);
    }
}
