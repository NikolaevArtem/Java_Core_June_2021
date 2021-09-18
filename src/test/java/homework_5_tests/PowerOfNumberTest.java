package homework_5_tests;

import base.UnitBase;
import homework_5.power_of_number.PowerOfNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerOfNumberTest  extends UnitBase {

    private static final String ERROR_MESSAGE = "Only 2 non-negative integers are allowed";

    private void run() {
        new PowerOfNumber().run();
        removeFromOutput("Please enter 2 non-negative numbers:");
        printOut();
    }

    @ParameterizedTest
    @MethodSource("testTrueCases")
    void givenCorrectPassword_whenRun_thenPrintPower(String input, String expected) {
        setInput(input);

        run();

        assertEquals(expected, getOutput());
    }

    private static Stream<Arguments> testTrueCases() {
        return Stream.of(
                Arguments.of("2 2", "4"),
                Arguments.of("0 2", "0"),
                Arguments.of("2 0", "1")
        );
    }

    @ParameterizedTest
    @MethodSource("testBadInputCases")
    void givenIncorrectInput_whenRun_thenErrorMassage(String input, String expected) {
        setInput(input);

        run();

        assertEquals(expected, getOutput());
    }

    private static Stream<Arguments> testBadInputCases() {
        return Stream.of(
                Arguments.of("1", ERROR_MESSAGE),
                Arguments.of("1 2 3", ERROR_MESSAGE),
                Arguments.of("one 3", ERROR_MESSAGE)
        );
    }
}
