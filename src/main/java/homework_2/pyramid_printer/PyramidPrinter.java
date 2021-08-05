package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {

    private static final String ERROR = "Only 1 non-negative integer is allowed as passed parameter";

    public void run() {
        System.out.println("Please, input a number:");

        try {
            int countX = bufferedReaderReadConsole();
            validateInput(countX);
            printConsole(countX);
        } catch (IOException | IllegalArgumentException e) {
            System.out.println(ERROR);
        }
    }

    private void printConsole(int countX) {
        StringBuilder result = new StringBuilder("");
        for (int i = 1; i <= countX; i++) {
            for (int j = 0; j < i; j++) {
                result.append("x");
            }
            result.append("\n");
        }
        System.out.println(result);
    }

    private int bufferedReaderReadConsole() throws IOException, NumberFormatException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return Integer.parseInt(reader.readLine());
        }
    }

    private void validateInput(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
    }
}
