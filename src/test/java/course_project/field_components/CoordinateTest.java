package course_project.field_components;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CoordinateTest {

    @Test
    void givenNewCoordinate_whenGet_thenMatchToInts() {
        final Coordinate first = Coordinate.get("A1");
        assert first != null;
        assertEquals(0, first.row);
        assertEquals(0, first.column);
        final Coordinate coordinate = Coordinate.get(6, 7);
        assert coordinate != null;
        assertEquals(6, coordinate.row);
        assertEquals(7, coordinate.column);
    }

    @Test
    void givenTwoCoordinates_whenCompare_thenTheyAreComperedCorrectly() {
        final Coordinate first = Coordinate.get(5, 5);
        final Coordinate second = Coordinate.get(5, 5);
        final Coordinate lessThenFirst = Coordinate.get(5, 0);
        final Coordinate lessThenSecond = Coordinate.get(3, 5);
        assert second != null;
        assert first != null;
        assertEquals(0, first.compareTo(second));
        assert lessThenFirst != null;
        assertEquals(1, first.compareTo(lessThenFirst));
        assert lessThenSecond != null;
        assertEquals(1, second.compareTo(lessThenSecond));
        assertEquals(-1, lessThenSecond.compareTo(second));
        assertEquals(-1, lessThenFirst.compareTo(first));
        assertEquals(1, lessThenFirst.compareTo(lessThenSecond));
    }

    @ParameterizedTest
    @MethodSource("validInputInts")
    void givenInputInts_whenGet_thenNotNull(int row, int column) {
        assertNotNull(Coordinate.get(row, column));
    }


    static Stream<Arguments> validInputInts() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 4),
                Arguments.of(2, 6),
                Arguments.of(2, 6),
                Arguments.of(9, 6),
                Arguments.of(3, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("validInputStrings")
    void givenInputStrings_whenGet_thenNotNull(String point) {
        assertNotNull(Coordinate.get(point));
    }


    static Stream<Arguments> validInputStrings() {
        return Stream.of(
                Arguments.of("A1"),
                Arguments.of("B4"),
                Arguments.of("J1"),
                Arguments.of("J10"),
                Arguments.of("H3"),
                Arguments.of("I10"),
                Arguments.of("E1")
        );
    }

    @ParameterizedTest
    @MethodSource("invalidInputInts")
    void givenInputInts_whenGet_thenNull(int row, int column) {
        assertNull(Coordinate.get(row, column));
    }

    static Stream<Arguments> invalidInputInts() {
        return Stream.of(
                Arguments.of(-1, 0),
                Arguments.of(10, 4),
                Arguments.of(12, 6),
                Arguments.of(2, 16),
                Arguments.of(9, -5),
                Arguments.of(-5, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidInputStrings")
    void givenInputStrings_whenGet_thenNull(String point) {
        assertNull(Coordinate.get(point));
    }


    static Stream<Arguments> invalidInputStrings() {
        return Stream.of(
                Arguments.of("asdf"),
                Arguments.of("B 4"),
                Arguments.of("X1"),
                Arguments.of("110"),
                Arguments.of("3"),
                Arguments.of(" "),
                Arguments.of("!"),
                Arguments.of("")
        );
    }

    @ParameterizedTest
    @MethodSource("validPairs")
    void givenInt_whenToString_thenPrintsValidStrings(String str, int row, int column) {
        Coordinate coordinate = Coordinate.get(row, column);
        assert coordinate != null;
        assertEquals(str, coordinate.toString());
    }

    static Stream<Arguments> validPairs() {
        return Stream.of(
                Arguments.of("A1", 0, 0),
                Arguments.of("B4", 3, 1),
                Arguments.of("J1", 0, 9),
                Arguments.of("J10", 9, 9),
                Arguments.of("H3", 2, 7),
                Arguments.of("I10", 9, 8)
        );
    }
}
