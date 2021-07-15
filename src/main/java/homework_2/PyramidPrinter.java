package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {

    public static void main(String[] args) throws IOException {
        System.out.println("Pyramid Printer App \nEnter height: ");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            int height = Integer.parseInt(bufferedReader.readLine());
            for (int i = 1; i <= height; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print("x");
                }
                System.out.println("\r");
            }
        }
    }
}
