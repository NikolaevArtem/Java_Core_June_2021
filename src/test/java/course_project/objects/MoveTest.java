package course_project.objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveTest {

    @Test
    void initMoveTest() {
        Move move = new Move(0, 2);

        assertEquals(0, move.getX());
        assertEquals(2, move.getY());
        assertEquals("A3", move.toString());

        move = new Move("B10");

        assertEquals(1, move.getX());
        assertEquals(9, move.getY());
        assertEquals("B10", move.toString());
    }

}
