package homework_5.CustomRegexMatcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomRegexMatcher {

    public String regex = "\\w";

    public void run() {
        System.out.println("Enter string");
        input();
    }

    private void input() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String string = bufferedReader.readLine();
            match(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void match(String string) {
        System.out.println(Pattern.matches(regex, string));
    }

}
