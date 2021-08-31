package homework_6.map_problems_generator;

import java.util.HashMap;
import java.util.Objects;

public class MapProblemsCollisionGenerator {

    int id;

    public MapProblemsCollisionGenerator(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsCollisionGenerator that = (MapProblemsCollisionGenerator) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return 1 << 4;
    }
}
