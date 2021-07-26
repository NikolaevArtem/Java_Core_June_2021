package homework_2.pyramid_printer;

import java.util.Scanner;

public class PyramidPrinter {
    public static void run(){
        Scanner sc = new Scanner(System.in);
        int numb;
        System.out.println("Please enter time in seconds:");
        if (!sc.hasNextInt()) {
            System.out.println("Only 1 non-negative integer is allowed as passed parameter");
            return;
        } else {
            numb = sc.nextInt();
            if (numb < 0) {
                System.out.println("Only 1 non-negative integer is allowed as passed parameter");
                return;
            } else {
                printPyramid(numb);
            }
        }
    }

    public static void printPyramid(int numb){
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

