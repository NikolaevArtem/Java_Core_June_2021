package homework_5.custom_regex_matcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomRegexMatcher {

    final private String regex_email = "^[^0-9]\\w+@[^0-9]\\w+(\\.[a-z]{2,3}){1,2}$";
    //regex issues:
    //username doesn't start with digit
    //domain name doesn't start with digit
    //domain zone length 2 or 3 chars
    //accepts one or double domain zone

    final void readFromConsole(){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter your email: ");
            String inputString = reader.readLine();
            System.out.println(inputString.matches(regex_email));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
