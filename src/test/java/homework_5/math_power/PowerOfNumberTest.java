package homework_5.math_power;

import base.UnitBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static homework_5.math_power.utils.PowerOfNumberConstants.ERROR_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerOfNumberTest extends UnitBase {
    private final PowerOfNumber powerOfNumber = new PowerOfNumber();

    @ParameterizedTest
    @MethodSource("testCasesGetErrorMessage")
    void testGetErrorMessage(final String[] input, final String expected) {
        powerOfNumber.run(input);
        assertEquals(expected, getOutput());
    }

    @ParameterizedTest
    @MethodSource("testCasesGetSuccessResult")
    void testGetSuccessResult(final String[] input, final String expected) {
        powerOfNumber.run(input);
        assertEquals(expected, getOutput());
    }

    static Stream<Arguments> testCasesGetErrorMessage() {
        return Stream.of(
                Arguments.of(new String[]{"2", "1", "4"}, ERROR_MESSAGE),
                Arguments.of(new String[]{"2", "s"}, ERROR_MESSAGE),
                Arguments.of(new String[]{"-2", "5"}, ERROR_MESSAGE),
                Arguments.of(new String[]{"2.5", "5"}, ERROR_MESSAGE)
        );
    }

    static Stream<Arguments> testCasesGetSuccessResult() {
        return Stream.of(
                Arguments.of(new String[]{"2", "2"}, "4"),
                Arguments.of(new String[]{"2", "1"}, "2"),
                Arguments.of(new String[]{"2", "0"}, "1"),
                Arguments.of(new String[]{"0", "2"}, "0"),
                Arguments.of(new String[]{"10", "18"}, String.valueOf((long) Math.pow(10, 18))),
                Arguments.of(new String[]{"5", "0"}, String.valueOf((long) Math.pow(5, 0)))
        );
    }

}
