package homework_5.custom_regex_matcher;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomRegexMatcher {

    private static final String BYTE_VALUE = "((25[0-5])|(2[0-4][0-9])|([0-1][0-9][0-9])|([0-9][0-9])|([0-9]))"; // leading zeros allowed
    private static final String IP_REGEX = BYTE_VALUE +
                                           "\\." + BYTE_VALUE +
                                           "\\." + BYTE_VALUE +
                                           "\\." + BYTE_VALUE;

    public void run() {
        System.out.print("Enter ip-address for validation: ");
        String input = getInput();
        validateInput(input);
    }

    private String getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        if (scanner.hasNext()) {
            input = scanner.nextLine();
        }
        scanner.close();
        return input;
    }

    private void validateInput(String input) {
        Pattern pattern = Pattern.compile(IP_REGEX);
        Matcher matcher = pattern.matcher(input);
        System.out.println(matcher.matches());
    }
}
