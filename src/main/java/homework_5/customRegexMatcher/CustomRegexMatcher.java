package homework_5.customRegexMatcher;

import homework_5.AppHW_5;

public class CustomRegexMatcher extends AppHW_5 {
    private final static String PATTERN_STRING = "[0-9a-zA-Z_]+@[0-9a-zA-Z_]+\\.[a-zA-Z]{2,3}";

    public CustomRegexMatcher() {
        super(PATTERN_STRING);
    }

    public String run() {
        readData();
        String result = String.valueOf(check());
        System.out.println(result);
        closeReader();
        return result;
    }

    public static void main(String[] args) {
        new CustomRegexMatcher().run();
    }
}
