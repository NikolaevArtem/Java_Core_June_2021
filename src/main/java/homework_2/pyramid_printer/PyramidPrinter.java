package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public final class PyramidPrinter {

    private int inputInt;

    public void run() {
        try {
            readFromConsole();
            printPyramid();
       } catch (Exception e) {
            System.out.println("\u001B[31m" + "Only 1 non-negative integer is allowed as passed parameter" + "\u001B[0m");
        }
    }

    private void readFromConsole() throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.printf("Enter int value from 0 - %s: ", Integer.MAX_VALUE);
            String inputString = reader.readLine();
            inputInt = validateInput(inputString);
        }
    }

    private int validateInput(String inputString) throws IllegalArgumentException {
        if (!inputString.matches("^\\d+$") || inputString.matches("0")) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(inputString);
    }

    private void printPyramid() {
        StringJoiner joiner = new StringJoiner("\r\n");
        String outputString = "x";
        for (int i = 0; i < inputInt; i++) {
            joiner.add(outputString);
            outputString = outputString + "x";
        }
        System.out.println(joiner);
    }

}