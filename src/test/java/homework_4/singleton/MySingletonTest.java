package homework_4.singleton;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MySingletonTest {

    @ParameterizedTest
    @ValueSource(strings = {"1st", "2nd", "3rd"})
    void test(String input) {
        MySingleton mySingleton = MySingleton.getInstance("Singleton");

        assertEquals(mySingleton.hashCode(), MySingleton.getInstance(input).hashCode());
    }

}