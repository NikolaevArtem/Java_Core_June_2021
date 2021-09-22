package homework_5.power_of_number;

import base.UnitBase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PowerOfNumberTest extends UnitBase {

    PowerOfNumber powerOfNumber = new PowerOfNumber();

    private static final String ERROR = "Only 2 non-negative integers are allowed";

    @Test
    void testPowerWithValidInput() {
        String expected = convertDoubleToIntAndReturnAsString(Math.pow(3, 5));
        setInput("3 5");
        powerOfNumber.run();
        printOut();
        removeFromOutput("Please, input the values in format: number power\n");
        assertEquals(expected, getOutputLines()[0]);
    }

    @Test
    void testPowerWithValidInput_ZeroPowerOfZero() {
        String expected = convertDoubleToIntAndReturnAsString(Math.pow(0, 0));
        setInput("0 0");
        powerOfNumber.run();
        printOut();
        removeFromOutput("Please, input the values in format: number power\n");
        assertEquals(expected, getOutputLines()[0]);
    }

    public static Stream<Arguments> incorrectInputs() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("1 2 3 4 str"),
                Arguments.of("1  "),
                Arguments.of("1.93 2.47"),
                Arguments.of("999999999999999999 999999999999999999")
        );
    }

    @ParameterizedTest
    @MethodSource("incorrectInputs")
    void testIncorrectInputs_ErrorExpected(String incorrectInput) {
        setInput(incorrectInput);
        powerOfNumber.run();
        printOut();
        removeFromOutput("Please, input the values in format: number power\n");
        assertEquals(ERROR, getOutputLines()[0]);
    }

    private String convertDoubleToIntAndReturnAsString(double value) {
        return String.valueOf((int) (value));
    }

}
