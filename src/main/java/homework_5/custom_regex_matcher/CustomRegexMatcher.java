package homework_5.custom_regex_matcher;

import java.util.Scanner;

public class CustomRegexMatcher {

    public boolean isValidPhoneNumber(String number){
        return number.matches("\\+?[7|8]\\s?[(-.\\s]?\\d{3}[)-.\\s]?\\s?\\d{3}[-.\\s]?\\d{2}[-.\\s]?\\d{2}");
    }

    public void run() {
        System.out.print("Enter a phone number: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entered the phone number is valid: " + (isValidPhoneNumber(scanner.nextLine())));
    }
}
