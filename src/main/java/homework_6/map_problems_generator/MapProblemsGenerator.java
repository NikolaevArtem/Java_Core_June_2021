package homework_6.map_problems_generator;

import homework_6.map_problems_generator.problem_impl.CollisionProblem;
import homework_6.map_problems_generator.problem_impl.GettingProblem;
import homework_6.map_problems_generator.problem_impl.NoProblem;

public class MapProblemsGenerator <T> {

    public NoProblem<?> generateNoProblemClass(T value) {
        return new NoProblem<>(value);
    }

    public CollisionProblem<?> generateCollisionProblemClass(T value) {
        return new CollisionProblem<>(value);
    }

    public GettingProblem<?> generateGettingProblemClass(T value) {
        return new GettingProblem<>(value);
    }
}
