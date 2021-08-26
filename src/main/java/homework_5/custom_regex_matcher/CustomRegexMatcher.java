package homework_5.custom_regex_matcher;

import java.util.regex.Pattern;

import static java.lang.System.lineSeparator;

public class CustomRegexMatcher {
    private static final String CUSTOM_REGEX = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}:\\d+?[zZ]\\s*–\\s*\\[.*]\\s*-\\s*.*";

    public void run(String[] args) {
        if (args.length < 1) {
            printMessage("false");
        }
        for (String s : args) {
            printMessage(isMatching(s) + lineSeparator());
        }
    }

    private boolean isMatching(String str) {
        return Pattern.matches(CUSTOM_REGEX, str);
    }

    private void printMessage(String text) {
        System.out.print(text);
    }
}