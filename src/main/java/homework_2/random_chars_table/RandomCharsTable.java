package homework_2.random_chars_table;

import java.util.Scanner;

public class RandomCharsTable {

    public void run() {
        System.out.print("Enter length, width of the table and choose even or odd letters: ");

        int rows;
        int columns;
        String strategy;
        try (Scanner scan = new Scanner(System.in)) {
            rows = scan.nextInt();
            columns = scan.nextInt();
            strategy = scan.nextLine().trim();
            validateInput(rows, columns, strategy);
        } catch (RuntimeException e) {
            System.out.println("Passed parameters should match the format " +
                               "[positive integer] [positive integer] [even|odd]");
            return;
        }

        TablePrinter tp = new TablePrinter(rows, columns, strategy);
        tp.printTable();
        tp.printLetters();
    }

    private void validateInput(int row, int column, String strategy) {
        if (row <= 0) {
            throw new IllegalArgumentException();
        }
        if (column <= 0) {
            throw new IllegalArgumentException();
        }
        if (strategy.split(" ").length > 1) {
            throw new IllegalArgumentException();
        }
        if (!"even".equalsIgnoreCase(strategy) && !"odd".equalsIgnoreCase(strategy)) {
            throw new IllegalArgumentException();
        }
    }
}
