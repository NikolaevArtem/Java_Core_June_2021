package homework_5.custom_regex_matcher;

import homework_2.ConsoleSafeReader;

public class CustomRegexMatcher {

    public void run() {
        System.out.println("Allowed formats of phone numbers:");
        System.out.println("+7-(XXX)-XXX-XX-XX");
        System.out.println("where X - digits from 0 to 9");
        System.out.println("You can: use 8 instead of +7, use space instead of dash anyway, don't use parentheses");
        System.out.println("         use space instead of dash anyway, don't use parentheses");
        System.out.println("         don't use parentheses for the first triple");
        System.out.println("Enter phone number:");
        String input = ConsoleSafeReader.read();
        String regex = "((\\+7)|8)[- ]((\\(\\d{3}\\))|\\d{3})[- ]\\d{3}([ -]\\d{2}){2}";
        System.out.println(input.matches(regex));
    }
}
