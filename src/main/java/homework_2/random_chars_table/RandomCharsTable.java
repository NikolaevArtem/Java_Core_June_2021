package homework_2.random_chars_table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RandomCharsTable {

    public static final String ERROR = "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";

    private int length;
    private int width;
    private String strategy;

    private String strategyEven = "Even letters -";
    private String strategyOdd = "Odd letters -";

    public void run() {

        System.out.println("[Input example: 2 3 odd]");
        System.out.println("Please, input 2 positive numbers and a strategy (even/odd)");

        String inputFull = bufferedReaderReadConsole();
        try {
            parseInput(inputFull);
            validateInputData(length, width, strategy);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR);
            return;
        }

        char[][] table = new char[length][width];

        for (int i = 0; i < length; i++) {
            System.out.print("|");

            for (int j = 0; j < width; j++) {
                int x = (int) (Math.random() * 26 + 65);
                table[i][j] = (char) x;
                if (x % 2 == 0) {
                    strategyEven = strategyEven + " " + table[i][j] + ",";
                } else {
                    strategyOdd = strategyOdd + " " + table[i][j] + ",";
                }
                System.out.print(" " + table[i][j] + " |");
            }

            System.out.println();
        }

        strategyOdd = deleteLastCommaInStrategy(strategyOdd);
        strategyEven = deleteLastCommaInStrategy(strategyEven);

        if (strategy.equals("even")) {
            System.out.print(strategyEven);
        }

        if (strategy.equals("odd")) {
            System.out.print(strategyOdd);
        }
    }

    private String bufferedReaderReadConsole() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            return input;
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Корректно ли здесь возвращать null или нет?
        return null;
    }

    private void parseInput(String s) {

        String[] array = s.split(" ");

        if (array.length != 3) {
            throw new IllegalArgumentException();
        }

        try {
            length = Integer.parseInt(array[0]);
            width = Integer.parseInt(array[1]);
            strategy = array[2];
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInputData(int x, int y, String str) {
        if (x < 1 || y < 1 || (!str.equals("odd") && !str.equals("even"))) {
            throw new IllegalArgumentException();
        }
    }

    private String deleteLastCommaInStrategy(String str) {
        if (str.endsWith(",")) {
            return str.substring(0, str.length() - 1);
        } else {
            return str;
        }
    }
}
