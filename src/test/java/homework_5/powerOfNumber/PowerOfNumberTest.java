package homework_5.powerOfNumber;

import base.UnitBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PowerOfNumberTest extends UnitBase {
    private static final String ERROR = "Only 2 non-negative integers are allowed";

    @ParameterizedTest
    @MethodSource("testCases")
    void givenCorrectInput_whenRun_thenCorrectOutput(String input, String expected) {
        setInput(input);
        runPrintRemoveFromOutput();
        assertEquals(expected, getOutput());
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("1 2", "1"),
                Arguments.of("2 0", "1"),
                Arguments.of("3 3", "27"),
                Arguments.of("0 0", "1"),
                Arguments.of("0 5", "0"),
                Arguments.of(" 3    3 ", "27")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 -1", "abc abc", "1", " 1 2 3", "", "-1 1"})
    void givenERROR_whenRun_thenERROR(String input) {
        setInput(input);
        runPrintRemoveFromOutput();
        assertEquals(ERROR, getOutput());
    }

    private void runPrintRemoveFromOutput() {
        new PowerOfNumber().run();
        printOut();
        removeFromOutput("Please, input 2 non-negative numbers:");
    }

}