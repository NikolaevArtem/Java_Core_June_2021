package homework_2.random_chars_table;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class RandomCharsTable {
    public static enum Strategy {
        EVEN,
        ODD
    }

    private int length;
    private int width;
    private Strategy strategy;
    private int[][] table;

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().trim().split("\\s");

        scanner.close();
        try {
            if (arr.length != 3) {
                throw new NumberFormatException("Passed parameters should match the format [positive integer] [positive integer] [even|odd]!");
            }
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        try {
            setParameters(arr);
        } catch (NumberFormatException ex) {
            System.out.println("Passed parameters should match the format [positive integer] [positive integer] [even|odd]!");
            return;
        } catch (IllegalArgumentException ex) {
            System.out.println("Passed parameters should match the format [positive integer] [positive integer] [even|odd]!");
            return;
        }
        initializeTable();
        printTable();
        printTableByStrategy(getStrategy());
    }

    public void setParameters(String[] arr) {
        for (int i = 0; i < 3; i++) {
            if (i < 2) {
                int j = Integer.parseInt(arr[i]);

                if (j < 1) {
                    throw new IllegalArgumentException();
                }

                if (i == 0) {
                    setLength(j);
                } else {
                    setWidth(j);
                }
            } else {
                String strategyStr = arr[i];

                if (Strategy.EVEN.equals(Strategy.valueOf(strategyStr.toUpperCase())) || Strategy.ODD.equals(Strategy.valueOf(strategyStr.toUpperCase()))) {
                    strategy = Strategy.valueOf(strategyStr.toUpperCase());
                } else {
                    throw new NumberFormatException();
                }
            }
        }
    }

    public void initializeTable() {
        table = new int[length][width];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                table[i][j] = getRandomChar();
            }
        }
    }

    private char getRandomChar() {
        Random rnd = new Random();
        char c = (char) ('A' + rnd.nextInt(26));
        return c;
    }

    public void printTable() {
        int[][] table = getTable();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                result.append("|" + (char) table[i][j]);
            }
            result.append("|" + "\n");
        }
        System.out.println(result);
    }

    public void printTableByStrategy(Strategy strategy) {
        int[][] table = getTable();
        StringBuilder result = new StringBuilder();
        int remainder;

        if (strategy == Strategy.ODD) {
            result.append("Odd letters: ");
            remainder = 1;
        } else {
            result.append("Even letters: ");
            remainder = 0;
        }

        boolean firstPrint = true;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                int currentChar = table[i][j];
                if (currentChar % 2 == remainder) {
                    String substr = String.valueOf((char) currentChar);
                    if (result.toString().contains(substr)) {
                        continue;
                    }
                    if (!firstPrint) {
                        result.append(", ");
                    }
                    result.append((char) currentChar);
                    firstPrint = false;
                }
            }
        }
        System.out.println(result);
    }
}