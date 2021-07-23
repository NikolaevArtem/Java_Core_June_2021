package homework_2.random_chars_table;

import lombok.Data;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RandomCharsTable {
    private static int length;
    private static int width;

    protected static void run() {
        System.out.println("Enter valid table length, width and strategy(even or odd) in format \"length width strategy\" ");
        getParameters();
    }

    private static void getParameters() {
        try (Scanner scanner = new Scanner(System.in)) {
            length = scanner.nextInt();
            width = scanner.nextInt();
            String strategy = scanner.next();
            checkLengthAndWidth(length, width);
            checkStrategyValid(strategy);
            char[][] table = new char[length][width];
            fillAndPrintTable(strategy, table);
        } catch (NegativeArraySizeException e) {
            System.out.println("Array size cannot be negative.");
        } catch (InputMismatchException e) {
            System.out.println("Input parameters must be in the format [positive integer(>0)] [positive integer(>0)] [even|odd]");
        }
    }

    private static void checkLengthAndWidth(int length, int width) {
        if (length == 0 || width == 0){
            throw new InputMismatchException();
        }
    }

    private static void fillAndPrintTable(String strategy, char[][] table) {
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                table[i][j] = (char) (random.nextInt((90 - 65) + 1) + 65);
                System.out.print("|" + table[i][j] + "|");
            }
            System.out.println();
        }
        checkStratAndExecute(strategy, table);
    }

    private static void checkStrategyValid(String strategy) {
        if (!strategy.equals("even") && !strategy.equals("odd")) {
            throw new InputMismatchException();
        }
    }

    private static void checkStratAndExecute(String strategy, char[][] table) {
        if (strategy.equals("even")) {
            System.out.print("Even letters - ");
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    if (table[i][j] % 2 == 0) {
                        System.out.print(table[i][j] + " ");
                    }
                }
            }
        } else if (strategy.equals("odd")) {
            System.out.print("Odd letters - ");
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    if (table[i][j] % 2 != 0) {
                        System.out.print(table[i][j] + " ");
                    }
                }
            }
        }
    }
}
