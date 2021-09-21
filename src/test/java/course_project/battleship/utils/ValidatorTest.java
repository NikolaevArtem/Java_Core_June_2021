package course_project.battleship.utils;

import base.UnitBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ValidatorTest extends UnitBase {

    @ParameterizedTest
    @MethodSource("invalidCoordinates")
    void givenInvalidCoordinate_whenRun_thenCheckReturn(Coordinate coordinate) {
        assertFalse(Validator.isValidCoordinate(coordinate));
    }

    @ParameterizedTest
    @MethodSource("invalidDirections")
    void givenInvalidCoordinate_whenRun_then_checkReturn(int direction) {
        assertFalse(Validator.isValidDirection(direction));
    }

    private static Stream<Arguments> invalidCoordinates() {
        return Stream.of(
                arguments(new Coordinate(12, 5)),
                arguments(new Coordinate(-5, 5)),
                arguments(new Coordinate(5, 12)),
                arguments(new Coordinate(5, -5))
        );
    }

    private static Stream<Arguments> invalidDirections() {
        return Stream.of(
                arguments(3),
                arguments(-1)
        );
    }


}