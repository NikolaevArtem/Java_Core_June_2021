package homework_2.random_chars_table;

import javax.xml.bind.ValidationException;
import java.util.Random;

import static homework_2.IOMod.*;

public class RandomCharsTable {

    private static final int RAND_MIN_VALUE = 65; // A
    private static final int RAND_MAX_VALUE = 90; // Z

    public void run() {
        inputData();
    }

    private void inputData() {
        System.out.print("Input table length, table width, table strategy(even/odd): ");
        try {
            String s = bufferedReaderStringReader();
            String[] parameters = s.split(" ");
            if (!isInputValid(parameters)) {
                throw new ValidationException("");
            }
            int tableLength = Integer.parseInt(parameters[0]);
            int tableWidth = Integer.parseInt(parameters[1]);
            boolean strategy = parameters[2].equalsIgnoreCase("even");

            printRandomAndGenerateResult(tableLength, tableWidth, strategy);
        } catch (NullPointerException | ValidationException e) {
            System.out.println(FORMAT_ERROR);
            return;
        }
    }

    private boolean isInputValid(String[] parameters) {
        if (parameters.length == 3) {
            return parameters[0].chars().allMatch(Character::isDigit) &&
                    !parameters[0].equals("0") &&
                    parameters[1].chars().allMatch(Character::isDigit) &&
                    !parameters[1].equals("0") &&
                    (parameters[2].equalsIgnoreCase("odd") || parameters[2].equalsIgnoreCase("even"));
        }
        return false;
    }

    private void printRandomAndGenerateResult(int length, int width, boolean strategy) {
        Character[][] randAbc = new Character[length][width];
        Random random = new Random();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            System.out.print("| ");
            for (int j = 0; j < width; j++) {
                randAbc[i][j] = (char) (random.nextInt((RAND_MAX_VALUE - RAND_MIN_VALUE) + 1) + RAND_MIN_VALUE);
                System.out.print(randAbc[i][j] + " | ");

                // result generating on-the-go
                generateResult(strategy ? 0 : 1, randAbc[i][j], result);
            }
            System.out.println();
        }
        printResult(strategy, result);
    }

    private void generateResult(int strategy, char ch, StringBuilder result) {
        if ((ch % 2 == strategy) && (!String.valueOf(result).contains(String.valueOf(ch)))) {
            result.append(ch);
        }
    }

    private void printResult(boolean strategy, StringBuilder result) {
        if (result.length() == 0) {
            return;
        }
        if (strategy) {
            System.out.print("Even letters - ");
        } else {
            System.out.print("Odd letters - ");
        }
        int i = 0;
        while (true) {
            if (i == result.length() - 1) {
                System.out.print(result.charAt(i));
                break;
            }
            System.out.print(result.charAt(i) + ", ");
            i++;
        }
    }

}
