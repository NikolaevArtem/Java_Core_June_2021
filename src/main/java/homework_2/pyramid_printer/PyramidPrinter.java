package homework_2.pyramid_printer;

import lombok.Data;
import java.util.InputMismatchException;
import java.util.Scanner;

@Data
public class PyramidPrinter {

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            String str = scanner.nextLine();
            int number = Integer.parseInt(str);
            System.out.println(buildPyramidString(number));
        } catch (NumberFormatException | ArithmeticException | InputMismatchException ex) {
            System.out.println("Only non-negative integer is allowed as passed parameter!");
        }
    }

    StringBuilder buildPyramidString(int number) {
        StringBuilder pyramidString = new StringBuilder();
        if (number < 0) {
            throw new ArithmeticException();
        }

        for (int i = 0; i < number; i++) {
            for (int j = 0; j <= i; j++) {
                pyramidString.append('x');
            }
            pyramidString.append('\n');
        }
        return pyramidString;
    }
}