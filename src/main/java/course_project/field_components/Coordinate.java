package course_project.field_components;

import course_project.SeaBattle;

public class Coordinate implements Comparable<Coordinate>{
    public final int row;
    public final int column;

    private Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public static Coordinate get(String point) {
        if (check(point)) {
            int row = Integer.parseInt(point.substring(1)) - 1;
            int column = point.charAt(0) - 65;
            return new Coordinate(row, column);
        } else {
            return null;
        }
    }

    public static Coordinate get(int row, int column) {
        if (0 <= row && row < SeaBattle.FIELD_SIZE &&
                0 <= column && column < SeaBattle.FIELD_SIZE) {
            return new Coordinate(row, column);
        } else {
            return null;
        }
    }

    private static boolean check(String point) {
        String regex = String.format("[A-%s][1-9]\\d?",(char) (SeaBattle.FIELD_SIZE + 65));
        return point.matches(regex) &&
                0 <= Integer.parseInt(point.substring(1)) &&
                Integer.parseInt(point.substring(1)) <= SeaBattle.FIELD_SIZE;
    }

    @Override
    public int compareTo(Coordinate o) {
        return row == o.row ? Integer.compare(column, o.column) : Integer.compare(row, o.row);
    }

    @Override
    public String toString() {
        return String.format("%s%d", (char) (column + 65), row + 1);
    }
}
