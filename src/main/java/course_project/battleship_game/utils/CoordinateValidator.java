package course_project.battleship_game.utils;

import static course_project.battleship_game.utils.Constants.CELL_INT_UPPER_BOUND;
import static course_project.battleship_game.utils.Constants.CHAR_LOWER_BOUND;
import static course_project.battleship_game.utils.Constants.CHAR_UPPER_BOUND;
import static course_project.battleship_game.utils.Constants.LOWER_BOUND;
import static course_project.battleship_game.utils.Constants.UPPER_BOUND;

public class CoordinateValidator {

    public static boolean isCoordinate(String coordinate) {
        if (coordinate.length() > 3) {
            return false;
        }
        boolean isFirstLetter = CHAR_LOWER_BOUND < coordinate.toUpperCase().charAt(0) &&
                coordinate.toUpperCase().charAt(0) < CHAR_UPPER_BOUND;
        boolean isNumber = coordinate.length() > 1 && isSuitableForCellCoordinate(coordinate.substring(1));
        return isFirstLetter && isNumber;
    }

    private static boolean isSuitableForCellCoordinate(String str) {
        int count = 0;
        for (int ch : str.toCharArray()) {
            if (LOWER_BOUND <= ch && ch < UPPER_BOUND) {
                count++;
            }
        }
        if (count == str.length()) {
            int i = Integer.parseInt(str);
            return 0 < i && i < CELL_INT_UPPER_BOUND;
        }
        return false;
    }
}
