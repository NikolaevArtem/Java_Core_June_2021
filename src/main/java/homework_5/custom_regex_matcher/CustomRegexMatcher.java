package homework_5.custom_regex_matcher;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomRegexMatcher {

    private String phoneNumber = "";

    public void run() {
        System.out.println("Enter the phone number");
        initPhoneNumber();
        System.out.println(isMatches());
    }

    private void initPhoneNumber() {
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextLine()) {
                phoneNumber = scanner.nextLine().trim();
            }
        }
    }

    /*
     * String has:
     * start with +7 or 8;
     * first group - it is mobile operator code. Should contains three or more digit, and can wrapped in parentheses;
     * last three groups, which contains 3, 2 and 2 digits respectively. These groups can splitted dash or space
     * */
    private boolean isMatches() {
        Pattern pattern = Pattern.compile("^(\\+7|8)" +
                "\\s?((\\((?=\\w{3}\\))\\w{3}\\))|\\w{3})\\s?" +
                "(\\d{3})[\\-\\s]?" +
                "(\\d{2})[\\-\\s]?" +
                "(\\d{2})");
        return pattern.matcher(phoneNumber).matches();
    }
}
