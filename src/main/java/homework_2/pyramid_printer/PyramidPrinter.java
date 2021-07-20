package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {

    private void errorMsg() {
        System.out.println("Only 1 non-negative integer is allowed as passed parameter");
    }

    private void input() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int height = Integer.parseInt(bufferedReader.readLine());
            if (height < 1) {
                throw new IllegalArgumentException();
            }
            printerPyramid(height);
        } catch (IOException e) {
            System.out.println("Something went wrong");
        } catch (IllegalArgumentException e) {
            errorMsg();
        }
    }

    private void printerPyramid(int height) {
        for (int i = 1; i <= height; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }

    public void start() {
        System.out.println("Pyramid Printer App \nEnter height: ");
        input();
    }
}
