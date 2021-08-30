package homework_5.power_of_number;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PowerOfNumberTest extends UnitBase {

    @Test
    void validInputTest() {
        final String input_value = "2 2";
        setInput(input_value);

        String result = new PowerOfNumber().run();

        removeFromOutput("Введите данные:");
        assertEquals("4", result);
        assertEquals("4", getOutputLines()[0]);
    }

    @Test
    void validInputTest2() {
        final String input_value = "0 0";
        setInput(input_value);

        String result = new PowerOfNumber().run();

        removeFromOutput("Введите данные:");
        assertEquals("1", result);
        assertEquals("1", getOutputLines()[0]);
    }

    @Test
    void EmptyInputTest() {
        final String input_value = "";
        setInput(input_value);

        String result = new PowerOfNumber().run();

        removeFromOutput("Введите данные:");
        assertEquals("Only 2 non-negative integers are allowed", result);
    }

    @Test
    void notValidInputTest() {
        final String input_value = "@test_host.com";
        setInput(input_value);

        String result = new PowerOfNumber().run();

        removeFromOutput("Введите данные:");
        assertEquals("Only 2 non-negative integers are allowed", result);
        assertEquals("Only 2 non-negative integers are allowed", getOutputLines()[0]);
    }

    @Test
    void notValidInputTest2() {
        final String input_value = "-2 0";
        setInput(input_value);

        String result = new PowerOfNumber().run();

        removeFromOutput("Введите данные:");
        assertEquals("Only 2 non-negative integers are allowed", result);
        assertEquals("Only 2 non-negative integers are allowed", getOutputLines()[0]);
    }
}