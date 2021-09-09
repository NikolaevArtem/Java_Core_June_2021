package homework_5.custom_regex_matcher;

import java.util.Scanner;

public class CustomRegexMatcher {

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your password: ");

        String str = sc.nextLine();
        System.out.println("Password security: " + str.matches("^(?=.*[0-9].*)(?=.*[a-z].*)(?=.*[A-Z].*)(?=.*[!$%#^].*)[0-9a-zA-Z!$%#^]{8,}$"));
    }
}
