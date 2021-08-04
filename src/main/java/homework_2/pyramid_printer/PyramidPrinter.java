package homework_2.pyramid_printer;

import lombok.Getter;
import lombok.Setter;

import java.util.InputMismatchException;
import java.util.Scanner;

@Getter
@Setter
class PyramidPrinter {

    private StringBuilder pyramidString;

    public void run() {

        try (Scanner scanner = new Scanner(System.in)) {
            String str = scanner.nextLine();
            int number = Integer.parseInt(str);
            buildPyramidString(number);
            printPyramid();
        } catch (ArithmeticException | InputMismatchException ex) {
            System.out.println("Only non-negative integer is allowed as passed parameter!");
        }
    }

    public void buildPyramidString(int number) {
        if (number < 0) {
            throw new ArithmeticException();
        }

        StringBuilder result = new StringBuilder();
        char charX = 'x';
        char newLineChar = '\n';

        for (int i = 0; i < number; i++) {
            for (int j = 0; j <= i; j++) {
                result.append(charX);
            }
            result.append(newLineChar);
        }
        setPyramidString(result);
    }

    public void printPyramid() {
        System.out.println(getPyramidString().toString());
    }
}