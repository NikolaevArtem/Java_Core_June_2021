package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static homework_2.pyramid_printer.MessageType.ERROR_MESSAGE;
import static homework_2.pyramid_printer.MessageType.ERROR_WRONG_FORMAT_MESSAGE;
import static homework_2.pyramid_printer.MessageType.INFO_MESSAGE;
import static homework_2.pyramid_printer.Utils.printMessage;
import static java.lang.System.lineSeparator;

public class PyramidPrinter {
    private static final String LETTER = "x";

    public void start() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            printMessage(INFO_MESSAGE.getMessage());
            String line = reader.readLine();
            int rows = getNumber(line);
            generatePyramid(rows);
        } catch (IOException e) {
            printMessage(ERROR_MESSAGE.getMessage());
        } catch (PyramidPrinterException e) {
            printMessage(e.getMessage());
        }
    }

    private int getNumber(String text) throws PyramidPrinterException {
        int number;
        try {
            number = Integer.parseInt(text);
            if (number < 1) {
                throw new PyramidPrinterException(ERROR_WRONG_FORMAT_MESSAGE);
            }
        } catch (NumberFormatException e) {
            throw new PyramidPrinterException(ERROR_WRONG_FORMAT_MESSAGE);
        }
        return number;
    }

    private void generatePyramid(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                printMessage(LETTER);
            }
            printMessage(lineSeparator());
        }
    }
}