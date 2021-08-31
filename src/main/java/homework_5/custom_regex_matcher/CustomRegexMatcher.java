package homework_5.custom_regex_matcher;

import java.util.Scanner;

public class CustomRegexMatcher {
    public void run() {
        System.out.println("Please enter a valid ipv4 address: ");
        String address = "";
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextLine()) {
                address = scanner.nextLine().trim();
            }
            System.out.println(isipv4Addr(address));
        }
    }

    private boolean isipv4Addr(String s) {
        String regex = "^((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]?)$";
        return s.matches(regex);
    }
}
