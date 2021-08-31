package homework_6.mapProblemsGenerator;

import java.util.Objects;

/**
 * Class Dog with mutable field age.
 */

public final class MapProblemsMutableGenerator {
    private int someField;

    public MapProblemsMutableGenerator(int n) {
        this.someField = n;
    }

    public int getSomeField() {
        return someField;
    }

    public void setSomeField(int someField) {
        this.someField = someField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsMutableGenerator generator = (MapProblemsMutableGenerator) o;
        return someField == generator.someField;
    }

    @Override
    public int hashCode() {
        return Objects.hash(someField);
    }

}
