package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class PyramidPrinter {

    private int i;

    void run() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            if (valid(reader.readLine())) {
                printPyramid();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void printPyramid() {

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


    private boolean valid(String s) {

        try {
            i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("Error: integer only");
            return false;
        }

        return true;
    }


}
