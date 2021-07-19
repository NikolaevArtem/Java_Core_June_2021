package homework_3.pyramidprinter;

import java.util.regex.Pattern;

public class PyramidPrinter {

    public void start(String sizeAsString) {
        if (!isNumber(sizeAsString)) {
            System.out.println("ERROR! This is not a number");
            return;
        }
        int size = Integer.parseInt(sizeAsString);
        if (size < 0) {
            System.out.println("ERROR! Size is negative");
            return;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private boolean isNumber(String str) {
        return !Pattern.matches(str, "-?[0-9]+");
    }
}
