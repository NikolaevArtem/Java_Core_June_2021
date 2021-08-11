package homework_2.random_chars_table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RandomCharsTable {
    private final String ERROR = "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";
    private char[][] array;
    private String strategy;
    private String inputData;
    private String result;
    private int rows;
    private int columns;

    public void run() {
        System.out.println("Enter data in format: width, length of matrix and strategy (even/odd)");
        inputData = readingConsole();
        parseData(inputData);
        if (dataValidation(rows, columns, strategy)) {
            System.out.println(ERROR);
        } else {
            arrayInitialization();
            if (strategy.equals("odd")) {
                oddStrategy();
            } else {
                evenStrategy();
            }
            printingResult();
        }
    }

    private void parseData(String s){
        String[] resultArray = s.split(" ");
        if(resultArray.length != 3){
            return;
        }
        rows = Integer.parseInt(resultArray[0]);
        columns = Integer.parseInt(resultArray[1]);
        strategy = resultArray[2];
    }

    private void arrayInitialization() {
        array = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.out.print("|");
            for (int j = 0; j < columns; j++) {
                char letters = (char) (Math.random() * 10 + 65);
                array[i][j] = letters;
                System.out.print(array[i][j] + "|");
            }
            System.out.println();
        }
    }

    private void oddStrategy() {
        result = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if ((array[i][j] % 2) == 1) {
                    result += array[i][j];
                }
            }
        }
    }

    private void evenStrategy() {
        result = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if ((array[i][j] % 2) == 0) {
                    result += array[i][j];
                }
            }
        }
    }

    private void printingResult() {
        if (strategy.equals("even")) {
            System.out.print("Even letters - ");
        } else {
            System.out.print("Odd letters - ");
        }
        for(int i = 0; i< result.length();i++){
            if (i == result.length() - 1) {
                System.out.print(result.charAt(i));
                break;
            }
            System.out.print(result.charAt(i) + ", ");
        }
    }

    private String readingConsole() {
        inputData = "";
        try (BufferedReader bF = new BufferedReader(new InputStreamReader(System.in))) {
            inputData = bF.readLine();
        } catch (IOException exc) {
            System.out.println("Error occurred during input");
        }
        return inputData;
    }

    private boolean dataValidation(int x, int y, String str) {
        return x < 1 || y < 1 || (!str.equals("odd") && !str.equals("even"));
    }
}
