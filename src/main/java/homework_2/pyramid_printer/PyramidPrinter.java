package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {

    void run() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            try {
                int i = Integer.parseInt(reader.readLine());
                printPyramid(i);

            } catch (NumberFormatException e) {
                System.out.println("Error: integer only");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    void printPyramid (int i) {

        String x = "";
        if (i < 0) {
            System.out.println("Error: positive only");
        } else {
            StringBuilder b = new StringBuilder();
            for (int n = 0; n < i; n++) {
                x += "x";
                b.append(x + "\n");
            }
            System.out.println(b);
        }
    }
}
