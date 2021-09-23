package homework_5.custom_regex_matcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class CustomRegexMatcher {

    private final String javaFolder = "(java(\\/\\w+)*\\/[A-Z][a-z, A-Z, \\d]*\\.java)";
    private final String regex = "src\\/(main\\/(" + javaFolder + "|resources\\/\\w+(\\.[a-z]+)?)|test\\/" + javaFolder + ")";

    public void run() {
        System.out.println("Regex for a file path in java project starting in src/\n"
                + "Example: src/main/java/package_1/Class1.java");
        System.out.println(match());
    }

    private boolean match() {
        return Pattern.matches(regex, readString());
    }

    private String readString() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
