package homework_2.pyramid_printer;

import homework_2.pyramid_printer.exception.PyramidPrinterException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static homework_2.pyramid_printer.utils.PyramidPrinterConstants.ERROR_MESSAGE;
import static homework_2.pyramid_printer.utils.PyramidPrinterConstants.INFO_MESSAGE;
import static homework_2.pyramid_printer.utils.PyramidPrinterConstants.LETTER;

public class PyramidPrinter {

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(INFO_MESSAGE);
            String line = reader.readLine();
            int rows = getNumber(line);
            generatePyramid(rows);
        } catch (IOException | PyramidPrinterException e) {
            System.out.println(ERROR_MESSAGE);
        }
    }

    private int getNumber(String text) throws PyramidPrinterException {
        try {
            int number = Integer.parseInt(text);
            if (number < 0) {
                throw new PyramidPrinterException(ERROR_MESSAGE);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new PyramidPrinterException(ERROR_MESSAGE);
        }
    }

    private void generatePyramid(int rows) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(LETTER);
            }
            System.out.println();
        }
    }
}