package homework_2.pyramid_printer;

import lombok.Data;
import java.util.InputMismatchException;
import java.util.Scanner;

@Data
public class PyramidPrinter {
    private StringBuilder pyramidString = new StringBuilder();

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            String str = scanner.nextLine();
            int number = Integer.parseInt(str);
            buildPyramidString(number);
            System.out.println(pyramidString);
        } catch (ArithmeticException | InputMismatchException ex) {
            System.out.println("Only non-negative integer is allowed as passed parameter!");
        }
    }

    void buildPyramidString(int number) {
        if (number < 0) {
            throw new ArithmeticException();
        }

        for (int i = 0; i < number; i++) {
            for (int j = 0; j <= i; j++) {
                pyramidString.append('x');
            }
            pyramidString.append('\n');
        }
    }
}