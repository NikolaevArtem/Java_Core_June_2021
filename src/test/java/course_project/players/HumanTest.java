package course_project.players;

import base.UnitBase;
import course_project.enums.CellState;
import course_project.enums.ShipKind;
import course_project.field_components.Coordinate;
import course_project.input_readers.ConsoleInputReader;
import course_project.input_readers.InputReader;
import course_project.field_components.Ship;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HumanTest extends UnitBase {

    final InputReader reader = new ConsoleInputReader();
    final Player human = new Human(reader);

    @Test
    void givenPlayer_whenPlayerHaveShipAndIsDefeated_thenReturnFalse() {
        Ship ship = new Ship(ShipKind.TWO_DECK_SHIP,
                Arrays.asList(human.field.getCell(0, 0), human.field.getCell(0, 1)));
        human.playerShips.add(ship);
        assertFalse(human.isDefeated());
    }

    @Test
    void givenPlayer_whenTakeAShot_thenShipGetHitAndReturnStates() { //it is also Ship.takeAShot() method test
        Ship ship = new Ship(ShipKind.TWO_DECK_SHIP,
                Arrays.asList(human.field.getCell(0, 0), human.field.getCell(0, 1)));
        human.playerShips.add(ship);
        human.takeAShot(human.getField().getCell(0, 0));
        assertTrue(ship.getCells().stream().anyMatch(cell -> cell.getState().equals(CellState.HIT)));
        assertFalse(ship.isDestroyed());
        human.takeAShot(human.getField().getCell(0, 1));
        assertFalse(ship.getCells().stream().anyMatch(cell -> cell.getState().equals(CellState.DECK)));
        assertTrue(ship.isDestroyed());
    }

    @Test
    void givenPlayer_whenTakeAShotWrongPoint_thenException() {
        assertThrows(RuntimeException.class, () -> human.takeAShot(human.getField().getCell(0, 0)));
    }

    @ParameterizedTest
    @MethodSource("validInput")
    void givenPlayer_whenMoveCorrectPoints_thenReturnCoordinate(String input, int row, int column) {
        final Player human = new Human(() -> input);
        Coordinate coordinate = human.move();
        assertEquals(row, coordinate.row);
        assertEquals(column, coordinate.column);
    }

    static Stream<Arguments> validInput() {
        return Stream.of(
                Arguments.of("A1", 0, 0),
                Arguments.of("D1", 0, 3),
                Arguments.of("F3", 2, 5),
                Arguments.of("F10", 9, 5),
                Arguments.of("A4", 3, 0)
        );
    }

    @Test
    void givenPlayer_whenMoveWrongPoints_thenReturnNull() {
        List<String> input = Arrays.asList("A0", "D11", "F32", "  F32", "A1 A0", "asdf", "", "A1");
        Iterator<String> iterator = input.iterator();
        final Player human = new Human(iterator::next);
        human.move();
        getOutput();
        List<String> output = Arrays.stream(getOutputLines())
                .filter(s -> s.equals("Invalid input. Try again."))
                .collect(Collectors.toList());
        assertEquals(getOutputLines().length - 1, output.size());
        assertTrue(output.stream().allMatch(s -> s.equals("Invalid input. Try again.")));
    }
}
