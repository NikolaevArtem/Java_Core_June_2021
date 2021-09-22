package course_project.field_components;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CellHandlerTest {

    final CellHandler cellHandler = new CellHandler();
    //valid
    final Coordinate[] single = new Coordinate[]{Coordinate.get("A1")};
    final Coordinate[] twoInRow = new Coordinate[]{Coordinate.get("A1"), Coordinate.get("J1")};
    final Coordinate[] twoInColumn = new Coordinate[]{Coordinate.get("A1"), Coordinate.get("A10")};
    //invalid
    final Coordinate[] zero = new Coordinate[]{};
    final Coordinate[] twoDiagonal = new Coordinate[]{Coordinate.get("A1"), Coordinate.get("B2")};
    final Coordinate[] three = new Coordinate[]{Coordinate.get("A1"), Coordinate.get("A10"),Coordinate.get("B2")};


    @Test
    void givenDotAndLine_whenIsLine_thenTrue() {
        assertTrue(cellHandler.isLine(single));
        assertTrue(cellHandler.isLine(twoInRow));
    }

    @Test
    void givenNoneAndLines_whenIsLine_thenFalse() {
        assertFalse(cellHandler.isLine(twoDiagonal));
        assertFalse(cellHandler.isLine(three));
        assertFalse(cellHandler.isLine(zero));
    }

    @Test
    void givenDotAndLines_whenSameLine_thenTrue() {
        assertTrue(cellHandler.sameLine(single, true));
        assertTrue(cellHandler.sameLine(single, false));
        assertTrue(cellHandler.sameLine(twoInRow, true));
        assertTrue(cellHandler.sameLine(twoInColumn, false));
    }

    @Test
    void givenNoneAndLines_whenSameLine_thenFalse() {
        assertFalse(cellHandler.sameLine(twoDiagonal, true));
        assertFalse(cellHandler.sameLine(twoDiagonal, false));
        assertFalse(cellHandler.sameLine(three, true));
        assertFalse(cellHandler.sameLine(three, false));
        assertFalse(cellHandler.sameLine(zero, true));
        assertFalse(cellHandler.sameLine(zero, false));
    }

    @Test
    void givenLineRow_whenSameLineIsRowFalse_thenFalse() {
        assertFalse(cellHandler.sameLine(twoInRow, false));
    }

    @Test
    void givenLineColumn_whenSameLineIsRowTrue_thenFalse() {
        assertFalse(cellHandler.sameLine(twoInColumn, true));
    }

    @Test
    void givenDotAndLines_whenCellCount_thenReturnLengthMinusOne() {
        assertEquals(0, cellHandler.cellCount(single));
        assertEquals(9, cellHandler.cellCount(twoInRow));
        assertEquals(9, cellHandler.cellCount(twoInColumn));
    }

    @Test
    void givenNoneAndLines_whenCellCount_thenReturnNegative() {
        assertEquals(-1, cellHandler.cellCount(zero));
        assertEquals(-1, cellHandler.cellCount(twoDiagonal));
        assertEquals(-1, cellHandler.cellCount(three));
    }


}
