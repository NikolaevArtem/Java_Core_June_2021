package course_project.sea_battle.input_readers;

import course_project.sea_battle.playground.CellData;
import homework_2.WrongInputException;

import java.io.IOException;

public abstract class InputReader {
    private final String ERROR_MSG;

    protected InputReader(String error_msg) {
        ERROR_MSG = error_msg;
    }

    public abstract void close() throws IOException;

    public abstract CellData readShotData() throws WrongInputException, IOException;

    protected CellData parseInput(String input) throws WrongInputException {
        try {
            String[] data = input.split("-");
            if (data.length != 2) {
                throw new WrongInputException(ERROR_MSG);
            }
            if (data[0].length() != 1) {
                throw new WrongInputException(ERROR_MSG);
            }

            char line = data[0].charAt(0);
            int col = Integer.parseInt(data[1]);

            if (col < 1 || col > 10) {
                throw new WrongInputException(ERROR_MSG);
            }
            return new CellData(line, col);
        } catch (NumberFormatException e) {
            throw new WrongInputException(ERROR_MSG);
        }
    }
}
