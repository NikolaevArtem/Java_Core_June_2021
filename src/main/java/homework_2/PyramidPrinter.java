package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {
    public static void main(String[] args) throws Exception {
        printPyramid();
    }

    private static void printPyramid() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Please type a positive integer number");
            int levelsOfPyramid = Integer.parseInt(reader.readLine());
            for (int i = 1; i <= levelsOfPyramid; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("x");
                }
                System.out.println();
            }
        }
    }

}
