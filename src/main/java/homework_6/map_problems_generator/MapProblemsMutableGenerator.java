package homework_6.map_problems_generator;

import java.util.Random;

public class MapProblemsMutableGenerator {

    private String value;

    public MapProblemsMutableGenerator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        MapProblemsCollisionGenerator example = (MapProblemsCollisionGenerator) obj;

        return (value != null && value.equals(example.getValue()));
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
