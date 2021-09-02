package homework_5.customRegexMatcher;

public class Main {
    public static void main(String[] args) {

        String string = "192.168.00.00 - - [10/Jun/2021:07:21:22 +0000] PUT /api/v1/user/favorites HTTP/1.1 200 45 https://test.lab/login";

        CustomRegexMatcher customRegexMatcher = new CustomRegexMatcher();
        customRegexMatcher.run(string);
    }
}
