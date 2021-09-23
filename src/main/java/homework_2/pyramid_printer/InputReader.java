package homework_2.pyramid_printer;

import homework_2.WrongInputException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
    private final String ERROR_MSG = "Only 1 non-negative integer is allowed as passed parameter";

    protected int readNum() throws WrongInputException, IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            return parseInput(input);
        }
    }

    private int parseInput(String input) throws WrongInputException {
        try {
            int num = Integer.parseInt(input);
            if (num < 0) {
                throw new WrongInputException(ERROR_MSG);
            }
            return num;
        } catch (NumberFormatException e) {
            throw new WrongInputException(ERROR_MSG);
        }
    }
}
