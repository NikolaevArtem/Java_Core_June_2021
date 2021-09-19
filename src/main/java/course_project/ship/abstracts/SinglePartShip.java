package course_project.ship.abstracts;

import java.util.Objects;

public class SinglePartShip {
    
    private Integer x;
    private Integer y;

    public SinglePartShip(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public SinglePartShip setX(Integer x) {
        return new SinglePartShip(x, this.y);
    }

    public Integer getY() {
        return y;
    }

    public SinglePartShip setY(Integer y) {
        return new SinglePartShip(this.x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinglePartShip partShip = (SinglePartShip) o;
        return Objects.equals(x, partShip.x) && Objects.equals(y, partShip.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
