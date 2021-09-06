package homework_5.power_of_number;

import homework_2.WrongInputException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
    private final String ERROR_MSG = "Only 2 non-negative integers are allowed";

    protected int[] readParams() throws IOException, WrongInputException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            if (input == null) {
                throw new WrongInputException(ERROR_MSG);
            } else {
                return parseInput(input);
            }
        }
    }

    private int[] parseInput(String input) throws WrongInputException {
        String[] params = input.split(" +");
        try {
            if (params.length == 2) {
                int number = Integer.parseInt(params[0]);
                int power = Integer.parseInt(params[1]);

                if (power >= 0 && number >= 0) {
                    int[] paramsInt = new int[params.length];
                    for (int i = 0; i < params.length; i++) {
                        paramsInt[i] = Integer.parseInt(params[i]);
                    }
                    return paramsInt;
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
