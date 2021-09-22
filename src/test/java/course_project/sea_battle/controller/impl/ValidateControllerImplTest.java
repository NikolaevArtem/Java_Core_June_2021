package course_project.sea_battle.controller.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateControllerImplTest {

    @Test
    void ValidCoordinateTest() {
        final String val1 = "a1";
        final String val2 = "b9";
        final String val3 = "a3";
        final String val4 = "A1";

        assertTrue(ValidateControllerImpl.getInstance().coordinate(val1));
        assertTrue(ValidateControllerImpl.getInstance().coordinate(val2));
        assertTrue(ValidateControllerImpl.getInstance().coordinate(val3));
        assertTrue(ValidateControllerImpl.getInstance().coordinate(val4));
    }

    @Test
    void NotValidCoordinateTest() {
        final String val1 = "sdfa";
        final String val2 = "asdkgn.";
        final String val3 = "kap 'sf'aojezvczv";
        final String val4 = "";
        final String val5 = null;

        assertFalse(ValidateControllerImpl.getInstance().coordinate(val1));
        assertFalse(ValidateControllerImpl.getInstance().coordinate(val2));
        assertFalse(ValidateControllerImpl.getInstance().coordinate(val3));
        assertFalse(ValidateControllerImpl.getInstance().coordinate(val4));
        assertFalse(ValidateControllerImpl.getInstance().coordinate(val5));
    }

    @Test
    void ValidVectorTest() {
        final String val1 = "g";
        final String val2 = "v";
        final String val3 = "V";

        assertTrue(ValidateControllerImpl.getInstance().vector(val1));
        assertTrue(ValidateControllerImpl.getInstance().vector(val2));
        assertTrue(ValidateControllerImpl.getInstance().vector(val3));
    }

    @Test
    void NotValidVectorTest() {
        final String val1 = "d";
        final String val2 = "z";
        final String val3 = "zfsdfs";

        final String val4 = null;

        assertFalse(ValidateControllerImpl.getInstance().vector(val1));
        assertFalse(ValidateControllerImpl.getInstance().vector(val2));
        assertFalse(ValidateControllerImpl.getInstance().vector(val3));
        assertFalse(ValidateControllerImpl.getInstance().vector(val4));
    }
}