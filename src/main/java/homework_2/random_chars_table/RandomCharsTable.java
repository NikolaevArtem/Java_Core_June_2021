package homework_2.random_chars_table;

import java.util.regex.Pattern;

public class RandomCharsTable implements Runnable {


    public static final String WELCOME_MESSAGE;
    public static final String ENTER_PARAM_MESSAGE;
    public static final String ERROR_MESSAGE;
    public static final String REGEX;

    static {
        WELCOME_MESSAGE = "Welcome to the Random Chars Table Application";
        ENTER_PARAM_MESSAGE = "Enter in one line 2 numbers and a line - " +
                "the length and width of the table / two-dimensional array," +
                " and the strategy (even or odd)";
        ERROR_MESSAGE = "Passed parameters should match the format " +
                "[positive integer] [positive integer] [even|odd]";
        REGEX = "^((\\d+){2})(odd|even)";
    }

    Pattern pattern = Pattern.compile(REGEX);

    @Override
    public void run() {
        startGreeting();
        printOddCapitalLetters();
        printEvenCapitalLetters();
    }

    protected void startGreeting() {
        System.out.println(WELCOME_MESSAGE);
        System.out.println(ENTER_PARAM_MESSAGE);
    }

    protected void printOddCapitalLetters() {
        int[] aSCII = new int[128];
        for(int i = 65; i <= 89; i += 2) {
                System.out.print((char)i);
        }
    }

    protected void printEvenCapitalLetters() {
        int[] aSCII = new int[128];
        for(int i = 66; i <= 90; i += 2) {
            System.out.print((char)i);
        }
    }
}
