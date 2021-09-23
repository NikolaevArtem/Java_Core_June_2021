package homework_5.custom_regex_matcher;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomRegexMatcher {
    private final Scanner sc = new Scanner(System.in);

    public void run() {
        String input = sc.nextLine();
        System.out.println(matcher(input));
    }

    private boolean matcher(String s) {
        String passwordRegex = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
        return Pattern.matches(passwordRegex, s);
    }
}
