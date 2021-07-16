package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
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
                        break;
                    } else {
                        System.err.println("Out of range (input should be >= 0)");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Can't parse input string to integer");
                }
            }
        } catch (IOException e) {
            System.err.println("IOException has caught");
        }
    }
}
