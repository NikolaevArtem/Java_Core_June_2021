package homework_2.random_chars_table;

import homework_2.random_chars_table.exception.RandomCharsTableException;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static homework_2.random_chars_table.utils.Constants.ERROR_MESSAGE;
import static homework_2.random_chars_table.utils.Constants.MAX_CHAR;
import static homework_2.random_chars_table.utils.Constants.MIN_CHAR;
import static homework_2.random_chars_table.utils.Utils.getData;
import static homework_2.random_chars_table.utils.Utils.printMessage;
import static java.lang.System.lineSeparator;

public class RandomCharsTable {

    public void run() {
        try {
            String[] data = getData().split(" ");
            if (isValidData(data)) {
                showCharsTable(getNumber(data[0]), getNumber(data[1]), getStrategy(data[2]));
            } else {
                printMessage(ERROR_MESSAGE);
            }
        } catch (RandomCharsTableException e) {
            printMessage(ERROR_MESSAGE);
        }
    }

    private boolean isValidData(String[] data) {
        return data.length == 3;
    }

    private void showCharsTable(int rows, int columns, String strategy) {
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
                throw new RandomCharsTableException();
            }
        } catch (NumberFormatException e) {
            throw new RandomCharsTableException();
        }
        return number;
    }

    private String getStrategy(String line) throws RandomCharsTableException {
        if (line.toLowerCase().equals("odd") || line.toLowerCase().equals("even")) {
            return line.toLowerCase();
        } else {
            throw new RandomCharsTableException();
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