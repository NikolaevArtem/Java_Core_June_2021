package homework_2.random_chars_table;

import homework_2.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RandomCharTable {
    private static char[][] chars;
    private static int height;
    private static int width;
    private static Strategy strategy;

    private static final char TABLE_SPLITTER = '|';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] params = line.split(" +");

        if (!isCorrectParams(params)) {
            System.out.println("Parameters are not correct");
            throw new IllegalArgumentException();
        }

        height = Integer.parseInt(params[0]);
        width = Integer.parseInt(params[1]);
        strategy = Strategy.valueOf(params[2].toUpperCase());

        chars = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j ++) {
                chars[i][j] = getRandomChar();
            }
        }

        printTable();
        printStrategyOKNums();
    }


    private static void printStrategyOKNums() {
        System.out.print(strategy.name().charAt(0) + strategy.name().substring(1).toLowerCase() + " letters - ");

        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j ++) {
                if (isStrategyOK(chars[i][j])) {
                    if (count != 0) {
                        System.out.print(", ");
                    }
                    System.out.print(chars[i][j]);
                    count++;
                }
                chars[i][j] = getRandomChar();
            }
        }
    }

    private static boolean isStrategyOK(char c) {
        boolean isEven = c % 2 == 0;
        return (strategy == Strategy.EVEN) == isEven;
    }

    private static void printTable() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j ++) {
                System.out.print(TABLE_SPLITTER);
                System.out.print(chars[i][j]);
            }
            System.out.println(TABLE_SPLITTER);
        }
    }

    private static boolean isCorrectParams(String[] params) {
        return Utils.isInt(params[0]) && Utils.isInt(params[1]) && (params[2].equals("even") || params[2].equals("odd"));
    }

    private static char getRandomChar() {
        int range = 'Z' - 'A';
        return (char) (Math.random() * range + 'A');
    }

    private enum Strategy {
        ODD,
        EVEN
    }

}
