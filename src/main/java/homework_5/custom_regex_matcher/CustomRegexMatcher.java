package homework_5.custom_regex_matcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomRegexMatcher {

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            System.out.println(regex(reader.readLine()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private boolean regex(String readLine) {
        boolean result = readLine.matches("\\d");

        return result;
    }

}
