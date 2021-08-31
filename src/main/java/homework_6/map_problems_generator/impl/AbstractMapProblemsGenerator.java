package homework_6.map_problems_generator.impl;

import homework_6.map_problems_generator.MapProblemsGenerator;

import java.util.Objects;

public abstract class AbstractMapProblemsGenerator<T> implements MapProblemsGenerator<T> {
    private final T value;

    public AbstractMapProblemsGenerator(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractMapProblemsGenerator<?> that = (AbstractMapProblemsGenerator<?>) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
