package homework.homework_4.singleton;

import homework_4.singleton.EnumSingleton;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnumSingletonTest {

    @Test
    public void compareInstances(){

        EnumSingleton singleton1 = EnumSingleton.getInstance();
        EnumSingleton singleton2 = EnumSingleton.getInstance();

        assertSame(singleton1, singleton2);
    }

}
