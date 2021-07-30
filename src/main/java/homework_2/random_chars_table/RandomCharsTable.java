package homework_2.random_chars_table;

import java.util.Random;
import java.util.Scanner;

public class RandomCharsTable {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter number of rows, number of columns and strategy:");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (x < 0 || y < 0) {
                System.out.println("Wrong number of rows & columns");
            } else {
                String strategy = scanner.next();
                char[][] table = createRandomTable(x, y);
                printTable(table, x, y);
                printStrategyChars(table, x, y, strategy);
            }
        } catch (Exception e) {
            System.out.println("Invalid value");
        }
        scanner.close();
    }

    private static char[][] createRandomTable(int x, int y) {
        char[][] table = new char[x][y];
        Random random = new Random();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                table[i][j] = (char) (random.nextInt((90 - 65) + 1) + 65);
            }
        }
        return table;
    }

    private static void printTable(char[][] table, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(" | " + table[i][j] + " | ");
            }
            System.out.println();
        }
    }

    private static void printStrategyChars(char[][] table, int x, int y, String strategy) {
        if (strategy.equals("even")) {
            System.out.print("Even chars: ");
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (table[i][j] % 2 == 0) {
                        System.out.print(table[i][j] + " ");
                    }
                }
            }
        } else if (strategy.equals("odd")) {
            System.out.print("Odd chars: ");
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (table[i][j] % 2 != 0) {
                        System.out.print(table[i][j] + " ");
                    }
                }
            }
        } else {
            System.out.println("You entered wrong strategy");
        }
    }
}
