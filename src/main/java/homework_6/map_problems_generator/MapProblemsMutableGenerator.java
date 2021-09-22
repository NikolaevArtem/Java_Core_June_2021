package homework_6.map_problems_generator;

import java.util.Objects;

public class MapProblemsMutableGenerator {

    private int weight;

    public MapProblemsMutableGenerator(int weight) {
        this.weight = weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsMutableGenerator that = (MapProblemsMutableGenerator) o;
        return weight == that.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }
}
