package course_project.field_components;

import base.UnitBase;
import course_project.enums.CellState;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class FieldTest extends UnitBase {

    final static Field field = new Field();

    @BeforeAll
    static void init() {
        field.getCell(Objects.requireNonNull(Coordinate.get("A1"))).setState(CellState.DECK);
        field.getCell(Objects.requireNonNull(Coordinate.get("A2"))).setState(CellState.DECK);
        field.getCell(Objects.requireNonNull(Coordinate.get("A3"))).setState(CellState.DECK);
        field.getCell(Objects.requireNonNull(Coordinate.get("A4"))).setState(CellState.DECK);

        field.getCell(Objects.requireNonNull(Coordinate.get("F6"))).setState(CellState.HIT);

        field.getCell(Objects.requireNonNull(Coordinate.get("E5"))).setState(CellState.MISS);
        field.getCell(Objects.requireNonNull(Coordinate.get("F5"))).setState(CellState.MISS);
        field.getCell(Objects.requireNonNull(Coordinate.get("G5"))).setState(CellState.MISS);
        field.getCell(Objects.requireNonNull(Coordinate.get("E6"))).setState(CellState.MISS);
        field.getCell(Objects.requireNonNull(Coordinate.get("G6"))).setState(CellState.MISS);
        field.getCell(Objects.requireNonNull(Coordinate.get("E7"))).setState(CellState.MISS);
        field.getCell(Objects.requireNonNull(Coordinate.get("F7"))).setState(CellState.MISS);
        field.getCell(Objects.requireNonNull(Coordinate.get("G7"))).setState(CellState.MISS);
    }

    @Test
    void givenNewField_whenPrint_thenPrintedEmptyField() {
        final Field newField = new Field();
        newField.print(false);
        newField.print(true);
        getOutput();
        assertEquals("[32m   A B C D E F G H I J", getOutputLines()[0]);
        assertEquals(" 1 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[1]);
        assertEquals(" 2 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[2]);
        assertEquals(" 3 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[3]);
        assertEquals(" 4 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[4]);
        assertEquals(" 5 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[5]);
        assertEquals(" 6 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[6]);
        assertEquals(" 7 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[7]);
        assertEquals(" 8 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[8]);
        assertEquals(" 9 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[9]);
        assertEquals("10 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[10]);

        assertEquals("\u001B[31m   A B C D E F G H I J", getOutputLines()[12]);
        assertEquals(" 1 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[13]);
        assertEquals(" 2 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[14]);
        assertEquals(" 3 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[15]);
        assertEquals(" 4 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[16]);
        assertEquals(" 5 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[17]);
        assertEquals(" 6 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[18]);
        assertEquals(" 7 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[19]);
        assertEquals(" 8 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[20]);
        assertEquals(" 9 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[21]);
        assertEquals("10 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[22]);
    }

        @Test
        void givenChangedField_whenPrint_thenPrintedHiddenAndVisibleFields() {
            field.print(true);
            field.print(false);
            getOutput();
            assertEquals("[31m   A B C D E F G H I J", getOutputLines()[0]);
            assertEquals(" 1 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[1]);
            assertEquals(" 2 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[2]);
            assertEquals(" 3 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[3]);
            assertEquals(" 4 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[4]);
            assertEquals(" 5 ~ ~ ~ ~ * * * ~ ~ ~", getOutputLines()[5]);
            assertEquals(" 6 ~ ~ ~ ~ * X * ~ ~ ~", getOutputLines()[6]);
            assertEquals(" 7 ~ ~ ~ ~ * * * ~ ~ ~", getOutputLines()[7]);
            assertEquals(" 8 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[8]);
            assertEquals(" 9 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[9]);
            assertEquals("10 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[10]);

            assertEquals("\u001B[32m   A B C D E F G H I J", getOutputLines()[12]);
            assertEquals(" 1 O ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[13]);
            assertEquals(" 2 O ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[14]);
            assertEquals(" 3 O ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[15]);
            assertEquals(" 4 O ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[16]);
            assertEquals(" 5 ~ ~ ~ ~ * * * ~ ~ ~", getOutputLines()[17]);
            assertEquals(" 6 ~ ~ ~ ~ * X * ~ ~ ~", getOutputLines()[18]);
            assertEquals(" 7 ~ ~ ~ ~ * * * ~ ~ ~", getOutputLines()[19]);
            assertEquals(" 8 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[20]);
            assertEquals(" 9 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[21]);
            assertEquals("10 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~", getOutputLines()[22]);
    }

    @Test
    void givenField_whenGetCells_thenCellsTheSame() {
        Cell first = field.getCell(Objects.requireNonNull(Coordinate.get("F6")));
        Cell second = field.getCell(Objects.requireNonNull(Coordinate.get(5, 5)));
        assertEquals(first, second);
    }

    @Test
     void givenField_whenGetNeighbourCells_thenReturnExistingCells() {
        List<Cell> neighbourHit = field.getNeighbourCells(Objects.requireNonNull(Coordinate.get("F6")));
        List<Cell> neighbourDeckInCorner = field.getNeighbourCells(Objects.requireNonNull(Coordinate.get("A1")));
        assertEquals(8, neighbourHit.size());
        assertTrue(neighbourHit.stream().allMatch(c -> c.getState().equals(CellState.MISS)));
        assertEquals(3, neighbourDeckInCorner.size());
        List<Cell> deck = neighbourDeckInCorner
                .stream()
                .filter(cell -> cell.getState().equals(CellState.DECK))
                .collect(Collectors.toList());
        List<Cell> empty = neighbourDeckInCorner
                .stream()
                .filter(cell -> cell.getState().equals(CellState.EMPTY))
                .collect(Collectors.toList());
        assertEquals(1, deck.size());
        assertEquals(2, empty.size());
    }

}
