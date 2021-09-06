package homework_6.map_problems_generator;

public class MapProblemsCollisionGenerator<F1, F2>{
    private F1 f1;
    private F2 f2;

    public MapProblemsCollisionGenerator(F1 f1, F2 f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    public F1 getF1() {
        return f1;
    }

    public F2 getF2() {
        return f2;
    }

    public void setF1(F1 f1) {
        this.f1 = f1;
    }

    public void setF2(F2 f2) {
        this.f2 = f2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsCollisionGenerator<?, ?> that = (MapProblemsCollisionGenerator<?, ?>) o;
        return f1.equals(that.f1) &&
                f2.equals(that.f2);
    }

    @Override
    public final int hashCode() {
        return 1;
    }
}
