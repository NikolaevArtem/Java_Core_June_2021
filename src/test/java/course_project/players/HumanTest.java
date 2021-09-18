package course_project.players;

import base.UnitBase;
import course_project.enums.CellState;
import course_project.enums.ShipKind;
import course_project.field_components.Cell;
import course_project.field_components.Coordinate;
import course_project.field_components.Field;
import course_project.input_readers.ConsoleInputReader;
import course_project.input_readers.InputReader;
import course_project.ship_placers.Ship;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class HumanTest extends UnitBase {

    final InputReader reader = new ConsoleInputReader();
    final Player human = new Human(reader);
    {

    }


    @Test
    void givenPlayer_whenPlayerHaveShipAndIsDefeated_thenReturnFalse() {
        assertFalse(human.isDefeated());
    }

    @Test
    void givenPlayer_whenTakeAShot_thenShipGetHitAndReturnStates() {
        Ship ship = new Ship(ShipKind.TWO_DECK_SHIP,
                Arrays.asList(human.field.getCell(0, 0), human.field.getCell(0, 1)));
        human.playerShips.add(ship);
        human.takeAShot(Coordinate.get(0, 0));
        assertTrue(ship.getCells().stream().anyMatch(cell -> cell.getState().equals(CellState.HIT)));
        assertFalse(ship.isDestroyed());
        human.takeAShot(Coordinate.get(0, 1));
        assertFalse(ship.getCells().stream().anyMatch(cell -> cell.getState().equals(CellState.DECK)));
        assertTrue(ship.isDestroyed());
    }

    @Test
    void givenPlayer_whenTakeAShotWrongPoint_thenException() {
        assertThrows(RuntimeException.class, () -> human.takeAShot(Coordinate.get(0, 0)));
    }

    @ParameterizedTest
    @MethodSource("validInput")
    void givenPlayer_whenMove_thenReturnCoordinate(String input, int row, int column) {
        final InputReader reader = new ConsoleInputReader();
        final Player human = new Human(reader);
        getOutput();
        setInput(input);
        Coordinate coordinate = human.move();
        assertEquals(row, coordinate.row);
        assertEquals(column, coordinate.column);
    }

    static Stream<Arguments> validInput() {
        return Stream.of(
                Arguments.of("A1", 0, 0),
                Arguments.of("D1", 1, 4),
                Arguments.of("F3", 2, 6),
                Arguments.of("F10", 9, 6),
                Arguments.of("A4", 3, 0)
        );
    }

    @Test
    void givenPlayer_whenPlayerHaveDestroyedShipAndIsDefeated_thenReturnTrue() {
        assertTrue(human.isDefeated());
    }

}
