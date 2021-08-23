package homework_5.power_of_number;

import base.UnitBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerOfNumberTest extends UnitBase {

    @ParameterizedTest
    @MethodSource("testsCases")
    void givenNumbers_whenRun_thenCalculateResult(String input, String expected) {
        setInput(input);
        new PowerOfNumber().run();
        getOutput();
        assertEquals(expected, getOutputLines()[1]);
    }

    static Stream<Arguments> testsCases() {
        return Stream.of(
                Arguments.of("1 1", "1"),
                Arguments.of("1 100", "1"),
                Arguments.of("2 2", "4"),
                Arguments.of("3 3", "27"),
                Arguments.of("2 7", "128"),
                Arguments.of("11 2", "121"),
                Arguments.of("55 3", "166375"),
                Arguments.of("100 0", "1"),
                Arguments.of("0 100", "0"),
                Arguments.of("  4    4", "256")
        );
    }

    @ParameterizedTest
    @MethodSource("testsCases2")
    void givenWrongInput_whenRun_thenPrintError(String input) {
        setInput(input);
        new PowerOfNumber().run();
        getOutput();
        assertEquals("Only 2 non-negative integers are allowed", getOutputLines()[1]);
    }

    static Stream<Arguments> testsCases2() {
        return Stream.of(
                Arguments.of("1 1 1"),
                Arguments.of("-2 2"),
                Arguments.of("10 -22"),
                Arguments.of("asd a"),
                Arguments.of("6"),
                Arguments.of("0b11 0b10"),
                Arguments.of("1.0 2"),
                Arguments.of(" ")
        );
    }
}
