package homework_5.power_of_number;

import base.UnitBase;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PowerOfNumberTest extends UnitBase {

    private static final String ERROR_MESSAGE = "any problem with input (negative, less/more arguments, string) output: Only 2 non-negative integers are allowed";

    @ParameterizedTest
    @MethodSource("notNumberCase")
    public void paramsNotNumberTest(String firstParam, String secondParam) {
        setInput(firstParam + " " + secondParam);
        printOut();
        new PowerOfNumber().run();
        Assertions.assertEquals(ERROR_MESSAGE, getOutputLines()[0]);
    }

    public static Stream<Arguments> notNumberCase() {
        return Stream.of(
                Arguments.of("string", "1"),
                Arguments.of("1", "string"),
                Arguments.of("string", "string")
        );
    }

    @ParameterizedTest
    @MethodSource("nullParamsCase")
    public void paramsNullTest(String firstParam, String secondParam) {
        setInput(firstParam + " " + secondParam);
        printOut();
        new PowerOfNumber().run();
        Assertions.assertEquals(ERROR_MESSAGE, getOutputLines()[0]);
    }

    public static Stream<Arguments> nullParamsCase() {
        return Stream.of(
                Arguments.of("1", null),
                Arguments.of(null, "string"),
                Arguments.of(null, null)
        );
    }

    @ParameterizedTest
    @MethodSource("correctValueCase")
    public void correctValueTest(String firstParam, String secondParam, String expected) {
        setInput(firstParam + " " + secondParam);
        printOut();
        new PowerOfNumber().run();
        Assertions.assertEquals(expected, getOutputLines()[0]);
    }

    public static Stream<Arguments> correctValueCase() {
        return Stream.of(
                Arguments.of("1", "2", "1"),
                Arguments.of("2", "2", "4"),
                Arguments.of("5", "5", "3125")
        );
    }
}
