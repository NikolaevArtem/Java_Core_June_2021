package homework_2.pyramid_printer;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PyramidPrinter implements Runnable {

    public static final String ERROR_MESSAGE;
    public static final String WELCOME_MESSAGE;
    public static final String ENTER_HEIGHT_MESSAGE;
    public static final String REGEX;

    static {
        ERROR_MESSAGE = "Only 1 non-negative integer is allowed as passed parameter";
        WELCOME_MESSAGE = "Welcome to the Pyramid Printer Application";
        ENTER_HEIGHT_MESSAGE = "Enter the height parameter";
        REGEX = "\\d+";
    }

    Pattern pattern = Pattern.compile(REGEX);

    @Override
    public void run() {
        startGreeting();
        Scanner scanner = new Scanner(System.in);
        String consoleString = scanner.nextLine();
        scanner.close();
        if (numberFormatIsValid(consoleString)) {
            printPyramid(Integer.parseInt(consoleString));
        }
    }

    protected void startGreeting() {
        System.out.println(WELCOME_MESSAGE);
        System.out.println(ENTER_HEIGHT_MESSAGE);
    }

    protected boolean numberFormatIsValid(String consoleString) {
        if (!pattern.matcher(consoleString).matches()) {
            System.out.println(ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    protected void printPyramid(int height) {
        for (int i = 1; i <= height; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }
}
