package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Please input number");
            int rows = Integer.parseInt(reader.readLine());
            printPyramid(rows);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println(ANSI_RED + "Only 1 non-negative integer is allowed as passed parameter!" + ANSI_RESET);
        }
    }

    void printPyramid(int rows) {
        if(rows < 0){
            throw new IllegalArgumentException();
        }
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }
}

