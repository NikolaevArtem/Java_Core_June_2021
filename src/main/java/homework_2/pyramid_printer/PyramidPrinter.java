package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {

    public void run() {
        System.out.println("Please, input number:");
        String input = setInput();
        if (isValid(input)) {
            printPyramid(Integer.parseInt(input));
        } else {
            System.out.println("Only 1 non-negative integer is allowed as passed parameter");
        }
    }

    protected String setInput() {
        try(BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in))) {
            return br.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    private boolean isValid(String inputString) {
        if(inputString == null) {
            return false;
        }
        int pyramidSize;
        try {
            pyramidSize = Integer.parseInt(inputString);
        } catch (NumberFormatException ex) {
            return false;
        }
        return pyramidSize >= 0;
    }

    private void printPyramid(int pyramidSize) {
        for (int i = 1; i <= pyramidSize; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }
}
