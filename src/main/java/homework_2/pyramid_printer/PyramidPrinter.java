package homework_2.pyramid_printer;

import java.util.Scanner;

public class PyramidPrinter {

    public void run() {
        System.out.print("Enter pyramid height: ");

        int height;
        try (Scanner scan = new Scanner(System.in)) {
            String input = scan.nextLine().trim();
            height = Integer.parseInt(input);
            if (height < 0) {
                throw new IllegalArgumentException();
            }
        } catch (RuntimeException e) {
            System.out.println("Only 1 non-negative integer is allowed as passed parameter");
            return;
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }
}