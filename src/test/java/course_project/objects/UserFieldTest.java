package course_project.objects;

import course_project.enums.CellStatus;
import course_project.objects.fields.UserField;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserFieldTest {

    @Test
    void initTest() {
        UserField userField = new UserField();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                assertEquals(CellStatus.NOT_VISITED, userField.getCellStatus(i, j));
            }
        }
    }

    @Test
    void setVisitedAroundShipTest() {
        UserField userField = new UserField();

        List<Move> moves = new ArrayList<>();
        moves.add(new Move(1, 2));
        moves.add(new Move(1, 3));
        moves.add(new Move(1, 4));
        userField.setVisitedAroundShip(moves);

        for (int i = 1; i < 6; i++) {
            assertEquals(CellStatus.VISITED, userField.getCellStatus(1, i));
            assertEquals(CellStatus.VISITED, userField.getCellStatus(0, i));
            assertEquals(CellStatus.VISITED, userField.getCellStatus(2, i));
        }
    }

}
