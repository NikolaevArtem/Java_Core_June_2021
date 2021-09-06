package homework_6.map_problems_generator;

import java.util.Objects;

public class MapProblemsMutableGenerator<F1> {
    private F1 f1;

    public MapProblemsMutableGenerator(F1 f1) {
        this.f1 = f1;
    }

    public F1 getF1() {
        return f1;
    }

    public void setF1(F1 f1) {
        this.f1 = f1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsMutableGenerator<?> that = (MapProblemsMutableGenerator<?>) o;
        return f1.equals(that.f1);
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(f1);
    }
}
