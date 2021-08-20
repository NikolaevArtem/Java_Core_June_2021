package homework_2.pyramid_printer;

import base.BaseClazz;

import java.util.Scanner;

public class PyramidPrinter extends BaseClazz {

    private static final String ERROR_MESSAGE = "Only 1 non-negative integer is allowed as passed parameter";

    @Override
    public void run() {
        System.out.println("Enter the number");
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine().trim();
        if (isValid(inputStr)) {
            printPyramid(Integer.parseInt(inputStr));
        } else {
            System.out.println(ANSI_RED + ERROR_MESSAGE + ANSI_RESET);
        }
        scanner.close();
    }

    private void printPyramid(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }
}
