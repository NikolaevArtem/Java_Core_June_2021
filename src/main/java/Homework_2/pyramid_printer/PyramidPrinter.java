package Homework_2.pyramid_printer;

import java.util.Scanner;

public class PyramidPrinter {

    protected void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the base of the pyramid, valid value is integer:");

        //reading the value of pyramid's base
        try {
            int base = scanner.nextInt();
            if (base < 0) {
                throw new Exception();
            }
            drawingThePyramid(base);
        }
        catch (Exception e){
            System.out.println("Only 1 non-negative integer is allowed as passed parameter! Please, try again");
            return;
        }
        //adding finally block (28.07.2021)
        finally {
            scanner.close();
        }
    }

    protected void drawingThePyramid(int base){
        if (base == 0){
            System.out.println("");
            return;
        }
        for (int i = 0; i < base; i++){
            for (int j = 0; j <= i; j++){
                System.out.print("x");
            }
            System.out.println();
        }
    }

}
