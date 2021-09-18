package course_project.services;

import course_project.enums.CellStatus;
import course_project.objects.Move;
import course_project.objects.fields.UserField;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoveGeneratorTest {

    @Test
    void generateTest() {
        Move move = MoveGenerator.generate(new UserField());

        assertTrue(0 <= move.getX() && move.getX() < 10);
        assertTrue(0 <= move.getY() && move.getY() < 10);
    }

    @Test
    void generateWithLastHitTest() {
        UserField userField = new UserField();
        userField.setCellStatus(3, 3, CellStatus.VISITED);
        userField.setCellStatus(2, 3, CellStatus.VISITED);
        List<Move> lastHit = new ArrayList<>();
        lastHit.add(new Move(3, 3));
        Move move = MoveGenerator.generate(userField, lastHit);

        assertEquals(4, move.getX());
        assertEquals(3, move.getY());

        userField.setCellStatus(3, 4, CellStatus.VISITED);
        lastHit.add(new Move(3, 4));
        move = MoveGenerator.generate(userField, lastHit);

        assertEquals(3, move.getX());
        assertEquals(2, move.getY());
    }

}
