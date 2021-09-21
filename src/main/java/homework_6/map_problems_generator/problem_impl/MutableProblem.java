package homework_6.map_problems_generator.problem_impl;

import homework_6.map_problems_generator.Problem;

public class MutableProblem<T> extends NoProblem<T> {
    public MutableProblem(T value) {
        super(value);
    }

    public void setValue(T value) {
        this.value = value;
    }
}
