package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {
    private static final String ERROR_MSG = "Only 1 non-negative integer is allowed as passed parameter";

    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter height of pyramid:");
            String inputStr = bufferedReader.readLine();
            try {
                int height = Integer.parseInt(inputStr);
                if (height > 0) {
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < i + 1; j++) {
                            System.out.print("x");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println(ERROR_MSG);
                }
                bufferedReader.close();
            } catch (NumberFormatException e) {
                System.out.println(ERROR_MSG);
            }
        } catch (IOException e) {
            System.out.println(ERROR_MSG);
        }
    }
}
