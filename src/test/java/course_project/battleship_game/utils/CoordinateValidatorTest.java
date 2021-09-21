package course_project.battleship_game.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CoordinateValidatorTest {

    @ParameterizedTest
    @MethodSource("testCasesIsCoordinate")
    void test(final String coordinate, final boolean expected) {
        assertEquals(expected, CoordinateValidator.isCoordinate(coordinate));
    }

    static Stream<Arguments> testCasesIsCoordinate() {
        return Stream.of(
                Arguments.of("A1", true),
                Arguments.of("a10", true),
                Arguments.of("j1", true),
                Arguments.of("J10", true),
                Arguments.of("K6", false),
                Arguments.of("x10", false),
                Arguments.of("I11", false),
                Arguments.of("1", false),
                Arguments.of("y", false),
                Arguments.of("i 9", false),
                Arguments.of("90", false)
        );
    }
}
