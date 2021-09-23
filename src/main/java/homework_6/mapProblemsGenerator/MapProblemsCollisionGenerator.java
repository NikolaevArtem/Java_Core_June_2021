package homework_6.mapProblemsGenerator;

/**
 * Class MapProblemsCollisionGenerator with incorrect hashCode() method that creates
 * collisions every time.
 */

public final class MapProblemsCollisionGenerator {
    private final int someField;

    public MapProblemsCollisionGenerator(int n) {
        this.someField = n;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsCollisionGenerator generator = (MapProblemsCollisionGenerator) o;
        return someField == generator.someField;
    }

}
