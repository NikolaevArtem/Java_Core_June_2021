package course_project.components;

import course_project.SeaBattle;

import java.util.Objects;

public class Coordinates {

    public final int x;
    public final int y;

    public Coordinates(int row, int column) {
        this.x = row;
        this.y = column;
    }



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
