package course_project.SeaBattle.utility;

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

    public static boolean isLegalMode(String mod) {
        if (mod.matches("\\d+")) {
            return Integer.parseInt(mod) == 1 || Integer.parseInt(mod) == 0 ;
        }
        return false;
    }
}
