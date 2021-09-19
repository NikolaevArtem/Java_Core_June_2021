package course_project.SeaBattle.utility;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void givenValidCoordinates_whenRun_thenReturnTrue() {

        assertTrue(InputValidator.isLegalCoordinate("A1"));
        assertTrue(InputValidator.isLegalCoordinate("a5"));
        assertTrue(InputValidator.isLegalCoordinate("J1"));
        assertTrue(InputValidator.isLegalCoordinate("J5"));
        assertTrue(InputValidator.isLegalCoordinate("f5"));
        assertTrue(InputValidator.isLegalCoordinate("F5"));
        assertTrue(InputValidator.isLegalCoordinate("A10"));
        assertTrue(InputValidator.isLegalCoordinate("j10"));
    }

    @Test
    void givenNonValidCoordinates_whenRun_thenReturnFalse() {

        assertFalse(InputValidator.isLegalCoordinate("A0"));
        assertFalse(InputValidator.isLegalCoordinate("k2"));
        assertFalse(InputValidator.isLegalCoordinate("A22"));
        assertFalse(InputValidator.isLegalCoordinate("j-2"));
        assertFalse(InputValidator.isLegalCoordinate("03"));
        assertFalse(InputValidator.isLegalCoordinate("5b"));
        assertFalse(InputValidator.isLegalCoordinate("l2g3"));
        assertFalse(InputValidator.isLegalCoordinate("bb"));
    }

    @Test
    void givenDirection_whenRun_thenReturnTrue() {

        assertTrue(InputValidator.isLegalDirection("1"));
        assertTrue(InputValidator.isLegalDirection("0"));
    }

    @Test
    void givenNonValidDirection_whenRun_thenReturnFalse() {

        assertFalse(InputValidator.isLegalDirection("a1"));
        assertFalse(InputValidator.isLegalCoordinate("22"));
        assertFalse(InputValidator.isLegalCoordinate("012"));
        assertFalse(InputValidator.isLegalCoordinate("string"));
    }

    @Test
    void givenMode_whenRun_thenReturnTrue() {

        assertTrue(InputValidator.isLegalMode("1"));
        assertTrue(InputValidator.isLegalMode("0"));
    }
    @Test
    void givenNonValidMode_whenRun_thenReturnFalse() {

        assertFalse(InputValidator.isLegalMode("a1"));
        assertFalse(InputValidator.isLegalMode("22"));
        assertFalse(InputValidator.isLegalMode("012"));
        assertFalse(InputValidator.isLegalMode("string"));
    }
}