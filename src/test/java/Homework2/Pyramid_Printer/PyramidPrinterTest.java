package Homework2.Pyramid_Printer;

import base.UnitBase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PyramidPrinterTest extends UnitBase {

    @Test
    void testGetPyramidArray() {
        PyramidPrinter pyramidPrinter = new PyramidPrinter();
        char[][] actual = pyramidPrinter.getPyramidArray(5);
        char [][] expected = new char[][] {
                {'x', ' ', ' ', ' ', ' '},
                {'x', 'x', ' ', ' ', ' '},
                {'x', 'x', 'x', ' ', ' '},
                {'x', 'x', 'x', 'x', ' '},
                {'x', 'x', 'x', 'x', 'x'},
        };
        assertArrayEquals(expected, actual);
    }
      @Test
  void example() {
    setInput("2");

    new PyramidPrinter().run();
    printOut();
    removeFromOutput("Please input number");

    assertEquals("x", getOutputLines()[0]);
    assertEquals("xx", getOutputLines()[1]);
  }
}