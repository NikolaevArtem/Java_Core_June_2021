package homework_5.custom_regex_matcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * CustomRegexMatcher
 * checks Russian Federation citizen passport data
 * in a current format:
 * [Passport Series] [Passport Number] [Surname] [Name] [Fathers name | optional]
 *
 * Examples which do match:
 * 9876 867576 Saltikova-Schedrina Mary-Jane Ivanovna
 * 9876867576 Saltikova Mary Semenova
 * 9876867576 Saltikova Mary-Jane
 * 9876   867576    Saltikova-Schedrina   Mary-Jane   Ivanovna
 *
 *
 * Examples which do not match:
 * 9876 867576 saltikova-Schedrina Mary-jane ivanovna
 * 9876 867576Schedrina MaryIvanovna
 */


public class CustomRegexMatcher {
    private final String russianFederationPassportData = "[0-9]{4} *[0-9]{6}( +[A-Z][a-z]+(-[A-Z][a-z]+)?){2,3}";

    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();

            System.out.println(input.matches(russianFederationPassportData));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
