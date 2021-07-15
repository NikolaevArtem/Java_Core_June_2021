package homework_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PyramidPrinter {

    public static void main(String[] args) {
        try {
            int pyramidValue = readIntFromConsole();
            if (pyramidValue < 0) {
                printError("Only positive int numbers are allowed!");
            }
            else {
                printPyramid(pyramidValue);
            }
        } catch (Exception e) {
            printError("Only int numbers are allowed!");
        }
    }

    private static void printPyramid(int pyramidValue) {
        String outputString = "x";
        for (int i = 0; i < pyramidValue; i++) {
            System.out.println(outputString);
            outputString = outputString + "x";
        }
    }

    public static void printError (String Message){
        System.out.println("\u001B[31m" + "Error! " + Message + "\u001B[0m");
    }

    private static int readIntFromConsole() throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.printf("Enter value from 0 - %s: ", Integer.MAX_VALUE);
            return Integer.parseInt(reader.readLine());
        }
    }

}