package homework_6.map_problems_generator.impl;

public class MutableMapProblemsGeneratorKey<T> extends AbstractMapProblemsGenerator<T> {
    private int id;

    public MutableMapProblemsGeneratorKey(int id) {
        super(null);
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MutableMapProblemsGeneratorKey<?> that = (MutableMapProblemsGeneratorKey<?>) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}