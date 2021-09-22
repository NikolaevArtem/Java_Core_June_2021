package homework_5.custom_regex_matcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class CustomRegexMatcher implements Runnable {

    @Override
    public void run() {
        System.out.println("Enter an URL address");
        checkURL();
    }

    public static String CustomRegexForURL;

    static {
        CustomRegexForURL = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
    }

    private void checkURL() {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String string = bufferedReader.readLine();
            if (checkURLMatch(string)) {
                System.out.println("URL is valid");
            } else {
                System.out.println("URL is not valid");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private boolean checkURLMatch(String string) {
        return Pattern.matches(CustomRegexForURL, string);
    }

}