package homework_6.map_problems_generator.problem_impl;

import homework_6.map_problems_generator.Problem;

import java.util.Objects;

public class NoProblem <T> implements Problem<T> {
    protected T value;

    public NoProblem(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoProblem<?> noProblem = (NoProblem<?>) o;

        return Objects.equals(value, noProblem.value);
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
