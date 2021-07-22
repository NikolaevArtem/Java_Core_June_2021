package homework_2.random_chars_table.sources;

import java.util.Random;

import static homework_2.IOMod.*;

public class RandomCharsTable {

    private static final int RAND_MIN_VALUE = 65; // A
    private static final int RAND_MAX_VALUE = 90; // Z
    private static boolean strategy; // even/odd
    private static StringBuilder result = new StringBuilder();

    public void run() {
        inputData();
    }

    private void inputData() {
        System.out.print("Input table length, table width, table strategy (even/odd): ");
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
            if (parameters[2].equalsIgnoreCase("odd")) {
                strategy = false;
            } else if (parameters[2].equalsIgnoreCase("even")) {
                strategy = true;
            } else {
                System.out.println(FORMAT_ERROR);
                return;
            }
            printRandomABC(tableLength, tableWidth);
            printResult();
        } catch (NumberFormatException | NullPointerException ex) {
            System.out.println(FORMAT_ERROR);
        }
    }

    private static void printRandomABC(int length, int width) {
        Character[][] randAbc = new Character[length][width];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                randAbc[i][j] = (char) (random.nextInt((RAND_MAX_VALUE - RAND_MIN_VALUE) + 1) + RAND_MIN_VALUE);
                System.out.print(randAbc[i][j] + " ");
                // result generating on-the-go
                resultGen(randAbc[i][j]);
            }
            System.out.println();
        }
    }

    private static void resultGen(char ch) {
        if (strategy && (ch % 2) == 0) { //even
            // add if result doesn't contains value
            if (!String.valueOf(result).contains(String.valueOf(ch))) {
                result.append(ch);
            }
        } else if (!strategy && (ch % 2) == 1) { // odd
            if (!String.valueOf(result).contains(String.valueOf(ch))) {
                result.append(ch);
            }
        }
    }

    private static void printResult() {
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
