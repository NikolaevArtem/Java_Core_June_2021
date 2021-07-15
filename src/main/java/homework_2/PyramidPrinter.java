package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {
    public static void main(String[] args) {
        System.out.println("How many levels should the pyramid be?");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            try {
                int levels = Integer.parseInt(reader.readLine());
                for (int i = 1; i <= levels; i++) {
                    System.out.println("x".repeat(i));
                }
            } catch (NumberFormatException e) {
                System.out.println("It's not a number. Next time enter a positive integer.");
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
