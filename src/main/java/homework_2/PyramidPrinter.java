package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            try {
                int i = Integer.parseInt(reader.readLine());
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
            } catch (NumberFormatException e) {
                System.out.println("Error: integer only");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
