package homework_2.pyramid_printer;

import java.util.Scanner;

public class PyramidPrinter {

    private static final String ANSI_RESET = "\033[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ERROR_MESSAGE = "Only 1 non-negative integer is allowed as passed parameter";

    public void run() {
        System.out.println("Enter the number");
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        if (isValid(inputStr)) {
            inputStr = inputStr.replaceAll("\\s+", "");
            try {
                printPyramid(Integer.parseInt(inputStr));
            } catch (NumberFormatException exception) {
                System.out.println(ANSI_RED + ERROR_MESSAGE + ANSI_RESET);
            }
        } else {
            System.out.println(ANSI_RED + ERROR_MESSAGE + ANSI_RESET);
        }
        scanner.close();
    }

    private boolean isValid(String arg) {
        return arg.matches("^\\s*[+]?[0-9]+\\s*$");
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
