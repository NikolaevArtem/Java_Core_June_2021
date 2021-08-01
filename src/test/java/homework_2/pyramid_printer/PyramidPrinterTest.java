package homework_2.pyramid_printer;

import base.UnitBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.StringJoiner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PyramidPrinterTest extends UnitBase {

    private static String welcomeMessage = String.format("Enter int value from 0 - %s: ", Integer.MAX_VALUE);
    private static String errorMessage = "Only 1 non-negative integer is allowed as passed parameter";

    @ParameterizedTest
    @MethodSource("testCases")
    void test_MainCases(final String input, final String expected) {
        setInput(input);
        new PyramidPrinter().run();
        printOut();
        removeFromOutput(welcomeMessage);
        String actual = getOutput();
        assertEquals(expected, actual);
    }

    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("1", getOutput(1)),
                //Arguments.of("2147483647", getOutput(2147483647)), //OutOfMemoryError, Java heap space
                Arguments.of("3", getOutput(3)),
                Arguments.of("5", getOutput(5)),
                Arguments.of("133", getOutput(133)),
                Arguments.of("255", getOutput(255)),
                Arguments.of("0005", getOutput(5)),
                Arguments.of("50", getOutput(50))
        );
    }

    @ParameterizedTest
    @MethodSource("zero_Negative_NonDigit_Values")
    void test_Zero_Negative_NonDigit_Values(final String input, final String expected) {
        setInput(input);
        new PyramidPrinter().run();
        printOut();
        removeFromOutput(welcomeMessage);
        String actual = getOutput();
        assertTrue(actual.contains(expected));
    }

    static Stream<Arguments> zero_Negative_NonDigit_Values() {
        return Stream.of(
                Arguments.of("test", errorMessage),
                Arguments.of("5878 545454 464", errorMessage),
                Arguments.of("hello", errorMessage),
                Arguments.of("0", errorMessage),
                Arguments.of("-5", errorMessage),
                Arguments.of("-100000000", errorMessage),
                Arguments.of("", errorMessage),
                Arguments.of(" ", errorMessage),
                Arguments.of("2147483648", errorMessage)
        );
    }

    private static String getOutput(int inputInt) {
        StringJoiner joiner = new StringJoiner("\r\n");
        String outputString = "x";
        for (int i = 0; i < inputInt; i++) {
            joiner.add(outputString);
            outputString = outputString + "x";
        }
        return joiner.toString();
    }

}