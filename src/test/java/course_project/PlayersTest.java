package course_project;

import base.UnitBase;
import course_project.sea_battle.input_readers.InputFileReader;
import course_project.sea_battle.players.ComputerPlayer;
import course_project.sea_battle.playground.CellStatus;
import homework_2.WrongInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Arrays;

public class PlayersTest extends UnitBase {

    @Test
    void whenComputerSetsShips_thenSetCorrectNumberOfOccupiedCells() throws IOException, WrongInputException {
        ComputerPlayer pc = new ComputerPlayer(new InputFileReader());
        pc.setShips();

        long occupiedCellsCount = Arrays.stream(pc.getPlayground()
                .getCells())
                .mapToLong(cells -> Arrays.stream(cells)
                        .filter(cell -> (cell.getStatus() == CellStatus.OCCUPIED))
                        .count())
                .sum();

        assertEquals(occupiedCellsCount, 5 + 4 + 3 * 2 + 2);
    }
}
