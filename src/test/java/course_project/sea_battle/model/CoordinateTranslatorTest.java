package course_project.sea_battle.model;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTranslatorTest extends UnitBase {

    @Test
    void coordinateTestNull() {
        assertEquals(10,CoordinateTranslator.coordinate(null));
    }
    @Test
    void coordinateTestA() {
        assertEquals(0,CoordinateTranslator.coordinate("A"));
        assertEquals(0,CoordinateTranslator.coordinate("a"));
    }
    @Test
    void coordinateTestB() {

        assertEquals(1,CoordinateTranslator.coordinate("b"));
    }
    @Test
    void coordinateTestC() {
        assertEquals(2,CoordinateTranslator.coordinate("C"));
        assertEquals(2,CoordinateTranslator.coordinate("c"));
    }
    @Test
    void coordinateTestD() {
        assertEquals(3,CoordinateTranslator.coordinate("D"));
        assertEquals(3,CoordinateTranslator.coordinate("d"));
    }
    @Test
    void coordinateTestE() {
        assertEquals(4,CoordinateTranslator.coordinate("E"));
        assertEquals(4,CoordinateTranslator.coordinate("e"));
    }
    @Test
    void coordinateTestF() {
        assertEquals(5,CoordinateTranslator.coordinate("F"));
        assertEquals(5,CoordinateTranslator.coordinate("f"));
    }
    @Test
    void coordinateTestG() {
        assertEquals(6,CoordinateTranslator.coordinate("G"));
        assertEquals(6,CoordinateTranslator.coordinate("g"));
    }
    @Test
    void coordinateTestH() {
        assertEquals(7,CoordinateTranslator.coordinate("H"));
        assertEquals(7,CoordinateTranslator.coordinate("h"));
    }
    @Test
    void coordinateTestI() {
        assertEquals(8,CoordinateTranslator.coordinate("I"));
        assertEquals(8,CoordinateTranslator.coordinate("i"));
    }
    @Test
    void coordinateTestJ() {
        assertEquals(9,CoordinateTranslator.coordinate("J"));
        assertEquals(9,CoordinateTranslator.coordinate("j"));
    }

}