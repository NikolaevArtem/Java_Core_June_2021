package course_project.objects;

import course_project.enums.CellStatus;
import course_project.enums.Response;
import course_project.objects.fields.ComputerField;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerFieldTest {

    @Test
    void initTest() {
        ComputerField computerField = new ComputerField();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                assertEquals(CellStatus.FREE, computerField.getCellStatus(i, j));
            }
        }
    }

    @Test
    void getResponseTest() {
        ComputerField computerField = new ComputerField();

        assertEquals(Response.MISSED, computerField.getResponse(new Move(1, 5)));
        assertEquals(Response.VISITED, computerField.getResponse(new Move(1, 5)));

        computerField.setCellStatus(6, 2, CellStatus.VISITED);
        assertEquals(Response.VISITED, computerField.getResponse(new Move(6, 2)));

        computerField.setCellStatus(3, 7, CellStatus.HAS_SHIP);
        assertEquals(Response.KILLED, computerField.getResponse(new Move(3, 7)));

        computerField.setCellStatus(9, 8, CellStatus.HAS_SHIP);
        computerField.setCellStatus(9, 7, CellStatus.HAS_SHIP);
        computerField.setCellStatus(9, 6, CellStatus.HAS_SHIP);
        assertEquals(Response.HIT, computerField.getResponse(new Move(9, 7)));
        assertEquals(Response.HIT, computerField.getResponse(new Move(9, 6)));
        assertEquals(Response.KILLED, computerField.getResponse(new Move(9, 8)));
    }
}
