package homework_4.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SingletonTest {

    @Test
    public void givenSingleton_whenCreateTwo_thenSameValues() {
        Singleton singleton = Singleton.getInstance("Dog");
        Singleton anotherSingleton = Singleton.getInstance("Cat");
        assertEquals(singleton.value, anotherSingleton.value);
    }

}
