package homework_4.singleton;

import homework_4.singlenton.Singlenton;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SingletonTest {

    @Test
    void givenNothing_whenRun_thenCreatePlanetWithNameAndAge() {
        Singlenton first = Singlenton.getInstance();
        Singlenton second = Singlenton.getInstance();

        assertEquals(first, second);
    }
}
