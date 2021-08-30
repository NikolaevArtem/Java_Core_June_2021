package homework_6.map_problems_generator.problem_impl;

import java.util.Random;

public class GettingProblem <T> extends NoProblem <T> {

    public GettingProblem(T value) {
        super(value);
    }

    @Override
    public int hashCode() {
        return new Random().nextInt();
    }
}
