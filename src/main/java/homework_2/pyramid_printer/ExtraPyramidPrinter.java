package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtraPyramidPrinter {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public void run(String... args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Please input number");
            int rows = Integer.parseInt(reader.readLine());
            printPyramid(rows, args);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println(ANSI_RED + "Only 1 non-negative integer is allowed as passed parameter!" + ANSI_RESET);

        }
    }

    void printPyramid(int rows, String[] args) {
        if (rows < 0 || args.length == 0) {
            System.out.println("arr + length " + args.length);
            throw new IllegalArgumentException();
        }

        if (args[0].equalsIgnoreCase("invert")) {
            for (int i = rows; i >= 1; --i) {
                for (int j = 1; j <= i; ++j) {
                    System.out.print("x");
                }
                System.out.println();
            }
        } else {
            for (int i = 1; i <= rows; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print("x");
                }
                System.out.println();
            }
        }
    }
}
