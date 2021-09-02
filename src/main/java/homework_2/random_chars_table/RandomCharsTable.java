package homework_2.random_chars_table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RandomCharsTable {

    public void run() {
        System.out.println("Please, enter array length, array width and strategy (odd or even):");
        String input = setInput();
        if (isValid(input)) {
            char[][] randomCharsTable = new RandomCharsTableCreator(getRows(input), getColumns(input)).createTable();
            ArrayList<Character> selectedChars = findSelectedChars(randomCharsTable, isEven(input));
            printTable(randomCharsTable);
            printSelection(selectedChars, isEven(input));
        } else {
            System.out.println("Passed parameters should match the format [positive integer] [positive integer] [even|odd]");
        }
    }

    protected String setInput() {
        try(BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in))) {
            return br.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    private boolean isValid(String inputString) {
        if(inputString == null) {
            return false;
        }
         return inputString.matches("\\d+ \\d+ (odd|even)");
    }

    private int getRows(String inputString) {
        return Integer.parseInt(inputString.split(" ")[0]);
    }

    private int getColumns(String inputString) {
        return Integer.parseInt(inputString.split(" ")[1]);
    }

    private boolean isEven(String inputString) {
        return inputString.split(" ")[2].equals("even");
    }

    private ArrayList<Character> findSelectedChars(char[][] table, boolean isEven) {
        ArrayList<Character> selectedChars = new ArrayList<>();
        for (char[] row : table) {
            for (char ch : row) {
                if ((isEven && ch % 2 == 0) || (!isEven && ch % 2 == 1)) {
                    selectedChars.add(ch);
                }
            }
        }
        return selectedChars;
    }

    private void printTable(char[][] table) {
        for (char[] row : table) {
            System.out.print("|");
            for (char ch : row) {
                System.out.print(ch + "|");
            }
            System.out.println();
        }
    }

    private void printSelection(ArrayList<Character> selectedChars, boolean isEven) {
        if (isEven) {
            System.out.print("Even letters - ");
        } else {
            System.out.print("Odd letters - ");
        }
        String letters = selectedChars.toString();
        System.out.println(letters.substring(1, letters.length() - 1));
    }
}
