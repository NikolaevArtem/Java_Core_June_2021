package homework_2.pyramid_printer.sources;

import base.UnitBase;
import homework_2.pyramid_printer.PyramidPrinter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PyramidPrintTest extends UnitBase {

    PyramidPrinter pyramidPrinter = new PyramidPrinter();

    // testing valid input
    private static Stream<Arguments> validCases() {
        return Stream.of(
                Arguments.of(7),
                Arguments.of(4),
                Arguments.of(33),
                Arguments.of(1),
                Arguments.of(188)
        );
    }

    @ParameterizedTest
    @MethodSource("validCases")
    void validTest(int height) {
        setInput(String.valueOf(height));
        pyramidPrinter.run();
        printOut();
        removeFromOutput("Please, input Pyramid height: ");
        for (int i = 0; i < height; i++) {
            StringBuilder expectedStr = new StringBuilder();
            for (int j = 0; j < i + 1; j++) {
                expectedStr.append("x");
            }
            assertEquals(String.valueOf(expectedStr), getOutputLines()[i]);
        }
    }

    // testing not valid input values
    private static Stream<Arguments> notValidCases() {
        return Stream.of(
                Arguments.of(String.valueOf(Integer.MAX_VALUE + 1)),
                Arguments.of("anytext"),
                Arguments.of(""),
                Arguments.of("-278")
        );
    }

    @ParameterizedTest
    @MethodSource("notValidCases")
    void testNotValid(String input) {
        setInput(input);
        pyramidPrinter.run();
        printOut();
        removeFromOutput("Please, input Pyramid height: ");
        assertEquals("Only 1 non-negative integer is allowed as passed parameter", getOutputLines()[0]);
    }

    @Test
    void testNull() {
        setInput("0");
        pyramidPrinter.run();
        printOut();
        removeFromOutput("Please, input Pyramid height: ");
        assertEquals("", getOutputLines()[0]);
    }

}
