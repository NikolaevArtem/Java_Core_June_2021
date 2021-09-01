package homework_5.custom_regex_matcher;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomRegexMatcherTest {

    @Test
    void testRightCaseCustomRegexMatcher() {
        CustomRegexMatcher crm = new CustomRegexMatcher();

        String str = "Java_Core_June_2021.package homework_5.custom_regex_matcher";
        String str2 = "Java_Core_June_2019...package homework_5.custom_regex_matcher";
        String str3 = "Java_Core_June_2019.package homework_444466665.custom_regex_matcher";
        String regex = ".[package\\s][homework_][1-9]+[.].";

        Assertions.assertTrue(crm.validateString(str, regex));
        Assertions.assertTrue(crm.validateString(str2, regex));
        Assertions.assertTrue(crm.validateString(str3, regex));
    }

    @Test
    void testWrongCaseCustomRegexMatcher() {
        CustomRegexMatcher crm = new CustomRegexMatcher();

        String str = "Java_Core_June_2021.package homework5.custom_regex_matcher";
        String str2 = "Java_Core_June_2021.package_homework.custom_regex_matcher";
        String str3 = "Java_Core_June_2021.package_homework";
        String regex = ".[package\\s][homework_][1-9]+[.].";

        Assertions.assertFalse(crm.validateString(str, regex));
        Assertions.assertFalse(crm.validateString(str2, regex));
        Assertions.assertFalse(crm.validateString(str3, regex));
    }
}