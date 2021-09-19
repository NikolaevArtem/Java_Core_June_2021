package course_project.battleship_game;

import course_project.battleship_game.model.Cell;
import course_project.battleship_game.model.CellStatus;
import course_project.battleship_game.model.Ship;
import course_project.battleship_game.service.ShipService;
import course_project.battleship_game.utils.RandomGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class ShipServiceTest {

    @ParameterizedTest
    @MethodSource("testCasesIsHit")
    void testIsHit(final Cell cell) {
        Ship shipTrue = Mockito.mock(Ship.class);
        Ship shipFalse = Mockito.mock(Ship.class);
        ShipService shipServiceTrue = new ShipService(shipTrue);
        ShipService shipServiceFalse = new ShipService(shipFalse);
        when(shipTrue.getCellsList()).thenReturn(new ArrayList<>(Arrays.asList(cell)));
        assertTrue(shipServiceTrue.isHit(cell));
        when(shipFalse.getCellsList()).thenReturn(new ArrayList<>());
        assertFalse(shipServiceFalse.isHit(cell));
    }

    @Test
    void testIsNotAlive() {
        Ship ship = Mockito.mock(Ship.class);
        ShipService shipService = new ShipService(ship);
        when(ship.getCellsList())
                .thenReturn(new ArrayList<>(Collections.singletonList(
                        new Cell(RandomGenerator.generateNumFrom0to9(), RandomGenerator.generateNumFrom0to9(), CellStatus.HIT))));
        assertTrue(shipService.isNotAlive());
    }

    static Stream<Arguments> testCasesIsHit() {
        return Stream.of(
                Arguments.of(new Cell(RandomGenerator.generateNumFrom0to9(), RandomGenerator.generateNumFrom0to9())),
                Arguments.of(new Cell(RandomGenerator.generateNumFrom0to9(), RandomGenerator.generateNumFrom0to9())),
                Arguments.of(new Cell(RandomGenerator.generateNumFrom0to9(), RandomGenerator.generateNumFrom0to9())),
                Arguments.of(new Cell(RandomGenerator.generateNumFrom0to9(), RandomGenerator.generateNumFrom0to9()))
        );
    }


}