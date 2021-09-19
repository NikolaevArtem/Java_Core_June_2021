package course_project.battleship_game.service;

import course_project.battleship_game.model.Board;
import course_project.battleship_game.model.Cell;
import course_project.battleship_game.model.CellStatus;
import course_project.battleship_game.model.Ship;
import course_project.battleship_game.model.ShipType;
import course_project.battleship_game.utils.RandomGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class BoardServiceTest {

    @ParameterizedTest
    @MethodSource("testCasesIsHitCellOnBoard")
    void isHitCellOnBoardTrue(final Ship ship) {
        Board board = Mockito.mock(Board.class);
        BoardService boardService = new BoardService(board);
        when(board.getShipList()).thenReturn(new ArrayList<>(Arrays.asList(ship)));
        assertTrue(boardService.isHitCellOnBoard(ship.getCellsList().get(0)));
    }

    @Test
    void isHitCellOnBoardFalse() {
        Board board = new Board();
        BoardService boardService = new BoardService(board);
        Cell cell = new Cell(1, 1);
        assertFalse(boardService.isHitCellOnBoard(cell));
    }

    @Test
    void testIsCreatingShipSuccessfulTrue() {
        Board board = new Board();
        BoardService boardService = new BoardService(board);
        assertTrue(boardService.isCreatingShipSuccessful(new Cell(0, 0, CellStatus.SHIP), ShipType.TORPEDO_BOAT, 0));
    }

    @Test
    void testIsCreatingShipSuccessfulFalse() {
        Board board = Mockito.mock(Board.class);
        BoardService boardService = new BoardService(board);
        Cell start = new Cell(RandomGenerator.generateNumFrom0to9(), RandomGenerator.generateNumFrom0to9());
        Ship ship = new Ship(start, ShipType.BATTLESHIP, 0);
        when(board.getShipList()).thenReturn(new ArrayList<>(Arrays.asList(ship)));
        assertFalse(boardService.isCreatingShipSuccessful(start, ShipType.BATTLESHIP, 0));
    }

    static Stream<Arguments> testCasesIsHitCellOnBoard() {
        return Stream.of(
                Arguments.of(
                        new Ship(new Cell(RandomGenerator.generateNumFrom0to9(), RandomGenerator.generateNumFrom0to9()),
                                ShipType.BATTLESHIP, 0)),
                Arguments.of(new Ship(new Cell(RandomGenerator.generateNumFrom0to9(), RandomGenerator.generateNumFrom0to9()),
                        ShipType.TORPEDO_BOAT, 0)),
                Arguments.of(new Ship(new Cell(RandomGenerator.generateNumFrom0to9(), RandomGenerator.generateNumFrom0to9()),
                        ShipType.CRUISER, 1)),
                Arguments.of(new Ship(new Cell(RandomGenerator.generateNumFrom0to9(), RandomGenerator.generateNumFrom0to9()),
                        ShipType.DESTROYER, 1))
        );
    }

}