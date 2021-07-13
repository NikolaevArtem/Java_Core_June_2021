package homework_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PyramidPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите высоту пирамиды: ");

        int height = 0;
        try {
            height = scanner.nextInt();
            System.out.println();
        } catch (InputMismatchException e) {
            System.out.println("Введено не число");
        }
        scanner.close();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }
}
