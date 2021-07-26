package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {

    private final String ERROR = "Only 1 non-negative integer is allowed as passed parameter";

    public void run() {
        System.out.println("Please, input a number:");
        int input = consoleReader();
        if (negativeInput(input)) {
            System.out.println(ERROR);
        } else if (input == 0) {
            System.out.println();
        } else {
            printResult(input);
        }
    }

    private int consoleReader() {
        try (BufferedReader bF = new BufferedReader(new InputStreamReader(System.in))) {
            return Integer.parseInt(bF.readLine());
        } catch (NumberFormatException | IOException exception) {

        }
        return -1;
    }

    private void printResult(int input) {
        String output = "";
        for (int i = 0; i < input; i++) {
            output += "x";
            System.out.println(output);
        }
    }

    private boolean negativeInput(int n) {
        return n < 0;
    }
}
