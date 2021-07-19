package homework_2.random_chars_table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.System.lineSeparator;

public class RandomCharsTable {
    private static final int MAX_CHAR = 90;
    private static final int MIN_CHAR = 65;
    private static final String INFO_MESSAGE_FOR_COLUMNS = "Enter a positive integer for columns: ";
    private static final String INFO_MESSAGE_FOR_ROWS = "Enter a positive integer for rows: ";
    private static final String INFO_MESSAGE_FOR_STRATEGY = "Enter the word \"odd\" or \"even\" without quotes for strategy: ";
    private static final String INTEGER_ERROR_MESSAGE = "It was not a positive integer. Please try again: ";
    private static final String ERROR_MESSAGE = "Something went wrong. Please restart the program!";
    private static final String STRATEGY_ERROR_MESSAGE = "It was not a word \"odd\" or \"even\"! Please try again: ";

    public void run() {
        int columns = -1;
        int rows = -1;
        String strategy = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            printMessage(INFO_MESSAGE_FOR_COLUMNS);
            while (columns == -1) {
                line = reader.readLine();
                columns = isValidNumber(line) ? Integer.parseInt(line) : -1;
            }
            printMessage(INFO_MESSAGE_FOR_ROWS);
            while (rows == -1) {
                line = reader.readLine();
                rows = isValidNumber(line) ? Integer.parseInt(line) : -1;
            }
            printMessage(INFO_MESSAGE_FOR_STRATEGY);
            while (strategy.equals("")) {
                line = reader.readLine();
                strategy = isOddOrEven(line) ? line : "";
            }
            showCharsTable(columns, rows, strategy);
        } catch (IOException e) {
            printMessage(ERROR_MESSAGE);
        }
    }

    private void showCharsTable(int columns, int rows, String strategy) {
        Set<Character> charsByStrategySet = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            printMessage("|");
            for (int j = 0; j < columns; j++) {
                char ch = getRandomChar();
                if (isCharFitsStrategy(ch, strategy)) {
                    charsByStrategySet.add(ch);
                }
                printMessage(ch + "|");
            }
            printMessage(lineSeparator());
        }
        printMessage(getFormattedStringForPrinting(strategy, charsByStrategySet));
    }

    private char getRandomChar() {
        return (char) ThreadLocalRandom.current().nextInt(MIN_CHAR, MAX_CHAR + 1);
    }

    private boolean isValidNumber(String number) {
        try {
            if (Integer.parseInt(number) < 1) {
                printMessage(INTEGER_ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            printMessage(INTEGER_ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean isOddOrEven(String line) {
        if (line.toLowerCase().equals("odd") || line.toLowerCase().equals("even")) {
            return true;
        }
        printMessage(STRATEGY_ERROR_MESSAGE);
        return false;
    }

    private boolean isCharFitsStrategy(char ch, String strategy) {
        return strategy.equals("even") == (ch % 2 == 0);
    }

    private String getFormattedStringForPrinting(String strategy, Set<Character> letters) {
        String capFirst = strategy.substring(0, 1).toUpperCase() + strategy.substring(1);
        StringBuilder result = new StringBuilder(capFirst + " letters - ");
        for (Character ch : letters) {
            result.append(ch).append(", ");
        }
        return result.substring(0, result.toString().trim().length() - 1);
    }

    private void printMessage(String text) {
        System.out.print(text);
    }
}