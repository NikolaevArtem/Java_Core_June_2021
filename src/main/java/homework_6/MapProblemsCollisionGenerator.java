package homework_6;

import java.util.Objects;

public class MapProblemsCollisionGenerator {

    private final String name;

    public MapProblemsCollisionGenerator(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsCollisionGenerator that = (MapProblemsCollisionGenerator) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return  2;                  // collision generation
    }

    @Override
    public String toString() {
        return "MapProblemsCollisionGenerator{" +
                "name='" + name + '\'' +
                '}';
    }
}
