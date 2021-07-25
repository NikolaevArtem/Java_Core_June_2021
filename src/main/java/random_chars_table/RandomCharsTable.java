package random_chars_table;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RandomCharsTable {

    public void run() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter parameters in following format: [positive integer] [positive integer] [even|odd]");

        try {
            String s = reader.readLine();
            String[] params = s.split(" ");

            int rows = Integer.parseInt(params[0]);
            int cols = Integer.parseInt(params[1]);
            String strategy = params[2];

            if (NumOfParamsIsOk(params) && StrategyIsOk(strategy) && isPositive(rows) && isPositive(cols)) {

                char[][] letters = getRandomLetters(rows, cols);
                printTable(letters);
                printStrategy(letters, strategy);

            } else {
                System.out.println("Passed parameters should match the format [positive integer] [positive integer] [even|odd]");
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException | IOException e) {
            System.out.println("Passed parameters should match the format [positive integer] [positive integer] [even|odd]");
        }
    }

    private static boolean isPositive(int num) {
        return num > 0;
    }

    private static boolean StrategyIsOk(String strategy) {
        return strategy.equals("even") || strategy.equals("odd");
    }

    private static boolean NumOfParamsIsOk(String[] params) {
        return params.length == 3;
    }

    private static char[][] getRandomLetters(int rows, int cols) {
        int minIndex = 65; //Char A index
        int maxIndex = 90; //Char Z index
        char[][] randomLettersTable = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                randomLettersTable[i][j] = (char) ((int) ((Math.random() * (maxIndex - minIndex)) + minIndex));
            }
        }
        return randomLettersTable;
    }

    private static void printTable(char[][] table) {
        for (char[] row : table) {
            StringBuilder s = new StringBuilder("|");
            for (char letter : row) {
                s.append(" ").append(letter).append(" |");
            }
            System.out.println(s);
        }
    }

    private static void printStrategy(char[][] table, String strategy) {
        StringBuilder output = new StringBuilder();

        if (strategy.equals("even")) {
            output.append("Even letters - ");
            for (char[] row : table) {
                for (char letter : row) {
                    if ((int) letter % 2 == 0) {
                        output.append(letter).append(", ");
                    }
                }
            }
        } else {
            output.append("Odd letters - ");
            for (char[] row : table) {
                for (char letter : row) {
                    if ((int) letter % 2 != 0) {
                        output.append(letter).append(", ");
                    }
                }
            }
        }
        System.out.println(output.substring(0, output.length() - 2));
    }
}
