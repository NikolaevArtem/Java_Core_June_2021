package homework_2.random_chars_table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RandomCharsTable {

    public static final String ERROR_MESSAGE = "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";
    public static final String START_MESSAGE = "Please, enter array length, array width and strategy (odd or even):";
    private boolean isEven;
    int rows, columns;
    private char[][] randomCharsTable;
    private final ArrayList<Character> selectedChars = new ArrayList<>();

    public void run() {
        System.out.println(START_MESSAGE);
        if (validation()) {
            randomCharsTable = new RandomCharsTableCreator(rows, columns).createTable();
            findSelectedChars();
            printTable();
            printSelection();
        } else {
            System.out.println(ERROR_MESSAGE);
        }
    }

    private boolean validation() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputValues = br.readLine().split(" ");
            if (inputValues.length != 3) {
                return false;
            }
            rows = Integer.parseInt(inputValues[0]);
            columns = Integer.parseInt(inputValues[1]);
            if (rows <= 0 || columns <= 0 ||
                    (!inputValues[2].equals("even") && !inputValues[2].equals("odd"))) {
                return false;
            }
            isEven = inputValues[2].equals("even");
        } catch (IOException | NumberFormatException e) {
            return false;
        }
        return true;
    }

    private void findSelectedChars() {
        for (char[] row : randomCharsTable) {
            for (char ch : row) {
                if ((isEven && (int) ch % 2 == 0) || (!isEven && (int) ch % 2 == 1)) {
                    selectedChars.add(ch);
                }
            }
        }
    }

    private void printTable() {
        for (char[] row : randomCharsTable) {
            System.out.print("|");
            for (char ch : row) {
                System.out.print(ch + "|");
            }
            System.out.println();
        }
    }

    private void printSelection() {
        if (isEven) {
            System.out.print("Even letters - ");
        } else {
            System.out.print("Odd letters - ");
        }
        String letters = selectedChars.toString();
        System.out.println(letters.substring(1, letters.length() - 1));
    }
}
