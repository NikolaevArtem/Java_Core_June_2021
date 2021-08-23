package homework_5.custom_regex_matcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomRegexMatcher {

    private static final String CHECK_USERNAME = "^[a-z0-9.-]{5,10}$";

    public static void run() {
        System.out.println(checkRegex());
    }

    private static boolean checkRegex() {
        return getInput().matches(CHECK_USERNAME);
    }

    private static String getInput() {
        String input = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter your username, it must only contain letters, numbers and dot, minimum length 5, maximum length 10(inclusive):");
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }
}