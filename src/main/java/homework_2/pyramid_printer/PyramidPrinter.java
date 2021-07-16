package homework_2.pyramid_printer;

import java.util.Scanner;

public class PyramidPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a valid INT value for create a pyramid:");
        int x = scanner.nextInt();

        for (int i = 1; i <= x; ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print("x");
            }
            System.out.println();
        }
    }
}
