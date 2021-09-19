package homework_5.custom_regex_matcher;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomRegexMatcher {
    private static final String GREETING = "Enter the car's number:";
//    the expression on the line below (with Russian characters) worked correctly, but then stopped working correctly. I do not know why:
//    private static final String REGEX = "([ABCEHKMOPTXYabcehkmoptxy]|[АВЕКМНОРСТУХавекмнорстух])\\d{3}([ABCEHKMOPTXYabcehkmoptxy]|[АВЕКМНОРСТУХавекмнорстух]){2}\\d{2,3}";
    private static final String REGEX = "[ABCEHKMOPTXYabcehkmoptxy]\\d{3}[ABCEHKMOPTXYabcehkmoptxy]{2}\\d{2,3}";
    private boolean matchingToRegex = false;

    public void run() {
        System.out.println(GREETING);
        readValidInput();
        System.out.println(matchingToRegex);

    }

    private void readValidInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            String s = scanner.nextLine();
            Pattern pattern = Pattern.compile(REGEX);
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                matchingToRegex = true;
            }
        }

    }

}
