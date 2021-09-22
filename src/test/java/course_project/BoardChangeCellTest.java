package course_project;

import course_project.models.Board;
import course_project.models.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardChangeCellTest {


    Board b = new Board();
    Coordinate c;
    String sign;

    @Test
    void putA1() {
        c = new Coordinate("a1");
        sign = "v";
        b.changeCell(c, sign);

        assertEquals(sign, b.getCell(c));
    }

    @Test
    void putJ10() {
        c = new Coordinate("j10");
        sign = "t";
        b.changeCell(c, sign);

        assertEquals(sign, b.getCell(c));
    }

    @Test
    void putA10() {
        c = new Coordinate("a10");
        sign = "*";
        b.changeCell(c, sign);

        assertEquals(sign, b.getCell(c));
    }

    @Test
    void putJ1() {
        c = new Coordinate("a10");
        sign = "X";
        b.changeCell(c, sign);

        assertEquals(sign, b.getCell(c));
    }

}
