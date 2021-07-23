package homework_2.RandomCharsTable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringJoiner;

public final class RandomCharsTable {

    private int length;
    private int width;
    private String strategy;
    private static final String ERROR_MESSAGE = "\u001B[31m" + "Passed parameters should match the format [positive integer] [positive integer] [even|odd]" + "\u001B[0m";

    public void run() {
        try {
            if (readFromConsole()) {
                printArray();
            }
        } catch (Exception e) {
            System.out.println(ERROR_MESSAGE);
        }
    }

    private boolean readFromConsole() throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter value in format [positive integer] [positive integer] [even|odd]: ");
            return validateInput(reader.readLine());
        }
    }

    private boolean validateInput(String inputString) throws IllegalArgumentException {

        if (inputString.matches("\\s*[1-9]\\s+[1-9]\\s+(even|odd){1}$")) {
            String[] paramArray = inputString.split("\\s+");
            length = Integer.parseInt(paramArray[0]);
            width = Integer.parseInt(paramArray[1]);
            strategy = paramArray[2];
            return true;
        } else {
            System.out.println(ERROR_MESSAGE);
            return false;
        }
    }

    private void printArray() {

        StringJoiner joiner = new StringJoiner(",");
        StringBuilder tableOutput = new StringBuilder();

        Random rand = new Random();
        char[] alphabetLetters = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                int randomIndex = rand.nextInt(alphabetLetters.length);
                char letter = alphabetLetters[randomIndex];
                if (strategyMatch(letter)) {
                    joiner.add("" + letter);
                }
                tableOutput.append("|").append(letter);
            }
            tableOutput.append("|").append("\n\r");
        }
        String lastRow = String.format("%s%s letters - %s", strategy.substring(0,1).toUpperCase(), strategy.substring(1), joiner);
        System.out.println(tableOutput + lastRow);
    }

    private boolean strategyMatch(char charItem) {
        return (strategy.equals("even") && charItem % 2 == 0) || (strategy.equals("odd") && charItem % 2 != 0);
    }

}
