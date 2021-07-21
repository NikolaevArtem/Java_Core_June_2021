package homework_2_tests.pyramid_printer_test;

import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PyramidPrinterTest {
@Test
void test() {
final String actual = new
}
    public void run() {

        Scanner in = new Scanner(System.in);
        try {
            int number = in.nextInt();
            in.close();
            StringBuilder result = new StringBuilder();
            char x = 'x';
            char cr = 13;
            int i = 0;
            int j;
            while (i < number) {
                j = 0;
                while (j <= i) {
                    result.append(x);
                    j++;
                }
                result.append(cr);
                i++;
                System.out.println(result);
            }
        } catch (
                InputMismatchException e) {
            System.out.println("Error! Only numbers!");
        }
    }
}