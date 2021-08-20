package homework_5.customRegexMatcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomRegexMatcher {
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String message = reader.readLine();
            System.out.println(checkMail(message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean checkMail(String str) {
        return str.matches("[0-9a-zA-Z_-]{5,}\\d*@\\w{2,}\\.\\w{2,}");
    }
}
