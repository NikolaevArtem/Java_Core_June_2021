package homework_4.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingletonTest{

    @Test
    void givenName_whenGetInstance_thenGetName() {
        String expected = "expected";
        Singleton singleton = Singleton.getInstance(expected);
        String actual = singleton.getNameOfInstance();
        assertEquals(expected, actual);
    }

    @Test
    void givenTwoNames_whenGetInstances_thenGetOnlyOneName() {
        Singleton instance = Singleton.getInstance("expected");
        Singleton anotherInstance = Singleton.getInstance("whatever");
        String actual = instance.getNameOfInstance();
        String actual2 = anotherInstance.getNameOfInstance();
        assertEquals("expected", actual);
        assertEquals("expected", actual2);
    }

    @Test
    void givenTwoNames_whenGetInstances_thenInstancesAreEqual() {
        Singleton first = Singleton.getInstance("first");
        Singleton second = Singleton.getInstance("second");
        assertEquals(first, second);
    }
}
