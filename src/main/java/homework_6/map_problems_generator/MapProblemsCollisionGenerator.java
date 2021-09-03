package homework_6.map_problems_generator;

public class MapProblemsCollisionGenerator {
    private int value;

    public MapProblemsCollisionGenerator(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsCollisionGenerator that = (MapProblemsCollisionGenerator) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
