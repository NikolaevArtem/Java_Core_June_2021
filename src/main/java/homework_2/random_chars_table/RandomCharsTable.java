package homework_2.random_chars_table;

import java.util.Random;

import static homework_2.IOMod.*;

public class RandomCharsTable {

    private static final int RAND_MIN_VALUE = 65; // A
    private static final int RAND_MAX_VALUE = 90; // Z

    public void run() {
        inputData();
    }

    private void inputData() {
        System.out.print("Input table length, table width, table strategy(even/odd): ");
        String s = bufferedReaderStringReader();

        try {
            String[] parameters = s.split(" ");
            if (parameters.length != 3) {
                System.out.println(FORMAT_ERROR);
                return;
            }

            int tableLength = Integer.parseInt(parameters[0]);
            int tableWidth = Integer.parseInt(parameters[1]);
            if (tableLength <= 0 || tableWidth <= 0) {
                System.out.println(FORMAT_ERROR);
                return;
            }

            boolean strategy;
            if (parameters[2].equalsIgnoreCase("odd")) {
                strategy = false;
            } else if (parameters[2].equalsIgnoreCase("even")) {
                strategy = true;
            } else {
                System.out.println(FORMAT_ERROR);
                return;
            }

            printRandomAndGenerateResult(tableLength, tableWidth, strategy);
        } catch (NumberFormatException | NullPointerException ex) {
            System.out.println(FORMAT_ERROR);
        }
    }

    private void printRandomAndGenerateResult(int length, int width, boolean strategy) {
        // could be optimised for less memory usage with no creating Character[][] matrix
        // and just printing random char and then adding to result StringBuilder
        Character[][] randAbc = new Character[length][width];
        Random random = new Random();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                randAbc[i][j] = (char) (random.nextInt((RAND_MAX_VALUE - RAND_MIN_VALUE) + 1) + RAND_MIN_VALUE);
                System.out.print(randAbc[i][j] + " ");
                // result generating on-the-go
                if (strategy) {
                    generateEven(randAbc[i][j], result);
                } else {
                    generateOdd(randAbc[i][j], result);
                }
            }
            System.out.println();
        }
        printResult(strategy, result);
    }

    private void generateEven(char ch, StringBuilder result) {
        if ((ch % 2 == 0) && (!String.valueOf(result).contains(String.valueOf(ch)))) {
            result.append(ch);
        }
    }

    private void generateOdd(char ch, StringBuilder result) {
        if ((ch % 2 == 1) && (!String.valueOf(result).contains(String.valueOf(ch)))) {
            result.append(ch);
        }
    }

    private void printResult(boolean strategy, StringBuilder result) {
        if (strategy) {
            System.out.print("Even letters - ");
        } else {
            System.out.print("Odd letters - ");
        }
        int i = 0;
        while (i < result.length()) { // to avoid exception in a case when result.length() = 0 ;)
            if (i == result.length() - 1) {
                System.out.print(result.charAt(i));
                break;
            }
            System.out.print(result.charAt(i) + ", ");
            i++;
        }
    }

}
