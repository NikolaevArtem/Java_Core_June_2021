package homework_2.random_chars_table;

import homework_2.ConsoleSafeReader;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RandomCharsTable {

    final static String GREETING = "Enter parameters of a table match the format " +
            "[positive integer] [positive integer] [even|odd]";
    final static String ERROR = "Passed parameters should match the format " +
            "[positive integer] [positive integer] [even|odd]";
    private int length;
    private int width;
    private String strategy;

    public void run() {
        System.out.println(GREETING);
        String input = ConsoleSafeReader.read();
        String res = isValidInput(input) ? processData() : ERROR;
        System.out.println(res);
    }

    private boolean isValidInput(String input) {
        try {
            if (input.matches("\\d+ \\d+ \\w+")) {
                String[] data = input.split(" ");
                length = Integer.parseInt(data[0]);
                width = Integer.parseInt(data[1]);
                strategy = data[2];
            }
            return length > 0 &&
                    width > 0 &&
                    (strategy.equals("odd") || strategy.equals("even"));
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    private String processData() {
        char[][] table = RandomCharTableGenerator.randomCharTable(length, width, 'A', 'Z');
        StringBuilder result = new StringBuilder();
        int remainder;
        StringBuilder letters;
        if ("odd".equals(strategy)) {
            remainder = 1;
            letters = new StringBuilder("Odd letters -");
        } else {
            remainder = 0;
            letters = new StringBuilder("Even letters -");
        }
        int lettersCounter = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                result.append("| ")
                        .append(table[i][j])
                        .append(" ");

                if (table[i][j] % 2 == remainder) {
                    letters.append(" ").append(table[i][j]).append(",");
                    lettersCounter++;
                }

            }
            result.append("|\n");
        }
        if (lettersCounter == 0) {
            String noLetters = String.format("There are no %s letters in the table", strategy);
            letters = new StringBuilder(noLetters);
        } else {
            letters.deleteCharAt(letters.length() - 1);
        }
        result.append(letters);
        return result.toString();
    }
}
