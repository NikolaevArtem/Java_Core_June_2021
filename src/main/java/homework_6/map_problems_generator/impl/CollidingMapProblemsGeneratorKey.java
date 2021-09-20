package homework_6.map_problems_generator.impl;

public class CollidingMapProblemsGeneratorKey<T> extends AbstractMapProblemsGenerator<T> {

    public CollidingMapProblemsGeneratorKey() {
        super(null);
    }

    public CollidingMapProblemsGeneratorKey(T value) {
        super(value);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
