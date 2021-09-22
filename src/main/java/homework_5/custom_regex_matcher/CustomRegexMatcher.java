package homework_5.custom_regex_matcher;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomRegexMatcher {

    private boolean checkString(String st){
        String myRegex = "\\{\"users\":\\[(\\{\"userName\":\"[a-zA-Z]{1}[a-zA-Z0-9]{4,19}\"(,\"justName\":\"[A-Z]{1}[a-zA-z\\-]{1,30}\")?}(,)?)*]}";
        return Pattern.matches(myRegex, st);
    }

    public void run(){
        try(Scanner scanner = new Scanner(System.in)){
            String string = scanner.next();
            if (checkString(string)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
