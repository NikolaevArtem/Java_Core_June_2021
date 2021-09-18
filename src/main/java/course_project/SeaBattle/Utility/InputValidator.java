package course_project.SeaBattle.Utility;

import java.util.Locale;

public class InputValidator {

    public static boolean isLegalCoordinate(String s) {
        String string = s.toUpperCase(Locale.ROOT);
        int lengthString = string.length();

        if (lengthString != 2 && lengthString != 3) {
            return false;
        }

        int x = string.charAt(0);

        String ySubstring = string.substring(1);

        if (!ySubstring.matches("\\d+")) {
            return false;
        }

        int y = Integer.parseInt(ySubstring);

        return (65 <= x && x <= 74) && (1 <= y && y <= 10);
    }

    public static boolean isLegalDirection(String direction) {
        return direction.length() == 1 && direction.matches("^[0-1]+");
    }
}
