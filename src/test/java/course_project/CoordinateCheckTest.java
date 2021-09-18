package course_project;

import course_project.engine.Input;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoordinateCheckTest {

    @Test
    void testWrongInput_1() {
        String input = "a0";
        assertFalse(Input.checkCoordinate(input));
    }

    @Test
    void testWrongInput_2() {
        String input = "0";
        assertFalse(Input.checkCoordinate(input));
    }

    @Test
    void testWrongInput_3() {
        String input = "q";
        assertFalse(Input.checkCoordinate(input));
    }

    @Test
    void testWrongInput_4() {
        String input = "q1";
        assertFalse(Input.checkCoordinate(input));
    }

    @Test
    void testWrongInput_5() {
        String input = "";
        assertFalse(Input.checkCoordinate(input));
    }

    @Test
    void testWrongInput_6() {
        String input = "null";
        assertFalse(Input.checkCoordinate(input));
    }

    @Test
    void testWrongInput_7() {
        String input = "a12";
        assertFalse(Input.checkCoordinate(input));
    }

    @Test
    void testWrongInput_8() {
        String input = "k6";
        assertFalse(Input.checkCoordinate(input));
    }

    @Test
    void testWrongInput_9() {
        String input = "112";
        assertFalse(Input.checkCoordinate(input));
    }

    @Test
    void testWrongInput_10() {
        String input = "abds";
        assertFalse(Input.checkCoordinate(input));
    }

    @Test
    void testRightInput_1() {
        String input = "a1";
        assertTrue(Input.checkCoordinate(input));
    }

    @Test
    void testRightInput_2() {
        String input = "B6";
        assertTrue(Input.checkCoordinate(input));
    }
    @Test
    void testRightInput_3() {
        String input = "j10";
        assertTrue(Input.checkCoordinate(input));
    }

}
