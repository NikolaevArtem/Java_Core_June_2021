package homework_5.custom_regex_matcher;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CustomRegexMatcher {
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            String str = scanner.nextLine();
            //String str = "Java_Core_June_2021.package homework_5.custom_regex_matcher";
            String regex = ".[package\\s][homework_][1-9]+[.].";
            boolean result = validateString(str, regex);

            System.out.println(result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean validateString(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
}