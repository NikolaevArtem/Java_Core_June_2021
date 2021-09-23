package homework_6.map_problems_generator;

public class MapProblemsCollisionGenerator {

    private final String value;

    public MapProblemsCollisionGenerator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
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
        return 1;
    }
}
