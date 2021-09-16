package course_project;

import java.util.Objects;

public class Coordinate {
    final int row;
    final int column;
    int bordersNear = 0;

    public Coordinate(String point) {
        row = Integer.parseInt(point.substring(1)) - 1;
        column = point.charAt(0) - 65;
        countBorders(row);
        countBorders(column);
    }

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
        countBorders(row);
        countBorders(column);
    }

    public static boolean check(String point) {
        String regex = String.format("[A-%s][1-9]\\d?",(char) (SeaBattle.FIELD_SIZE + 65));
        return point.matches(regex) && Integer.parseInt(point.substring(1)) <= SeaBattle.FIELD_SIZE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return row == that.row && column == that.column;
    }

    private void countBorders(int i) {
        if (i == 0 || i == 9) {
            bordersNear++;
        }
    }



    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
