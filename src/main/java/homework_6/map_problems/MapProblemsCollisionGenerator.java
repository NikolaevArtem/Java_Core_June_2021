package homework_6.map_problems;

import java.awt.*;

public class MapProblemsCollisionGenerator extends MapProblemsGenerator {

    public MapProblemsCollisionGenerator(String clazzName, int clazzAge, Color clazzColor) {
        super(clazzName, clazzAge, clazzColor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsCollisionGenerator that = (MapProblemsCollisionGenerator) o;
        return clazzAge == that.clazzAge && clazzName.equals(that.clazzName) && clazzColor.equals(that.clazzColor);
    }
    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "MapProblemsCollisionGenerator{" +
                "clazzName='" + clazzName + '\'' +
                ", clazzAge=" + clazzAge +
                ", clazzColor=" + clazzColor +
                '}';
    }
}
