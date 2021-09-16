package homework_2.pyramid_printer;

import java.util.Scanner;

public class PyramidPrinter {

    public void run() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input number:");
        String inpt = in.nextLine();
        if (isValid(inpt)) {
            try {
                int n = Integer.parseInt(inpt);
                printResult(n);
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        } else
            System.out.println("Only 1 non-negative integer integer is allowed as passed parameter");
    }

    public boolean isValid(String inpt) {
        return inpt.chars().allMatch(Character::isDigit);
    }

    public static void printResult(int n) {
        if (n == 0)
            System.out.println(" ");
        else
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++)
                    System.out.print("x");
                System.out.println();
            }
    }
}
