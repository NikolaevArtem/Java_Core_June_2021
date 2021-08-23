package homework_5.custom_regex_matcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Moderate password matcher
public class CustomRegexMatcher {
    private final String regex = "(?=(.*[0-9]))((?=.*[A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z]))^.{8,}$";
    public void run(){
        System.out.println("Enter password-ish string, should have 1 lowercase letter, 1 uppercase letter, 1 number, and be at least 8 characters long");
        String input = getInput();
        System.out.println(input.matches(regex));
    }

    private String getInput() {
        String result = "defaultString";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            result = reader.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }
}
