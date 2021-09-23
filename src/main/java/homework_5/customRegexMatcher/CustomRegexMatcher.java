package homework_5.customRegexMatcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomRegexMatcher {

    public void run() {
        System.out.println("Please, input your Email");
        try {
            String input = bufferedReaderReadConsole();
            System.out.println(regex(input));
        } catch (IOException | IllegalArgumentException ex) {
            System.out.println(false);
        }
    }

    private String bufferedReaderReadConsole() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String str = reader.readLine();
            if (str == null) {
                throw new IllegalArgumentException();
            }
            return str;
        }
    }

    public boolean regex(String s) {
        return s.matches("[\\w\\.\\-+!#%$&'*/=?`^{|}~]+@[\\w\\.]+\\.(com|ru|ua|kz|by)");
    }
}
