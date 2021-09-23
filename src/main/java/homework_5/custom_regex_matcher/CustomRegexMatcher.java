package homework_5.custom_regex_matcher;

import base.BaseClazz;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomRegexMatcher extends BaseClazz {

    @Override
    public void run() {
        System.out.println("Enter the phone number");
        System.out.println(isValid(initPhoneNumber()));
    }

    private String initPhoneNumber() {
        String phoneNumber = "";
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextLine()) {
                phoneNumber = scanner.nextLine().trim();
            }
        }
        return phoneNumber;
    }

    /*
     * String has:
     * Starts with +7 or 8;
     * First group - it is mobile operator code. It should contain three or more digits and it can be wrapped in parentheses;
     * Last three groups should contains 3, 2 and 2 digits respectively. These groups can be splitted with the help of dash or space
     * */
    @Override
    protected boolean isValid(String... arg) {
        if (arg.length > 1) return false;
        Pattern pattern = Pattern.compile("^(\\+7|8)" +
                "\\s?((\\((?=\\w{3}\\))\\w{3}\\))|\\w{3})\\s?" +
                "(\\d{3})[\\-\\s]?" +
                "(\\d{2})[\\-\\s]?" +
                "(\\d{2})");
        return pattern.matcher(arg[0]).matches();
    }
}
