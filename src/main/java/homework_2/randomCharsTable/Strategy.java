package homework_2.randomCharsTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Strategy {
    public static char[][] array;

    private final static BufferedReader bF = new BufferedReader(new InputStreamReader(System.in));

    private static String inputData;

    private static String result = "";

    private static int rows;

    private static int columns;

    public static void choosingStrategy() throws IOException {
        System.out.println("Enter necessary data.");
        inputData = bF.readLine();
        String strategy = inputData.trim();
        arrayInitialization();
        if (strategy.endsWith("odd")) {
            odd();
        } else {
            even();
        }
        printingResult();
    }

    private static void arrayInitialization() {
        rows = Integer.parseInt(inputData.substring(0, 1));
        columns = Integer.parseInt(inputData.substring(2, 3));
        array = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                char letters = (char) (Math.random() * 10 + 65);
                array[i][j] = letters;
                System.out.print(array[i][j] + " ");
            }
        }
        System.out.println();
    }

    private static void odd() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if ((array[i][j] % 2) == 1) {
                    result += array[i][j];
                }
            }
        }
    }

    private static void even() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if ((array[i][j] % 2) == 0) {
                    result += array[i][j];
                }
            }
        }
    }

    private static void printingResult() {
        if (inputData.endsWith("even")) {
            System.out.print("Even letters - ");
        } else System.out.print("Odd letters - ");

        int counter = 0;
        while (counter < result.length()) {
            if (counter == result.length() - 1) {
                System.out.print(result.charAt(counter));
                break;
            }
            System.out.print(result.charAt(counter) + ", ");
            counter++;
        }
    }
}
