package homework.homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {


    public static void main(String[] args) {

    }

    public void run() {
        int sizeOfPyramid = getInput();

        printPyramid(sizeOfPyramid);
    }

    private static int getInput() {
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
                System.out.println("Empty or too big inputs are not allowed!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong input, only integers are allowed!");
        }
        if (result <0) {
            System.out.println("Negative numbers are not allowed!");
        }
        return result;
    }

    private static void printPyramid(int i) {
        for (int j = 0; j < i; j++) {
            System.out.println(getRow(j));
        }
    }

    private static String getRow(int i) {
        StringBuilder row = new StringBuilder();
        for (int j = 0; j <= i; j++) {
            row.append('x');
        }
        return row.toString();
    }
}
