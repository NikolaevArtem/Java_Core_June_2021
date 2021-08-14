package Homework2.Pyramid_Printer;

import base.UnitBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PyramidPrinterTest extends UnitBase {

    static PyramidPrinter pyramidPrinter;

    @BeforeAll
    static void init() {
        pyramidPrinter = new PyramidPrinter();
    }

    @Test
    public void testGetPyramidArray5() {
        char[][] actual = pyramidPrinter.getPyramidArray(5);
        char[][] expected = new char[][]{
                {'x', ' ', ' ', ' ', ' '},
                {'x', 'x', ' ', ' ', ' '},
                {'x', 'x', 'x', ' ', ' '},
                {'x', 'x', 'x', 'x', ' '},
                {'x', 'x', 'x', 'x', 'x'},
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetPyramidArray1() {
        char[][] actual = pyramidPrinter.getPyramidArray(1);
        char[][] expected = new char[][]{{'x'}};
    }

    @Test
    public void testPyramidArrayWithException() {
        setInput("qwery");
        assertDoesNotThrow(() -> pyramidPrinter.run());
    }

}