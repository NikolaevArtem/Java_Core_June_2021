package homework_5.powerOfNumber;

import java.util.regex.Pattern;

public class CustomRegexMatcher {

    public void run(String str) {
        System.out.println  (Pattern.matches ("(GET |POST |PUT |DELETE )\\/api/v1/.*", str));
    }

}
