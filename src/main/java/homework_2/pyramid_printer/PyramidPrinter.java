package homework_2.pyramid_printer;

import lombok.Getter;
import lombok.Setter;
import java.util.Scanner;

@Getter
@Setter
class PyramidPrinter {
    private StringBuilder pyramidString;

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        try {
            int number = Integer.parseInt(str);
            if (number < 0) {
                throw new ArithmeticException();
            }
            buildPyramidString(number);
            printPyramid();
        } catch (ArithmeticException ex) {
            System.out.println("Error! Only positive numbers!");
        } catch (NumberFormatException ex) {
            System.out.println("Error! Only numbers!");
        }
        scanner.close();
    }

    public void buildPyramidString(int number) {
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