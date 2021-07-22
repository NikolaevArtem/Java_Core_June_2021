package homework_2.random_chars_table;

import homework_2.random_chars_table.exception.RandomCharsTableException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static homework_2.random_chars_table.utils.MessageType.ERROR_MESSAGE;
import static homework_2.random_chars_table.utils.MessageType.INFO_MESSAGE_FOR_COLUMNS;
import static homework_2.random_chars_table.utils.MessageType.INFO_MESSAGE_FOR_ROWS;
import static homework_2.random_chars_table.utils.MessageType.INFO_MESSAGE_FOR_STRATEGY;
import static homework_2.random_chars_table.utils.MessageType.INTEGER_ERROR_MESSAGE;
import static homework_2.random_chars_table.utils.MessageType.STRATEGY_ERROR_MESSAGE;
import static homework_2.random_chars_table.utils.Utils.printMessage;
import static java.lang.System.lineSeparator;

public class RandomCharsTable {
    private static final int MAX_CHAR = 90;
    private static final int MIN_CHAR = 65;

    public void start() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            printMessage(INFO_MESSAGE_FOR_COLUMNS.getMessage());
            int columns = getNumber(reader.readLine());
            printMessage(INFO_MESSAGE_FOR_ROWS.getMessage());
            int rows = getNumber(reader.readLine());
            printMessage(INFO_MESSAGE_FOR_STRATEGY.getMessage());
            String strategy = getStrategy(reader.readLine());
            showCharsTable(columns, rows, strategy);
        } catch (IOException e) {
            throw new RandomCharsTableException(ERROR_MESSAGE);
        } catch (RandomCharsTableException e) {
            printMessage(e.getMessage());
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

    private int getNumber(String text) throws RandomCharsTableException {
        int number;
        try {
            number = Integer.parseInt(text);
            if (number < 1) {
                throw new RandomCharsTableException(INTEGER_ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            throw new RandomCharsTableException(INTEGER_ERROR_MESSAGE);
        }
        return number;
    }

    private String getStrategy(String line) throws RandomCharsTableException {
        if (line.toLowerCase().equals("odd") || line.toLowerCase().equals("even")) {
            return line.toLowerCase();
        } else {
            throw new RandomCharsTableException(STRATEGY_ERROR_MESSAGE);
        }
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
}