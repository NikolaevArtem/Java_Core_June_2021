package homework_2.random_chars_table;

import java.util.ArrayList;
import java.util.List;

public class PrintChars {

    void print(char[][] table, String strategy) {
        if (strategy.equalsIgnoreCase("even")) {
            printEvenChars(table);
        } else if (strategy.equalsIgnoreCase("odd")) {
            printOddChars(table);
        } else {
            throw new IllegalArgumentException();
        }
    }

    void print(char[][] chars) {
        for (char[] row : chars) {
            System.out.print("| ");
            for (char column : row) {
                System.out.print(column + " | ");
            }
            System.out.println();
        }
    }

    void printEvenChars(char[][] table) {
        List<Character> evenChars = new ArrayList<>();
        for (char[] row : table) {
            for (char column : row) {
                if (column % 2 == 0) {
                    evenChars.add(column);
                }
            }
            System.out.println("Even letters - "
                    + evenChars.toString().replaceAll("[\\[\\]]", ""));
        }
    }

    void printOddChars(char[][] table) {
        List<Character> evenChars = new ArrayList<>();
        for (char[] row : table) {
            for (char column : row) {
                if (column % 2 != 0) {
                    evenChars.add(column);
                }
            }
            System.out.println("Even letters - "
                    + evenChars.toString().replaceAll("[\\[\\]]", ""));
        }
    }

}
