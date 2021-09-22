package homework_2.pyramid_printer;

import java.util.InputMismatchException;
import java.util.Scanner;

import static homework_2.pyramid_printer.Constants.INPUT;
import static homework_2.pyramid_printer.Constants.INPUT_MISMATCH;

public class ExtraPyramidPrinter {

    public void run() {
        System.out.println(INPUT);
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
