package homework_6.map_problems_generator;

public class MapProblemsGenerator {

    private StringBuilder value;

    public MapProblemsGenerator(StringBuilder value) {
        this.value = value;
    }

    public StringBuilder getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsGenerator that = (MapProblemsGenerator) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.toString().hashCode();
    }
}
