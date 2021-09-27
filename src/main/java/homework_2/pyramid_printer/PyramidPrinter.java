package homework_2.pyramid_printer;

import java.util.Scanner;

public class PyramidPrinter {
    protected final String ERROR_MSG = "Only 1 non-negative integer is allowed as passed parameter! Please, try again";
    int base;

    public void run() {
        System.out.println("Enter the base of the pyramid, valid value is integer:");
        readAndValidateInput();
        drawPyramid(base);

    }

    protected void readAndValidateInput() {
            try (Scanner scanner = new Scanner(System.in)){
                String s = scanner.nextLine();
                if (s.matches("\\d+")) {
                    base = Integer.parseInt(s);
                } else {
                    throw new IllegalArgumentException();
                }
            }
            catch (IllegalArgumentException e){
                System.out.println(ERROR_MSG);
            }

        }

    protected void drawPyramid(int base){
        for (int i = 0; i < base; i++){
            for (int j = 0; j <= i; j++){
                System.out.print("x");
            }
            System.out.println();
        }

    }

}
