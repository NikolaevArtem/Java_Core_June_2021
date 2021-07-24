package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {

    private static void printPyramid(int levelsOfPyramid) {
        for (int i = 1; i <= levelsOfPyramid; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }

    public void run() {
        System.out.println("Please type a positive integer number:");
        String inputData = readData();
        int getResult = executeProgram(inputData);
        printPyramid(getResult);
    }

    private int executeProgram(String dataFromInput) {
        int levelsOfPyramid = 0;
        try {
            levelsOfPyramid = Integer.parseInt(dataFromInput);
            if (levelsOfPyramid < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("You typed not a number or a negative number, please add a positive number");
        }
        return levelsOfPyramid;
    }

    private String readData() {
        String inputData = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            inputData = reader.readLine();
        } catch (IOException e) {
            System.out.println("Error:(");
        }
        return inputData;
    }
}

