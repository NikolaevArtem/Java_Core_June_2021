package homework_6.map_problems;

import java.awt.*;
import java.util.Random;

public class MapProblemsMutableGenerator extends MapProblemsGenerator {

    public MapProblemsMutableGenerator(String clazzName, int clazzAge, Color clazzColor) {
        super(clazzName, clazzAge, clazzColor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsMutableGenerator that = (MapProblemsMutableGenerator) o;
        return clazzAge == that.clazzAge && clazzName.equals(that.clazzName) && clazzColor.equals(that.clazzColor);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(clazzAge) + clazzName.hashCode();
    }

    @Override
    public String toString() {
        return "MapProblemsMutableGenerator{" +
                "clazzName='" + clazzName + '\'' +
                ", clazzAge=" + clazzAge +
                ", clazzColor=" + clazzColor +
                '}';
    }
}
