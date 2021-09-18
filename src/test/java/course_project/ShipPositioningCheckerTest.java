package course_project;
import course_project.models.Board;
import course_project.models.Coordinate;
import course_project.engine.PositionChecker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShipPositioningCheckerTest {

    Board b = new Board();
    Coordinate c;
    int size;
    String mode;


    @Test
    void test_EnoughPlace_VerticalA1() {
        c = new Coordinate("a1");
        size = 4;
        mode = "v";
        assertTrue(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_EnoughPlace_Horizontal_A1() {
        c = new Coordinate("a1");
        size = 4;
        mode = "h";
        assertTrue(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_EnoughPlace_Vertical_J1() {
        c = new Coordinate("j1");
        size = 4;
        mode = "v";
        assertTrue(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_EnoughPlace_Vertical_A6() {
        c = new Coordinate("a6");
        size = 4;
        mode = "v";
        assertTrue(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_EnoughPlace_Horizontal_A6() {
        c = new Coordinate("a6");
        size = 4;
        mode = "h";
        assertTrue(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_EnoughPlace_Horizontal_A10() {
        c = new Coordinate("a8");
        size = 4;
        mode = "h";
        assertTrue(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_NotEnoughPlace_Vertical_A8() {
        c = new Coordinate("a8");
        size = 4;
        mode = "v";
        assertFalse(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_NotEnoughPlace_HorizontalJ1() {
        c = new Coordinate("j1");
        size = 4;
        mode = "h";
        assertFalse(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_NotEnoughPlace_HorizontalJ8() {
        c = new Coordinate("j8");
        size = 4;
        mode = "h";
        assertFalse(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_ObstacleE5NotEnoughPlace_VerticalD1() {
        b.changeCell(new Coordinate("e5"), "O"); // add obstacle
        c = new Coordinate("d1");
        size = 4;
        mode = "v";
        assertFalse(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_ObstacleE5NotEnoughPlace_VerticalE1() {
        b.changeCell(new Coordinate("e5"), "O"); // add obstacle
        c = new Coordinate("e1");
        size = 4;
        mode = "v";
        assertFalse(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_ObstacleE5NotEnoughPlace_VerticalF1() {
        b.changeCell(new Coordinate("e5"), "O"); // add obstacle
        c = new Coordinate("f1");
        size = 4;
        mode = "v";
        assertFalse(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_ObstacleE5NotEnoughPlace_VerticalD5() {
        b.changeCell(new Coordinate("e5"), "O"); // add obstacle
        c = new Coordinate("d5");
        size = 4;
        mode = "v";
        assertFalse(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_ObstacleE5NotEnoughPlace_VerticalE5() {
        b.changeCell(new Coordinate("e5"), "O"); // add obstacle
        c = new Coordinate("e5");
        size = 4;
        mode = "v";
        assertFalse(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_ObstacleE5NotEnoughPlace_VerticalF5() {
        b.changeCell(new Coordinate("e5"), "O"); // add obstacle
        c = new Coordinate("f5");
        size = 4;
        mode = "v";
        assertFalse(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_ObstacleE5NotEnoughPlace_VerticalD6() {
        b.changeCell(new Coordinate("e5"), "O"); // add obstacle
        c = new Coordinate("d6");
        size = 4;
        mode = "v";
        assertFalse(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_ObstacleE5NotEnoughPlace_VerticalE6() {
        b.changeCell(new Coordinate("e5"), "O"); // add obstacle
        c = new Coordinate("e6");
        size = 4;
        mode = "v";
        assertFalse(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_ObstacleE5NotEnoughPlace_VerticalF6() {
        b.changeCell(new Coordinate("e5"), "O"); // add obstacle
        c = new Coordinate("f6");
        size = 4;
        mode = "v";
        assertFalse(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_ObstacleE5NotEnoughPlace_HorizontalA4() {
        b.changeCell(new Coordinate("e5"), "O"); // add obstacle
        c = new Coordinate("a4");
        size = 4;
        mode = "h";
        assertFalse(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_ObstacleE5NotEnoughPlace_HorizontalA5() {
        b.changeCell(new Coordinate("e5"), "O"); // add obstacle
        c = new Coordinate("a5");
        size = 4;
        mode = "h";
        assertFalse(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_ObstacleE5NotEnoughPlace_HorizontalA6() {
        b.changeCell(new Coordinate("e5"), "O"); // add obstacle
        c = new Coordinate("a6");
        size = 4;
        mode = "h";
        assertFalse(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_ObstacleE5NotEnoughPlace_HorizontalF4() {
        b.changeCell(new Coordinate("e5"), "O"); // add obstacle
        c = new Coordinate("f4");
        size = 4;
        mode = "h";
        assertFalse(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_ObstacleE5NotEnoughPlace_HorizontalF5() {
        b.changeCell(new Coordinate("e5"), "O"); // add obstacle
        c = new Coordinate("f5");
        size = 4;
        mode = "h";
        assertFalse(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_ObstacleE5NotEnoughPlace_HorizontalF6() {
        b.changeCell(new Coordinate("e5"), "O"); // add obstacle
        c = new Coordinate("f6");
        size = 4;
        mode = "h";
        assertFalse(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_ObstacleE5EnoughPlace_HorizontalC3() {
        b.changeCell(new Coordinate("e5"), "O"); // add obstacle
        c = new Coordinate("c3");
        size = 4;
        mode = "h";
        assertTrue(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_ObstacleE5EnoughPlace_HorizontalD7() {
        b.changeCell(new Coordinate("e5"), "O"); // add obstacle
        c = new Coordinate("d7");
        size = 4;
        mode = "h";
        assertTrue(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_ObstacleE5EnoughPlace_HorizontalG4() {
        b.changeCell(new Coordinate("e5"), "O"); // add obstacle
        c = new Coordinate("g4");
        size = 4;
        mode = "h";
        assertTrue(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_ObstacleE5EnoughPlace_VerticalC1() {
        b.changeCell(new Coordinate("e5"), "O"); // add obstacle
        c = new Coordinate("c1");
        size = 4;
        mode = "v";
        assertTrue(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_ObstacleE5EnoughPlace_VerticalG1() {
        b.changeCell(new Coordinate("e5"), "O"); // add obstacle
        c = new Coordinate("g1");
        size = 4;
        mode = "v";
        assertTrue(PositionChecker.possibleToPlace(b,c,size,mode));
    }

    @Test
    void test_ObstacleE5EnoughPlace_VerticalD7() {
        b.changeCell(new Coordinate("e5"), "O"); // add obstacle
        c = new Coordinate("g1");
        size = 4;
        mode = "v";
        assertTrue(PositionChecker.possibleToPlace(b,c,size,mode));
    }

}
