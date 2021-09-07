package homework_5.power_of_number;

import base.UnitBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerOfNumberTest extends UnitBase {

    @Test
    void givenValidInput_whenRun_thenResultPrinted() {
        setInput("2 2");

        new PowerOfNumber().run();
        printOut();

        Assertions.assertEquals("4", getOutput());
    }

    @Test
    void givenNegativeNumbers_whenRun_thenError() {
        setInput("-1 -1");

        new PowerOfNumber().run();
        printOut();

        Assertions.assertEquals("Only 2 non-negative integers are allowed", getOutput());
    }

    @Test
    void givenNotFullInput_whenRun_thenError(){
        setInput("1 ");

        new PowerOfNumber().run();
        printOut();

        Assertions.assertEquals("Only 2 non-negative integers are allowed", getOutput());
    }

    @Test
    void givenString_whenRun_thenError(){
        setInput("t t");

        new PowerOfNumber().run();
        printOut();

        Assertions.assertEquals("Only 2 non-negative integers are allowed", getOutput());
    }

    @Test
    void givenMoreParameters_whenRun_thenError(){
        setInput("1 2 3");

        new PowerOfNumber().run();
        printOut();

        Assertions.assertEquals("Only 2 non-negative integers are allowed", getOutput());
    }
}