package homework_2.random_chars_table;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RandomCharsTable implements Runnable {

    public static final String WELCOME_MESSAGE;
    public static final String ENTER_PARAM_MESSAGE;
    public static final String ERROR_MESSAGE;
    public static final String REGEX;

    static {
        WELCOME_MESSAGE = "Welcome to the Random Chars Table Application";
        ENTER_PARAM_MESSAGE = "Enter in one line 2 numbers and a line - " +
                "the length and width of the table / two-dimensional array," +
                " and the strategy (even or odd)";
        ERROR_MESSAGE = "Passed parameters should match the format " +
                "[positive integer] [positive integer] [even|odd]";
        REGEX = "\\s*[1-9]\\s+[1-9]\\s+(even|odd){1}$";
    }

    Pattern pattern = Pattern.compile(REGEX);

    @Override
    public void run() {
        startGreeting();
        String consoleString = readConsoleString();
        solveTask(consoleString);
    }

    private void startGreeting() {
        System.out.println(WELCOME_MESSAGE);
        System.out.println(ENTER_PARAM_MESSAGE);
    }

    private String readConsoleString() {
        Scanner scanner = new Scanner(System.in);
        String consoleString = scanner.nextLine();
        scanner.close();
        return consoleString;
    }

    private void printOddCapitalLetters(char[][] table) {
        List<Character> oddChars = new ArrayList<>();
        for (char[] line : table) {
            for (char column : line) {
                if (column % 2 != 0) {
                    oddChars.add(column);
                }
            }
        }
        System.out.println("Odd letters - "
                + oddChars.toString().replaceAll("[\\[\\]]", ""));
    }

    private void printEvenCapitalLetters(char[][] charsTable) {
        List<Character> evenChars = new ArrayList<>();
        for (char[] line : charsTable) {
            for (char column : line) {
                if (column % 2 == 0) {
                    evenChars.add(column);
                }
            }
        }
        System.out.println("Even letters - "
                + evenChars.toString().replaceAll("[\\[\\]]", ""));
    }


    private void printCapitalLetters(char[][] charsTable, String strategy) {
        if (strategy.equalsIgnoreCase("odd")) {
            printOddCapitalLetters(charsTable);
        } else if (strategy.equalsIgnoreCase("even")) {
            printEvenCapitalLetters(charsTable);
        } else {
            System.out.println(ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
    private void printTable(char[][] charsTable) {
        for (char[] line : charsTable) {
            System.out.print("| ");
            for (char column : line) {
                System.out.print(column + " | ");
            }
            System.out.println();
        }
    }

    private void solveTask(String consoleString) {
        if (pattern.matcher(consoleString).matches()) {
            String[] consoleStringArr = consoleString.split(" ");
            int height = Integer.parseInt(consoleStringArr[0]);
            int width = Integer.parseInt(consoleStringArr[1]);
            String strategy = consoleStringArr[2];
            char[][] charsTable = new RandomCharsTableCreator().createRandomCharsTable(height, width);
            printTable(charsTable);
            printCapitalLetters(charsTable, strategy);
        } else {
            System.out.println(ERROR_MESSAGE);
        }
    }
}
