package course_project.battleship_game.utils;

public class CoordinateValidator {

    public static boolean isCoordinate(String coordinate) {
        if (coordinate.length() > 3) {
            return false;
        }
        boolean isFirstLetter = coordinate.toUpperCase().charAt(0) > 64 &&
                coordinate.toUpperCase().charAt(0) < 75;
        boolean isNumber = coordinate.length() > 1 && isSuitableForCellCoordinate(coordinate.substring(1));
        return isFirstLetter && isNumber;
    }

    private static boolean isSuitableForCellCoordinate(String str) {
        int count = 0;
        for (int ch : str.toCharArray()) {
            if (48 <= ch && ch < 58) {
                count++;
            }
        }
        if (count == str.length()) {
            int i = Integer.parseInt(str);
            return 0 < i && i < 11;
        }
        return false;
    }
}
