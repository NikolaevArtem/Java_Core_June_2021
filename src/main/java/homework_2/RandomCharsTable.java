package homework_2;

import java.io.IOException;
import java.util.Random;

import static homework_2.IOMod.*;

public class RandomCharsTable {

    private static final int randMinValue = 65; // A
    private static final int randMaxValue = 90; // Z
    private static boolean strategy;
    private static String result = "";

    public static void main(String[] args) throws IOException {
        System.out.println("Input table length, table width, table strategy (even/odd):");
        String s = bufferedReaderStringReader();
        String[] parameters = s.split(" ");
        int table_length = Integer.parseInt(parameters[0]);
        int table_width = Integer.parseInt(parameters[1]);
        if ("odd".equalsIgnoreCase(parameters[2])) {
            strategy = false;
        } else if ("even".equalsIgnoreCase(parameters[2])) {
            strategy = true;
        } else {
            System.out.println(ANSI_YELLOW + "WARNING: " + ANSI_RESET +
                    "Wrong strategy value.\tYou should use only \"even\" or \"odd\" !");
            return;
        }

        printRandomABC(table_length, table_width);
        printResult();
    }

    private static void printRandomABC(int length, int width) {
        Character[][] randAbc = new Character[length][width];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                randAbc[i][j] = (char) (random.nextInt((randMaxValue - randMinValue) + 1) + randMinValue);
                System.out.print(randAbc[i][j] + " ");
                // result generating on-the-go
                resultGen(randAbc[i][j]);
            }
            System.out.println();
        }
    }

    private static void resultGen(char ch) {
        if (strategy) {
            if ((ch % 2) == 0) { // even
                // add if result doesn't contains value
                if (!result.contains(String.valueOf(ch))) {
                    result += ch;
                }
            }
        } else {
            if ((ch % 2) == 1) { // odd
                if (!result.contains(String.valueOf(ch))) {
                    result += ch;
                }
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
