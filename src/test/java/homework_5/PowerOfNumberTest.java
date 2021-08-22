package homework_5;

import homework_5.power_of_number.PowerOfNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PowerOfNumberTest extends base.UnitBase {

    private final String START_MESSAGE = "Please, input number and power.";
    private final String ERROR_MESSAGE = "Only 2 non-negative integers are allowed";

    @Test
    void negativeInputTest() {
        setInput("-2 4");

        new PowerOfNumber().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void moreArgumentsTest() {
        setInput("2 1 8");

        new PowerOfNumber().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void oneArgumentTest() {
        setInput("5");

        new PowerOfNumber().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void noArgumentsTest() {
        setInput("");

        new PowerOfNumber().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @Test
    void stringInputTest() {
        setInput("string input");

        new PowerOfNumber().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(ERROR_MESSAGE, getOutput());
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void calculationTest(String input, String expected) {
        setInput(input);

        new PowerOfNumber().run();
        printOut();
        removeFromOutput(START_MESSAGE);

        assertEquals(expected, getOutput());
    }

    public static Stream<Arguments> testCases() {
        return Stream.of(
                arguments("2 2", "4"),
                arguments("2 1", "2"),
                arguments("4 0", "1"),
                arguments("0 17", "0"),
                arguments("3 5", "243"),
                arguments("2 10", "1024"),
                arguments("10 4", "10000"),
                arguments("7 3", "343")
        );
    }

}
