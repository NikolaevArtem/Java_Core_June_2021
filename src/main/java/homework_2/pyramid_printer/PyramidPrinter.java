package homework_2.pyramid_printer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PyramidPrinter {
    static final String INPUT_MISMATCH = "Only 1 non-negative integer is allowed.";

    protected static void xRepresentation() {
        System.out.println("Enter a valid INT value for create a pyramid:");
        try (Scanner scanner = new Scanner(System.in)) {
            int x = scanner.nextInt();
            if (x >= 0) {
                for (int i = 1; i <= x; ++i) {
                    for (int j = 1; j <= i; ++j) {
                        System.out.print("x");
                    }
                    System.out.println();
                }
            } else {
                System.out.println(INPUT_MISMATCH);
            }
        } catch (InputMismatchException e) {
            System.out.println(INPUT_MISMATCH);
        }
    }

    protected static void dRepresentation() {
        System.out.println("Enter a valid INT value for create a pyramid:");
        try (Scanner scanner = new Scanner(System.in)) {
            int x = scanner.nextInt();
            if (x >= 0) {
                for (int i = 1; i <= x; ++i) {
                    for (int j = 1; j <= i; ++j) {
                        System.out.print(x);
                    }
                    System.out.println();
                }
            } else {
                System.out.println(INPUT_MISMATCH);
            }
        } catch (InputMismatchException e) {
            System.out.println(INPUT_MISMATCH);
        }
    }
}

