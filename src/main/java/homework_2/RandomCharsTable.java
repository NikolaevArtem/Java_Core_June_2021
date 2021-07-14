package homework_2;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.LinkedList;

public class RandomCharsTable {
    static int rows;
    static int columns;
    static String strategy;
    static int remains;
    static LinkedList<Character> list;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter length and width of the table, also choose even or odd letters (<Ctrl + D> or <Ctrl + Z> to exit): ");

        while (scan.hasNext()) {
            try {
                rows = scan.nextInt();
                columns = scan.nextInt();
                strategy = scan.next();
                validateInput(rows, columns, strategy);
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Input doesn't correspond to \"number number string\" format");
            }

            if (strategy.equals("even")) {
                remains = 0;
            } else {
                remains = 1;
            }

            printTable();
            printLetters();

            System.out.print("\nEnter length and width of the table, also choose even or odd letters (<Ctrl + D> or <Ctrl + Z> to exit): ");
        }
        scan.close();
    }



    private static void validateInput(int r, int c, String s) {
        if (r <= 0) {
            throw new IllegalArgumentException("Illegal length value");
        }
        if (c <= 0) {
            throw new IllegalArgumentException("Illegal width value");
        }
        if (!s.equalsIgnoreCase("even") && !s.equalsIgnoreCase("odd")) {
            throw new IllegalArgumentException("Illegal type of letters");
        }
    }

    private static void printTable() {
        list = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            System.out.print("| ");
            for (int j = 0; j < columns; j++) {
                char ch = (char) (Math.round(Math.random() * 25) + 65);
                if (ch % 2 == remains && !list.contains(ch)) {
                    list.add(ch);
                }
                System.out.print(ch + " | ");
            }
            System.out.println();
        }
    }

    private static void printLetters() {
        System.out.print(strategy + " letters - ");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.println(list.get(i));
            } else {
                System.out.print(list.get(i) + ", ");
            }
        }
    }
}
