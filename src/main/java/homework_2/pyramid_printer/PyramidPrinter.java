package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {

    public static final String ERROR_MESSAGE = "Only 1 non-negative integer is allowed as passed parameter";
    public static final String START_MESSAGE = "Please, input number:";
    private int pyramidSize;

    public void run() {
        System.out.println(START_MESSAGE);
        if (validation()) {
            printPyramid();
        } else {
            System.out.println(ERROR_MESSAGE);
        }
    }

    private boolean validation() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            pyramidSize = Integer.parseInt(br.readLine());
        } catch (NumberFormatException | IOException ex) {
            return false;
        }
        return pyramidSize >= 0;
    }

    private void printPyramid() {
        for (int i = 1; i <= pyramidSize; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }
}
