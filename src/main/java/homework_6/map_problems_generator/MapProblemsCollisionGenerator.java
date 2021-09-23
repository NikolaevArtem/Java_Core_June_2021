package homework_6.map_problems_generator;

import java.util.Objects;

public class MapProblemsCollisionGenerator {

    private Integer countCollision = 0;
    private StringBuilder key;

    public MapProblemsCollisionGenerator(StringBuilder key) {
        this.key = key;
    }

    public void setKey(StringBuilder key) {
        this.key = key;
    }

    public Integer getCountCollision()
    {
        return countCollision;
    }

    @Override
    public boolean equals(Object o) {
        countCollision++;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsCollisionGenerator that = (MapProblemsCollisionGenerator) o;
        return key.equals(that.key);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
