package homework_2.pyramid_printer;

import java.util.Scanner;

public class PyramidPrinter {

    protected static final String ANSI_RESET = "\033[0m";
    protected static final String ANSI_RED = "\u001B[31m";

    public void start() {
        System.out.println("Enter the number");
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        if (isValid(inputStr)) {
            printPyramid(Integer.parseInt(inputStr));
        }
        scanner.close();
    }

    private boolean isValid(String arg) {
        if (!arg.matches("^\\s*[+]?[0-9]+\\s*$")) {
            System.out.println(ANSI_RED + "Only 1 non-negative integer is allowed as passed parameter" + ANSI_RESET);
            return false;
        }
        return true;
    }

    private void printPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }
}
