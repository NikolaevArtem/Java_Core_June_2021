package course_project.sea_battle.model;

import lombok.Data;

@Data
public class Point {
    private final int x;
    private final int y;

    @Override
    public String toString() {
        return "[" + x +
                "," + y +
                "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(x) + Integer.hashCode(y);
    }
}
