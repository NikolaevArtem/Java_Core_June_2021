package homework_5.custom_regex_matcher;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomRegexMatcher {
    final private static String REGEX = "\\w*@\\w*\\.\\w*";
    // that regex Matches only email-like strings
    //for example "Allzza4279@gmail.com" or "regex@lul.notmail1", " dimatroshkin@mail.ru"

    public static void run() {
        try {
            String s = getString();
            System.out.println(matchRegex(s));
        } catch (Throwable e){
            System.out.println("Wrong input");
        }

    }

    public static String getString() throws Throwable {
        System.out.println("Please, enter your string...");
        String s;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        s = reader.readLine();
        reader.close();
        return s;
    }

    public static boolean matchRegex(String s) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(s);
        return (matcher.matches());
    }
}
