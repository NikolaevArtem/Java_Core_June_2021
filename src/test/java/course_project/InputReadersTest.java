package course_project;

import base.UnitBase;
import course_project.sea_battle.input_readers.InputConsoleReader;
import course_project.sea_battle.playground.CellData;
import homework_2.WrongInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import java.io.IOException;

public class InputReadersTest extends UnitBase {

    @Test
    void givenInputCorrect_whenRunInputRead_thenReturnCellData() throws IOException, WrongInputException {
        setInput("A-4");

        InputConsoleReader inputConsoleReader = new InputConsoleReader();
        Object result = inputConsoleReader.readShotData();

        assertTrue(result instanceof CellData);
        assertEquals(4, ((CellData) result).getCol());
        assertEquals('A', ((CellData) result).getLine());
        assertEquals(0, ((CellData) result).getRow());

    }

    @Test
    void givenInputIncorrect_whenRunInputRead_thenThrowError() {
        setInput("hello");

        InputConsoleReader inputConsoleReader = new InputConsoleReader();

        assertThrows(WrongInputException.class, () -> inputConsoleReader.readShotData());
    }
}
