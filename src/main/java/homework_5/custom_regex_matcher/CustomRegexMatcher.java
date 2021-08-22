package homework_5.custom_regex_matcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomRegexMatcher {

    void run() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String inputStr = reader.readLine();
            String patternStr = "^<([a-z]+)([^>]+)*(?:>(.*)<\\/\\1>|\\s+\\/>)$";
            Pattern pattern = Pattern.compile(patternStr);
            Matcher matcher = pattern.matcher(inputStr);

            System.out.println(matcher.find() ?
                    "true" :
                    "false");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
