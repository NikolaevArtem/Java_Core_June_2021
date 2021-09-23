package course_project.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceTest {

    @Test
    void isValidMoveTest() {
        UserService userService = new UserService();

        assertTrue(userService.isValidMove("A1"));
        assertTrue(userService.isValidMove("C10"));
        assertTrue(userService.isValidMove("F8"));
        assertTrue(userService.isValidMove("D4"));
        assertTrue(userService.isValidMove("J10"));

        assertFalse(userService.isValidMove("D0"));
        assertFalse(userService.isValidMove("F11"));
        assertFalse(userService.isValidMove("M5"));
        assertFalse(userService.isValidMove("d6"));
        assertFalse(userService.isValidMove("5B"));
        assertFalse(userService.isValidMove("string"));
        assertFalse(userService.isValidMove(""));
        assertFalse(userService.isValidMove("1 6"));
    }

    @Test
    void isValidMoveResponseTest() {
        UserService userService = new UserService();

        assertTrue(userService.isValidMoveResponse("0"));
        assertTrue(userService.isValidMoveResponse("1"));
        assertTrue(userService.isValidMoveResponse("2"));

        assertFalse(userService.isValidMoveResponse("3"));
        assertFalse(userService.isValidMoveResponse("M5"));
        assertFalse(userService.isValidMoveResponse("string"));
        assertFalse(userService.isValidMoveResponse("MISSED"));
        assertFalse(userService.isValidMoveResponse(""));
        assertFalse(userService.isValidMoveResponse("1 6"));
    }
}
