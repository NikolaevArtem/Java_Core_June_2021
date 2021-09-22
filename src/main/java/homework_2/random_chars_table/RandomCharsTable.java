package homework_2.random_chars_table;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RandomCharsTable {

    private int length;
    private int width;
    private String strategy;

    public void run() {
        createTableWithRandomCharacters();
    }

    private void createTableWithRandomCharacters() {
        System.out.println("Enter valid table length, width and strategy(even or odd) in format \"length width strategy\" ");
        inputData();
        checkLengthAndWidth(length, width);
        checkStrategyValid(strategy);
        fillAndPrintTable(strategy, getTable());
    }

    private char[][] getTable() {
        return new char[length][width];
    }

    private void inputData() {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] input = scanner.nextLine().split(" ");
            length = Integer.parseInt(input[0]);
            width = Integer.parseInt(input[1]);
            strategy = input[2];
        } catch (NegativeArraySizeException | InputMismatchException | NumberFormatException e) {
            System.out.println("Passed parameters should match the format [positive integer] [positive integer] [even|odd]");
        }
    }

    private void checkLengthAndWidth(int length, int width) {
        if (length == 0 || width == 0) {
            throw new InputMismatchException();
        }
    }

    private void fillAndPrintTable(String strategy, char[][] table) {
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                table[i][j] = (char) (random.nextInt(((90 - 65) + 1)) + 65);
                System.out.print("|" + table[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
        checkStrategyAndExecute(strategy, table);
    }

    private void checkStrategyValid(String strategy) {
        if (!strategy.equals("even") && !strategy.equals("odd")) {
            throw new InputMismatchException();
        }
    }

    private void checkStrategyAndExecute(String strategy, char[][] table) {
        StringBuilder str = new StringBuilder();
        if (strategy.equals("even")) {
            System.out.print("Even letters - ");
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    if (table[i][j] % 2 == 0) {
                        str.append(table[i][j]).append(", ");
                    }
                }
            }
        } else {
            System.out.print("Odd letters - ");
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    if (table[i][j] % 2 != 0) {
                        str.append(table[i][j]).append(", ");
                    }
                }
            }
        }
        if (str.length() > 2) {
            System.out.print(str.substring(0, str.length() - 2));
        }
    }
}
