package homework_2.pyramidPrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {
    public static void main(String[] args) {
        String output = "";
        int input;
        try (BufferedReader bF = new BufferedReader(new InputStreamReader(System.in))) {
            input = Integer.parseInt(bF.readLine());
            for (int i = 0; i < input; i++) {
                output += "x";
                System.out.println(output);
            }
        } catch (IOException e) {
            System.out.println("Error occurred during input");
        }
    }
}
