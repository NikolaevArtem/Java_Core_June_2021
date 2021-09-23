package homework_6.map_problems_generator;

public class MapProblemsCollisionGenerator {

    private int a;

    public MapProblemsCollisionGenerator(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsCollisionGenerator that = (MapProblemsCollisionGenerator) o;
        return a == that.a;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
