package homework_5.custom_regex_matcher;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomRegexMatcher {

    private final static String REG_EXP = "^([a-zA-Z0-9])[a-zA-Z0-9._]+@[a-z]+\\.[a-z]*";
    public boolean run() {
        Scanner scanner = new Scanner(System.in);
        String email = scanner.next();
        return Pattern.matches(REG_EXP, email);
    }
}
