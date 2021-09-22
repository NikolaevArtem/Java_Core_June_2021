package homework_5.custom_regex_matcher;

import java.util.Scanner;

public class CustomRegexMatcher {

    private CustomRegexMatcher() { }

    private static final String PHONE_NUMBER_FORMAT = "(\\+\\d)\\s\\(\\d{3}\\)\\s(\\d{3})-(\\d{4})";

    public static void run() {
        System.out.println(validate(getInput()));
    }

    private static String getInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLine().trim();
        }
    }

    // should be written as: `+# (###) ###-####`, where # - is an integer number
    private static Boolean validate(String str) {
        return str.matches(PHONE_NUMBER_FORMAT);
    }


}
