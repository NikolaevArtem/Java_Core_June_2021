package homework_5.power_of_number;

import base.UnitBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PowerOfNumberTest extends UnitBase {
    private final String GREETING = "Enter two non-negative integers (the number and the desired power for it), split with blank:";
    private final String ERROR_MSG = "Only 2 non-negative integers are allowed!";
    PowerOfNumber powerOfNumber = new PowerOfNumber();

    @ParameterizedTest
    @MethodSource ("rightCases")
    public void givenRightInt_whenOk_thenCalculatedResults (String input, String expected) {
        setInput(input);
        powerOfNumber.run();
        getOutput();
        removeFromOutput(GREETING);
        Assertions.assertEquals(expected, getOutputLines() [0]);
    }

    static Stream<Arguments> rightCases() {
        return Stream.of(
                Arguments.of("2 2", "4"),
                Arguments.of("3 3", "27"),
                Arguments.of("0 0", "1"),
                Arguments.of("5 0", "1"),
                Arguments.of("0 5", "0"),
                Arguments.of("1 1", "1")
        );
    }

    @ParameterizedTest
    @MethodSource ("wrongCases")
    public void givenWrongInput_whenOk_thenErrorMessage (String input) {
        setInput(input);
        powerOfNumber.run();
        getOutput();
        removeFromOutput(GREETING);
        Assertions.assertEquals(ERROR_MSG, getOutputLines() [0]);
    }

    static Stream<Arguments> wrongCases() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of(" "),
                Arguments.of("2 b"),
                Arguments.of("a 2"),
                Arguments.of("2  2"),
                Arguments.of("3 3 "),
                Arguments.of("-1 0"),
                Arguments.of("5 -0"),
                Arguments.of("3.5 1"),
                Arguments.of("1 1.5")

        );
    }

}
