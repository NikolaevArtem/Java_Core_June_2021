package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.lineSeparator;

public class PyramidPrinter {
    private static final String LETTER = "x";
    private static final String INFO_MESSAGE = "Please enter a positive integer for rows";
    private static final String ERROR_MESSAGE = "Something went wrong. Please restart the program!";

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int rows = -1;
            while (rows == -1) {
                printMessage(INFO_MESSAGE);
                String line = reader.readLine();
                rows = isValidNumber(line) ? Integer.parseInt(line) : -1;
            }
            generatePyramid(rows);
        } catch (IOException e) {
            printMessage(ERROR_MESSAGE);
        }
    }

    private boolean isValidNumber(String number) {
        try {
            if (Integer.parseInt(number) < 1) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private void generatePyramid(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                printMessage(LETTER);
            }
            printMessage(lineSeparator());
        }
    }

    private void printMessage(String text) {
        System.out.print(text);
    }
}