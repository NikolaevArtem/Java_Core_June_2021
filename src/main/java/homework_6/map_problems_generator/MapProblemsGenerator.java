package homework_6.map_problems_generator;

import homework_6.map_problems_generator.problem_impl.CollisionProblem;
import homework_6.map_problems_generator.problem_impl.GettingProblem;
import homework_6.map_problems_generator.problem_impl.MutableProblem;
import homework_6.map_problems_generator.problem_impl.NoProblem;

public class MapProblemsGenerator <T> {

    public NoProblem<T> generateNoProblemClass(T value) {
        return new NoProblem<>(value);
    }

    public CollisionProblem<T> generateCollisionProblemClass(T value) {
        return new CollisionProblem<>(value);
    }

    public GettingProblem<T> generateGettingProblemClass(T value) {
        return new GettingProblem<>(value);
    }

    public MutableProblem<T> generateMutableProblemClass(T value) {
        return new MutableProblem<>(value);
    }
}
