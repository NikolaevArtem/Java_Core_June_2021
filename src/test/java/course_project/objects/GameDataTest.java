package course_project.objects;

import course_project.enums.CellStatus;
import course_project.enums.Response;
import course_project.objects.fields.ComputerField;
import course_project.services.ShipLocationGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameDataTest {

    @Test
    void getResponseFromComputerTest() {
        ComputerField computerField = new ComputerField();
        computerField.setCellStatus(4, 4, CellStatus.HAS_SHIP);
        ShipLocationGenerator generator = Mockito.mock(ShipLocationGenerator.class);
        Mockito.when(generator.generateShips()).thenReturn(computerField);
        GameData gameData = new GameData(generator);

        assertEquals(Response.KILLED, gameData.getResponseFromComputer(new Move(4, 4)));
        assertEquals(9, gameData.getComputerShips());
    }

    @Test
    void saveComputerMoveResult() {
        GameData gameData = new GameData(new ShipLocationGenerator());

        List<Move> moves = new ArrayList<>();
        moves.add(new Move(1, 1));
        gameData.saveComputerMoveResult(Response.KILLED, moves.get(0), moves);

        assertEquals(9, gameData.getUserShips());
    }
}
