package homework_2.pyramid_printer;

import java.util.Scanner;

public class PyramidPrinter {

    public void run(){
        Scanner in = new Scanner(System.in);
        System.out.println("input the number");
        try{
            int n = in.nextInt();
            if (n == 0)
                System.out.println("n = 0");
            else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j <= i; j++)
                        System.out.print("x");
                    System.out.println();
                }
            }

        } catch (NumberFormatException e){
            System.out.println("Only 1 non-negative integer integer is allowed as passed parameter");

        }
    }
}
