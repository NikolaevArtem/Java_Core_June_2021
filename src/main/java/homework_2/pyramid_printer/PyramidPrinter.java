package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {

    private int pyramidSize;

    public void run() {
        System.out.println("Please, input number:");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            pyramidSize = Integer.parseInt(br.readLine());
        } catch (NumberFormatException | IOException ex) {
            System.out.println("Wrong input format!");
            return;
        }
        if (pyramidSize < 0) {
            System.out.println("Number should be non-negative!");
            return;
        }

        printPyramid();
    }

    private void printPyramid() {
        for (int i = 1; i <= pyramidSize; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }
}
