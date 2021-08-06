package homework_4.Singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonTest {

    @Test
    void giveInvoke_whenRun_thenOnlyOneInstance() {
        Singleton first = Singleton.getInstance("First");
        Singleton second = Singleton.getInstance("Second");

        assertEquals(first.name, second.name);
    }

}