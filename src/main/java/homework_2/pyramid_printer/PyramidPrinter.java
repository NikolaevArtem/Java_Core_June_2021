package homework_2.pyramid_printer;

import lombok.Getter;
import lombok.Setter;
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
        } catch (ArithmeticException ex) {
            System.out.println("Only non-negative integer is allowed as passed parameter!");
        } catch (NumberFormatException ex) {
            System.out.println("Error! Only numbers!");
        }
    }

    public void buildPyramidString(int number) {
        if (number < 0) {
            throw new ArithmeticException();
        }

        StringBuilder result = new StringBuilder();
        char charX = 'x';
        char newLineChar = '\n';

        for (int i = 0, j = 0; i < number; i++, j = 0) {
            while (j <= i) {
                result.append(charX);
                j++;
            }
            result.append(newLineChar);
        }
        setPyramidString(result);
    }

    public void printPyramid() {
        System.out.println(getPyramidString().toString());
    }
}