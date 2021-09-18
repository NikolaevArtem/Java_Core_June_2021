package course_project;

import course_project.engine.Input;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ModeCheckTest {

    @Test
    void testGivenRightMode_v() {
        String input = "v";
        assertTrue(Input.checkMode(input));
    }

    @Test
    void testGivenRightMode_V() {
        String input = "V";
        assertTrue(Input.checkMode(input));
    }

    @Test
    void testGivenRightMode_h() {
        String input = "h";
        assertTrue(Input.checkMode(input));
    }

    @Test
    void testGivenRightMode_H() {
        String input = "H";
        assertTrue(Input.checkMode(input));
    }

    @Test
    void testGivenWrongString_1() {
        String input = "Hv";
        assertFalse(Input.checkMode(input));
    }

    @Test
    void testGivenWrongString_2() {
        String input = "g";
        assertFalse(Input.checkMode(input));
    }

    @Test
    void testGivenWrongString_3() {
        String input = "1";
        assertFalse(Input.checkMode(input));
    }

    @Test
    void testGivenWrongString_4() {
        String input = " ";
        assertFalse(Input.checkMode(input));
    }

    @Test
    void testGivenWrongString_5() {
        String input = "";
        assertFalse(Input.checkMode(input));
    }

}
