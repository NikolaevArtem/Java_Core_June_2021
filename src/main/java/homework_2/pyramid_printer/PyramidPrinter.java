package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {
    private final String ERR_MSG = "Only 1 non-negative integer is allowed as passed parameter";

    public void run() {
        String sizeOfPyramid = getInput();

        if (isValid(sizeOfPyramid)) {
            printPyramid(Integer.parseInt(sizeOfPyramid));
        } else {
            System.out.println(ERR_MSG);
        }
    }

    private String getInput() {
        String result = null;
        System.out.println("Enter the Pyramid size. please: ");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            result = reader.readLine();
        } catch (IOException e) {
            System.out.println(ERR_MSG);
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

    private boolean isValid(String input) {

        if (input != null && input.chars().allMatch(Character::isDigit)){
         long intRes = Long.parseLong(input);
            return intRes >= 0 && intRes < Integer.MAX_VALUE;
        }
    return false;
    }
}
