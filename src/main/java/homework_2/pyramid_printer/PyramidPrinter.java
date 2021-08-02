package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {
    final String ERROR_MSG = "Only 1 non-negative integer is allowed as passed parameter";

    public void run() {
        int sizeOfPyramid = getInput();

        printPyramid(sizeOfPyramid);
    }

    private int getInput() {
        String pSize = null;
        int result = 0;
        System.out.println("Enter the Pyramid size. please: ");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            pSize = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (pSize != null) {
                result = Integer.parseInt(pSize);
            }
            else {
                System.out.println(ERROR_MSG);
            }
        } catch (NumberFormatException e) {
            System.out.println(ERROR_MSG);
        }
        if (result <0) {
            System.out.println(ERROR_MSG);
        }
        return result;
    }

    private void printPyramid(int i) {
        for (int j = 0; j < i; j++) {
            System.out.println(getRow(j));
        }
    }

    private String getRow(int i) {
        StringBuilder row = new StringBuilder();
        for (int j = 0; j <= i; j++) {
            row.append('x');
        }
        return row.toString();
    }
}
