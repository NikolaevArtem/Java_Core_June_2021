package course_project.models;

import java.util.Locale;
import java.util.Objects;

public class Coordinate {
    private int col;
    private int row;

    public Coordinate(String s) {
        col = s.toLowerCase(Locale.ROOT).charAt(0) - 97;
        row = Integer.parseInt(s.substring(1));
    }

    public Coordinate(int r, int c) {
        this.row = r;
        this.col = c;
    }

    public Coordinate(Coordinate c) {
        this.row = c.row;
        this.col = c.col;
    }

    @Override
    public String toString() {
        return "" + (char) (col + 97) + row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        Coordinate that = (Coordinate) o;
        return col() == that.col() && row() == that.row();
    }

    @Override
    public int hashCode() {
        return Objects.hash(col(), row());
    }

    public int col() {
        return col;
    }

    public int row() {
        return row;
    }

    public boolean exists() {
        return this.row >= 1 && this.row <= 10 && this.col >= 0 && this.col <= 9;
    }

    public Coordinate upper() {
        return new Coordinate(this.row - 1, this.col);
    }

    public Coordinate lower() {
        return new Coordinate(this.row + 1, this.col);
    }

    public Coordinate lower(int n) {
        return new Coordinate(this.row + n, this.col);
    }

    public Coordinate toLeft() {
        return new Coordinate(this.row, this.col - 1);
    }

    public Coordinate toRight() {
        return new Coordinate(this.row, this.col + 1);
    }
}
