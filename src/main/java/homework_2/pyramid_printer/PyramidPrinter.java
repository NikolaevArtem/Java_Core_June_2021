package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PyramidPrinter {

    public void run() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int x = Integer.parseInt(reader.readLine());
            if (x <= 0) {
                System.out.println("Only 1 non-negative integer is allowed as passed parameter");
                return;
            }

            printPyramid(x);

        } catch (Exception e) {
            System.out.println("Only 1 non-negative integer is allowed as passed parameter");
        }

    }

    public static void printPyramid(int score) {

        for (int i = 1; i <= score; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("x");
            }
            System.out.println();
        }

    }

}
