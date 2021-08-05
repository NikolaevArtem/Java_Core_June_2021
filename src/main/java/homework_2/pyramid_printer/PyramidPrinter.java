package homework_2.pyramid_printer;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PyramidPrinter {

    public static final String ERROR_MESSAGE = "Only 1 non-negative integer is allowed as passed parameter";

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String sizeAsString = scanner.nextLine();

        if (!isNumber(sizeAsString)) {
            System.out.println(ERROR_MESSAGE);
            return;
        }
        int size = Integer.parseInt(sizeAsString);
        if (size < 0) {
            System.out.println(ERROR_MESSAGE);
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
