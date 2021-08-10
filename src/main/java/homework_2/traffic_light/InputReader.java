package homework_2.traffic_light;

import homework_2.WrongInputException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
    private final String ERROR_MSG_DAY_IS_OVER = "The day is over";
    private final String ERROR_MSG = "Only 1 non-negative integer is allowed as passed parameter";
    private final int MAX_VALUE_OF_SECS = 86399;

    protected int readSecs() throws IOException, WrongInputException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            return parseInput(input);
        }
    }

    private int parseInput(String input) throws WrongInputException {
        try {
            int light = Integer.parseInt(input);

            if (light < 0) {
                throw new WrongInputException(ERROR_MSG);
            }
            if (light > MAX_VALUE_OF_SECS) {
                throw new WrongInputException(ERROR_MSG_DAY_IS_OVER);
            }

            return light;

        } catch (NumberFormatException e) {
            throw new WrongInputException(ERROR_MSG);
        }
    }
}
