package homework_5.custom_regex_matcher;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomRegexMatcher {

    private final String ADDRESS = "[A-Za-z ]{1,}[\\d{1,3}]{1,3}[/\\d{1,3}]*";

    public void run() {
        Scanner in = new Scanner(System.in);

        System.out.println("Input your address: ");
        String address = in.nextLine();

        checkAddress(address);
    }

    public void checkAddress(String address) {
        Pattern pattern = Pattern.compile(ADDRESS);
        Matcher matcher = pattern.matcher(address);
        System.out.println(matcher.matches());
    }
}
