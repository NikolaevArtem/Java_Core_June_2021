package homework_2;

import java.io.IOException;
import java.util.Scanner;

public class RandomCharsTable {
    public static void main(String[] args) {
        randomCharsTable();
    }

    private static void randomCharsTable() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please type size of a table: 2 numbers and strategy: even or odd");

            int lengthOfTable = scanner.nextInt();
            int widthOfTable = scanner.nextInt();
            String strategy = scanner.next();

            char[][] randomCharsTable = new char[lengthOfTable][widthOfTable];

            int min = 'A';
            int max = 'Z';
            for (int i = 0; i < lengthOfTable; i++) {
                for (int j = 0; j < widthOfTable; j++) {
                    randomCharsTable[i][j] = (char) ((int) (Math.random() * (max - min + 1) + min));
                    System.out.print(randomCharsTable[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
