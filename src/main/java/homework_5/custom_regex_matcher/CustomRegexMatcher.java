package homework_5.custom_regex_matcher;

import java.util.regex.Pattern;
import static java.lang.System.lineSeparator;

public class CustomRegexMatcher {

    private static final String CUSTOM_REGEX_FOR_URL = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    public void run(String[] args) {

        if (args.length < 1) {

            printMessage("No match");

        }

        for (String s : args) {
            printMessage(isMatch(s) + lineSeparator());
        }

    }

    private boolean isMatch(String string) {
        return Pattern.matches(CUSTOM_REGEX_FOR_URL, string);
    }

    private void printMessage(String message) {
        System.out.print(message);
    }

}