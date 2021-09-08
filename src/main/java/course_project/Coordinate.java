package course_project;

import java.util.Objects;

public class Coordinate {
    final int row;
    final int column;

    public Coordinate(String point) {
        row = Integer.parseInt(point.substring(1)) - 1;
        column = point.charAt(0) - 65;
    }

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
