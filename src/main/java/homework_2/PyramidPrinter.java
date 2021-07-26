package homework_2;

import java.util.Scanner;

/**
 * Cчитывает число один раз с командной строки, и печатает пирамиду из "x"
 * согласно введенному положительному целому числу.
 * После первой печати завершает работу.
 */

public class PyramidPrinter {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pyrParam = 0;

        boolean validInput = false;
        while (!validInput) {
            try {
                pyrParam = scan.nextInt();
                if(pyrParam<0) {
                    throw new Exception();
                }
                validInput = true;
            }
            catch (Exception e) {
                System.out.println("Only 1 non-negative integer is allowed as passed parameter");
            }
        }

        for(int i=0;i<pyrParam;i++){
            for(int j=0;j<=i;j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }
}
