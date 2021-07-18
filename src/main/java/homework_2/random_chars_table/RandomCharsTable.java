package homework_2.random_chars_table;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RandomCharsTable {
    private static Scanner scanner = new Scanner(System.in);
    private static int length;
    private static int width;

    public static void main(String[] args) {
        System.out.println("Enter valid length, width and strategy in format \"length width strategy\" ");
        try {
            printRandomCharsTable();
        } catch (NegativeArraySizeException e) {
            System.out.println("Array size cannot be negative, try again.");
            System.out.println("Enter valid length, width and strategy in format \"length width strategy\" ");
            printRandomCharsTable();
        }
        scanner.close();
    }

    public static void printRandomCharsTable() throws NegativeArraySizeException {
        try {
            length = scanner.nextInt();
            width = scanner.nextInt();
            String strategy = scanner.next();
            char[][] table = new char[length][width];

            Random random = new Random();

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    table[i][j] = (char) (random.nextInt((90 - 65) + 1) + 65);
                    System.out.print("|" + table[i][j] + "|");
                }
                System.out.println();
            }
            checkStratAndExecute(strategy, table);
        } catch (InputMismatchException e) {
            System.out.println("You entered invalid value, try again.");
        }
    }

    private static void checkStratAndExecute(String strat, char[][] table) {
        if (strat.equals("even")) {
            System.out.print("Even letters - ");
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    if (table[i][j] % 2 == 0) {
                        System.out.print(table[i][j] + " ");
                    }
                }
            }
        } else if (strat.equals("odd")) {
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
