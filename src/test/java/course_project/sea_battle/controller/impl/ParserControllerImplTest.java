package course_project.sea_battle.controller.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/*
    так как парсер работает только с валидированными данными не валидные значения не имеют значения
 */
class ParserControllerImplTest {
    course_project.sea_battle.controller.ParseController instance = ParserControllerImpl.getInstance();

    @Test
    void parseCoordinate() {
        final String valid1 = "a1";
        final String valid2 = "b5";
        final String valid3 = "g1";
        final String valid4 = "h10";

        assertArrayEquals(new int[]{0,0}, instance.parseCoordinate(valid1));
        assertArrayEquals(new int[]{1,4}, instance.parseCoordinate(valid2));
        assertArrayEquals(new int[]{6,0}, instance.parseCoordinate(valid3));
        assertArrayEquals(new int[]{7,9}, instance.parseCoordinate(valid4));
    }

    @Test
    void isVerticalVector() {
        final String valid1 = "v";
        final String valid2 = "g";

        assertTrue(instance.isVerticalVector(valid1));
        assertFalse(instance.isVerticalVector(valid2));
    }
}