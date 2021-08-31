package homework_5.power_of_number;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PowerOfNumberTest extends UnitBase {

    @Test
    void givenNull_whenRun_thenException() {

        Exception exception = assertThrows(NullPointerException.class, () -> {
            setInput(null);
            new PowerOfNumber().run();
        });

    }

    @Test
    void givenEmpty_whenRun_thenError() {
        setInput("");

        new PowerOfNumber().run();
        printOut();

        assertEquals("Error: args is null", getOutputLines()[0]);
    }


    @Test
    void givenString_whenRun_thenError() {
        setInput("2");

        new PowerOfNumber().run();
        printOut();

        assertEquals("Error: less when 2 args", getOutputLines()[0]);
    }

    @Test
    void given2_2_whenRun_then4() {
        setInput("2 2");

        new PowerOfNumber().run();
        printOut();

        assertEquals("4", getOutputLines()[0]);
    }

    @Test
    void given2_4_whenRun_then16() {
        setInput("2 4");

        new PowerOfNumber().run();
        printOut();

        assertEquals("16", getOutputLines()[0]);
    }
    
}
