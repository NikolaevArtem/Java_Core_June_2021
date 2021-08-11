package homework_4.singleton;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonTest extends UnitBase {

    @Test
    void givenSingleton_whenRun_thenSimpleClassNameReturned() {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.getClass().getSimpleName());

        assertEquals("Singleton created", getOutputLines()[0]);
        assertEquals("Singleton", getOutputLines()[1]);
    }
}