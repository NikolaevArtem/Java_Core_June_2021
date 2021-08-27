package homework_5.custom_regex_matcher;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomRegexMatcher {

    public boolean isValidNumber(String number){
        return Pattern.compile("\\+?[7|8] ?[(-. ]?\\d{3}[)-. ]? ?\\d{3}[-. ]?\\d{2}[-. ]?\\d{2}").matcher(number).matches();
    }

    public void run() {
        System.out.print("Enter a phone number: ");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        System.out.println("Entered the phone number is valid: " + (isValidNumber(number)));
    }
}
