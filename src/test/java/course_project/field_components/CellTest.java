package course_project.field_components;

import course_project.SeaBattle;
import course_project.enums.CellState;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CellTest {

    @ParameterizedTest
    @MethodSource("validInput")
    void givenTwoInts_whenNew_thenReturnCells(int row, int column) {
        final Cell cell = new Cell(row, column);
        final Coordinate coordinate = Coordinate.get(row, column);
        assertEquals(0, coordinate.compareTo(cell.getCoordinate()));
        assertEquals("~", cell.toString());

    }

    static Stream<Arguments> validInput() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 4),
                Arguments.of(2, 6),
                Arguments.of(3, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidInput")
    void givenTwoInts_whenNew_thenException(int row, int column) {
        assertThrows(IllegalArgumentException.class, () -> new Cell(row, column));
    }

    static Stream<Arguments> invalidInput() {
        return Stream.of(
                Arguments.of(-1, 0),
                Arguments.of(SeaBattle.FIELD_SIZE + 4, 4),
                Arguments.of(0, SeaBattle.FIELD_SIZE + 14),
                Arguments.of(0, -1)
        );
    }

    @Test
    void givenCellStates_whenSet_thenTheyChanged() {
        final Cell cell = new Cell(0,0);
        assertEquals(CellState.EMPTY, cell.getState());
        cell.setState(CellState.DECK);
        assertEquals(CellState.DECK, cell.getState());
        cell.setState(CellState.MISS);
        assertEquals(CellState.MISS, cell.getState());
        cell.setState(CellState.HIT);
        assertEquals(CellState.HIT, cell.getState());
    }

    @Test
    void givenCellStates_whenCheckState_thenTrueOrFalse() {
        final Cell cell = new Cell(0,0);
        assertTrue(cell.checkState(CellState.EMPTY));
        assertFalse(cell.checkState(CellState.DECK));
        assertFalse(cell.checkState(CellState.MISS));
        assertFalse(cell.checkState(CellState.HIT));
        cell.setState(CellState.DECK);
        assertTrue(cell.checkState(CellState.DECK));
        cell.setState(CellState.MISS);
        assertTrue(cell.checkState(CellState.MISS));
        cell.setState(CellState.HIT);
        assertTrue(cell.checkState(CellState.HIT));
    }
}
