package homework_2.random_chars_table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class RandomCharsTable {

    private static final String ERROR = "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";

    private int length;
    private int width;
    private String strategy;

    public void run() {

        System.out.println("[Input example: 2 3 odd]");
        System.out.println("Please, input 2 positive numbers and a strategy (even/odd)");

        try {
            String inputFull = bufferedReaderReadConsole();
            parseInput(inputFull);
            validateInputData(length, width, strategy);
            String strategyRes = createCharTable();
            System.out.println(strategyRes);
        } catch (IOException | IllegalArgumentException e) {
            System.out.println(ERROR);
        }
    }

    private String bufferedReaderReadConsole() throws IOException, NumberFormatException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        }
    }

    private void parseInput(String s) {

        String[] array = s.split(" ");

        if (array.length != 3) {
            throw new IllegalArgumentException();
        }

        length = Integer.parseInt(array[0]);
        width = Integer.parseInt(array[1]);
        strategy = array[2];
    }

    private void validateInputData(int x, int y, String str) {
        if (x < 1 || y < 1 || (!str.equals("odd") && !str.equals("even"))) {
            throw new IllegalArgumentException();
        }
    }

    private String createCharTable() {

        char[][] table = new char[length][width];
        StringBuilder strategyEven = new StringBuilder("Even letters -");
        StringBuilder strategyOdd = new StringBuilder("Odd letters -");

        for (int i = 0; i < length; i++) {
            System.out.print("|");

            for (int j = 0; j < width; j++) {
                Random r = new Random();
                int x = (r.nextInt(26) + 65);
                table[i][j] = (char) x;
                if (x % 2 == 0) {
                    strategyEven.append(" " + table[i][j] + ",");
                } else {
                    strategyOdd.append(" " + table[i][j] + ",");
                }
                System.out.print(" " + table[i][j] + " |");
            }
            System.out.println();
        }

        strategyOdd = strategyOdd.deleteCharAt(strategyOdd.length() - 1);
        strategyEven = strategyEven.deleteCharAt(strategyEven.length() - 1);

        return "even".equals(strategy) ? strategyEven.toString() : strategyOdd.toString();
    }
}
