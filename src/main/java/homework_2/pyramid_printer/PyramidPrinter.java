package homework_2.pyramid_printer;

import java.util.Scanner;

public class PyramidPrinter {
    private static final String ERROR_MESSAGE = "Only 1 non-negative integer is allowed as passed parameter";

    public void run(){
        Scanner sc = new Scanner(System.in);
        int numb;
        String str;
        System.out.println("Please enter the number:");
        if (!sc.hasNextInt()) {
            System.out.println(ERROR_MESSAGE);
            return;
        } else {
            str = sc.nextLine();
            str = str.trim();
            if (!str.matches("[-+]?\\d+")) {
                System.out.println(ERROR_MESSAGE);
                return;
            }
            numb = Integer.parseInt(str);
            if (numb < 0) {
                System.out.println(ERROR_MESSAGE);
                return;
            } else {
                printPyramid(numb);
            }
        }
    }

    public void printPyramid(int numb){
        if (numb == 0) {
            return;
        }
        for (int i = 1; i <= numb; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("x");
            }
            System.out.print("\n");
        }
    }
}

