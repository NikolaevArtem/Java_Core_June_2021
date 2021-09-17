package course_project.field_components;

import course_project.SeaBattle;

public class Coordinate {
    public final int row;
    public final int column;

    public Coordinate(String point) {
        row = Integer.parseInt(point.substring(1)) - 1;
        column = point.charAt(0) - 65;
    }

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public static boolean check(String point) {
        String regex = String.format("[A-%s][1-9]\\d?",(char) (SeaBattle.FIELD_SIZE + 65));
        return point.matches(regex) &&
                0 <= Integer.parseInt(point.substring(1)) &&
                Integer.parseInt(point.substring(1)) <= SeaBattle.FIELD_SIZE;
    }
}
