package homework_6.map_problems_generator;

import java.util.Objects;

public class MapProblemsMutableGenerator{
    private StringBuilder key;

    public MapProblemsMutableGenerator(StringBuilder key) {
        this.key = key;
    }

    public void setKey(StringBuilder key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsMutableGenerator that = (MapProblemsMutableGenerator) o;
        return key.equals(that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
