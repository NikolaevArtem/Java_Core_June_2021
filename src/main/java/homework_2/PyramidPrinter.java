package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {
    public static void main(String[] args) {
        printPyramid();
    }

    private static void printPyramid() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Please type a positive integer number:");
            try {
                int levelsOfPyramid = Integer.parseInt(reader.readLine());
                for (int i = 1; i <= levelsOfPyramid; i++) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print("x");
                    }
                    System.out.println();
                }
            } catch (NumberFormatException e) {
                System.out.println("You typed not a number, please add a positive number");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
