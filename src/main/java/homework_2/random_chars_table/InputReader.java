package homework_2.random_chars_table;

import homework_2.WrongInputException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
    private final String ERROR_MSG = "Passed parameters should match the format " +
            "[positive integer] [positive integer] [even|odd]";

    protected Table readTableParams() throws IOException, WrongInputException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            return parseInput(input);
        }
    }

    private Table parseInput(String input) throws WrongInputException {
        String[] params = input.split(" +");
        try {
            if (params.length == 3) {
                int height = Integer.parseInt(params[0]);
                int width = Integer.parseInt(params[1]);
                StrategyCharacterSet.Strategy strategy = StrategyCharacterSet.Strategy.valueOf(params[2].toUpperCase());

                if (width > 0 && height > 0) {
                    return new Table(width, height, strategy);
                } else {
                    throw new WrongInputException(ERROR_MSG);
                }
            } else {
                throw new WrongInputException(ERROR_MSG);
            }
        } catch (IllegalArgumentException e) {
            throw new WrongInputException(ERROR_MSG);
        }
    }
}
